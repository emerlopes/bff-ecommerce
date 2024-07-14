package br.com.emerlopes.bffecommerce.repository;

import br.com.emerlopes.bffecommerce.domain.entity.PaymentDomainEntity;
import br.com.emerlopes.bffecommerce.domain.repository.PaymentDomainRepository;
import br.com.emerlopes.bffecommerce.domain.shared.RequestParametersStore;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.mspayment.PaymentClient;
import br.com.emerlopes.bffecommerce.infrastructure.integrations.mspayment.request.PaymentRequestDTO;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;


@Service
public class PaymentDomainRepositoryImpl implements PaymentDomainRepository {

    private final static Logger logger = org.slf4j.LoggerFactory.getLogger(PaymentDomainRepositoryImpl.class);
    private final PaymentClient paymentClient;

    public PaymentDomainRepositoryImpl(
            final PaymentClient paymentClient
    ) {
        this.paymentClient = paymentClient;
    }

    @Override
    public PaymentDomainEntity processPayment(
            final PaymentDomainEntity payment
    ) {

        final var authorization = RequestParametersStore.getAuthorization();

        final var paymentRequestDTO = PaymentRequestDTO.builder()
                .orderId(payment.getOrderId())
                .paymentMethod(payment.getPaymentMethod())
                .amount(payment.getAmount())
                .build();

        final var savedPayment = paymentClient.processPayment(
                authorization,
                paymentRequestDTO.getOrderId(),
                paymentRequestDTO
        );

        if (savedPayment == null) {
            logger.error("Error processing payment");
            return null;
        }

        if (savedPayment.getData() == null) {
            logger.error("Error processing payment");
            return null;
        }

        final var data = savedPayment.getData();

        logger.info("Payment processed: {}", data.getPaymentId());

        return PaymentDomainEntity.builder()
                .paymentId(data.getPaymentId())
                .orderId(data.getOrderId())
                .paymentMethod(data.getPaymentMethod())
                .paymentDate(data.getPaymentDate())
                .amount(data.getAmount())
                .paymentDate(data.getPaymentDate())
                .status(data.getStatus())
                .build();
    }

}
