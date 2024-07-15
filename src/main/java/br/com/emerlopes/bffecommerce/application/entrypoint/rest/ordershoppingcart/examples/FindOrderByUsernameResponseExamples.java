package br.com.emerlopes.bffecommerce.application.entrypoint.rest.ordershoppingcart.examples;

import br.com.emerlopes.bffecommerce.infrastructure.integrations.shoppingcart.response.OrderResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Operation(
        summary = "Encontrar pedido por ID",
        description = "Retorna um pedido específico pelo ID",
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Resposta de sucesso",
                        content = @Content(
                                schema = @Schema(implementation = OrderResponseDTO.class),
                                examples = @ExampleObject(
                                        name = "Success Response",
                                        summary = "Exemplo de resposta bem-sucedida",
                                        value = """
                                                {
                                                 	"data": [
                                                 		{
                                                 			"id": 1,
                                                 			"username": "emerlopes",
                                                 			"products": [
                                                 				{
                                                 					"name": "Bike",
                                                 					"description": "New ABC 13 9370, 13.3, 5th Gen CoreA5-8250U, 8GB RAM, 256GB SSD, power UHD Graphics, OS 10 Home, OS Office A & J 2016",
                                                 					"price": 306.00,
                                                 					"quantity": 2
                                                 				},
                                                 				{
                                                 					"name": "Pants",
                                                 					"description": "The Apollotech B340 is an affordable wireless mouse with reliable connectivity, 12 months battery life and modern design",
                                                 					"price": 247.00,
                                                 					"quantity": 1
                                                 				}
                                                 			],
                                                 			"total": 859.00,
                                                 			"orderStatusEnum": "DONE",
                                                 			"createdAt": "2024-07-14T16:20:15.921333",
                                                 			"updatedAt": "2024-07-14T16:25:30.83802"
                                                 		},
                                                 		{
                                                 			"id": 2,
                                                 			"username": "emerlopes",
                                                 			"products": [
                                                 				{
                                                 					"name": "Hat",
                                                 					"description": "The Football Is Good For Training And Recreational Purposes",
                                                 					"price": 409.00,
                                                 					"quantity": 3
                                                 				},
                                                 				{
                                                 					"name": "Salad",
                                                 					"description": "New ABC 13 9370, 13.3, 5th Gen CoreA5-8250U, 8GB RAM, 256GB SSD, power UHD Graphics, OS 10 Home, OS Office A & J 2016",
                                                 					"price": 920.00,
                                                 					"quantity": 2
                                                 				}
                                                 			],
                                                 			"total": 3067.00,
                                                 			"orderStatusEnum": "PENDING",
                                                 			"createdAt": "2024-07-14T16:21:08.326147",
                                                 			"updatedAt": null
                                                 		},
                                                 		{
                                                 			"id": 3,
                                                 			"username": "emerlopes",
                                                 			"products": [
                                                 				{
                                                 					"name": "Pizza",
                                                 					"description": "Ergonomic executive chair upholstered in bonded black leather and PVC padded seat and back for all-day comfort and support",
                                                 					"price": 473.00,
                                                 					"quantity": 1
                                                 				},
                                                 				{
                                                 					"name": "Tuna",
                                                 					"description": "Boston's most advanced compression wear technology increases muscle oxygenation, stabilizes active muscles",
                                                 					"price": 791.00,
                                                 					"quantity": 2
                                                 				}
                                                 			],
                                                 			"total": 2055.00,
                                                 			"orderStatusEnum": "PENDING",
                                                 			"createdAt": "2024-07-14T16:21:20.480006",
                                                 			"updatedAt": null
                                                 		},
                                                 		{
                                                 			"id": 4,
                                                 			"username": "emerlopes",
                                                 			"products": [
                                                 				{
                                                 					"name": "Tuna",
                                                 					"description": "Boston's most advanced compression wear technology increases muscle oxygenation, stabilizes active muscles",
                                                 					"price": 784.00,
                                                 					"quantity": 3
                                                 				},
                                                 				{
                                                 					"name": "Salad",
                                                 					"description": "The slim & simple Maple Gaming Keyboard from Dev Byte comes with a sleek body and 7- Color RGB LED Back-lighting for smart functionality",
                                                 					"price": 931.00,
                                                 					"quantity": 5
                                                 				}
                                                 			],
                                                 			"total": 7007.00,
                                                 			"orderStatusEnum": "PENDING",
                                                 			"createdAt": "2024-07-14T16:22:16.753842",
                                                 			"updatedAt": null
                                                 		},
                                                 		{
                                                 			"id": 5,
                                                 			"username": "emerlopes",
                                                 			"products": [
                                                 				{
                                                 					"name": "Ball",
                                                 					"description": "Ergonomic executive chair upholstered in bonded black leather and PVC padded seat and back for all-day comfort and support",
                                                 					"price": 621.00,
                                                 					"quantity": 4
                                                 				},
                                                 				{
                                                 					"name": "Pants",
                                                 					"description": "Carbonite web goalkeeper gloves are ergonomically designed to give easy fit",
                                                 					"price": 349.00,
                                                 					"quantity": 2
                                                 				}
                                                 			],
                                                 			"total": 3182.00,
                                                 			"orderStatusEnum": "PENDING",
                                                 			"createdAt": "2024-07-14T16:23:15.788879",
                                                 			"updatedAt": null
                                                 		},
                                                 		{
                                                 			"id": 6,
                                                 			"username": "emerlopes",
                                                 			"products": [
                                                 				{
                                                 					"name": "Table",
                                                 					"description": "The Nagasaki Lander is the trademarked name of several series of Nagasaki sport bikes, that started with the 1984 ABC800J",
                                                 					"price": 363.00,
                                                 					"quantity": 3
                                                 				},
                                                 				{
                                                 					"name": "Shoes",
                                                 					"description": "The beautiful range of Apple Naturalé that has an exciting mix of natural ingredients. With the Goodness of 100% Natural Ingredients",
                                                 					"price": 940.00,
                                                 					"quantity": 4
                                                 				}
                                                 			],
                                                 			"total": 4849.00,
                                                 			"orderStatusEnum": "PENDING",
                                                 			"createdAt": "2024-07-14T16:24:03.786802",
                                                 			"updatedAt": null
                                                 		},
                                                 		{
                                                 			"id": 7,
                                                 			"username": "emerlopes",
                                                 			"products": [
                                                 				{
                                                 					"name": "Computer",
                                                 					"description": "New ABC 13 9370, 13.3, 5th Gen CoreA5-8250U, 8GB RAM, 256GB SSD, power UHD Graphics, OS 10 Home, OS Office A & J 2016",
                                                 					"price": 592.00,
                                                 					"quantity": 3
                                                 				},
                                                 				{
                                                 					"name": "Towels",
                                                 					"description": "New range of formal shirts are designed keeping you in mind. With fits and styling that will make you stand apart",
                                                 					"price": 821.00,
                                                 					"quantity": 1
                                                 				}
                                                 			],
                                                 			"total": 2597.00,
                                                 			"orderStatusEnum": "PENDING",
                                                 			"createdAt": "2024-07-14T16:25:20.873363",
                                                 			"updatedAt": null
                                                 		}
                                                 	]
                                                 }
                                                """
                                )
                        )
                )
        }
)
public @interface FindOrderByUsernameResponseExamples {
}