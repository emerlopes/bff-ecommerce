package br.com.emerlopes.bffecommerce.application.shared.response;

public enum PaymentStatusEnum {
    PENDING("PENDING"),
    APPROVED("APPROVED"),
    DENIED("DENIED");

    private String status;

    PaymentStatusEnum(
            final String status
    ) {
        this.status = status;
    }

    public static PaymentStatusEnum fromString(
            final String status
    ) {
        for (PaymentStatusEnum paymentStatusEnum : PaymentStatusEnum.values()) {
            if (paymentStatusEnum.status.equalsIgnoreCase(status)) {
                return paymentStatusEnum;
            }
        }
        return null;
    }
}