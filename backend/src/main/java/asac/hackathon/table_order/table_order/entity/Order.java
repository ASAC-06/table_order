package asac.hackathon.table_order.table_order.entity;

import asac.hackathon.table_order.table_order.controller.dto.LineItemCalculateResultDto;
import asac.hackathon.table_order.table_order.controller.dto.OrderRequestDto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order extends BaseEntity {

    Long orderNumber;
    Integer tableNumber;
    Integer totalAmount;
    Integer totalPrice;

    @Column(name = "payments_status")
    @Enumerated(EnumType.STRING)
    @Setter
    PaymentsStatus paymentsStatus;

    @Lob
    @Setter
    String tosPaymentsRowData;

    LocalDateTime paidAt;
    LocalDateTime confirmedAt;

    public static Order firstOrder(OrderRequestDto orderRequestDto) {
        return new Order(
                orderNumberCreator(orderRequestDto.getTableNumber()),
                orderRequestDto.getTableNumber(),
                0,
                0,
                PaymentsStatus.READY,
                "",
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    public static Long orderNumberCreator(Integer tableNumber) {
        // 년월일 + 테이블번호(4자리) + 랜덤숫자(6자리)
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
        String tableNumberText = "00000" + tableNumber;
        String subText = tableNumberText.substring(tableNumberText.length() - 4, tableNumberText.length());
        SecureRandom random = new SecureRandom();
        String left = random.nextInt(100000, 999999) + "";
        return Long.parseLong(date + subText + left);
    }

    public void orderAmountAndTotalPriceUpdate(LineItemCalculateResultDto resultDto) {
        this.totalAmount = resultDto.getAmount();
        this.totalPrice = resultDto.getTotalPrice();
        setUpdatedAt(LocalDateTime.now());
    }

}
