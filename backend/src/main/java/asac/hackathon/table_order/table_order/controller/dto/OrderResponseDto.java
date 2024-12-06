package asac.hackathon.table_order.table_order.controller.dto;

import asac.hackathon.table_order.table_order.entity.Order;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponseDto {

    Long orderNumber;
    Integer tableNumber;
    Integer totalAmount;
    Integer totalPrice;
    String paymentStatus;

    public static OrderResponseDto from(Order order) {
        return new OrderResponseDto(
                order.getOrderNumber(),
                order.getTableNumber(),
                order.getTotalAmount(),
                order.getTotalPrice(),
                order.getPaymentsStatus().name()
        );
    }

}
