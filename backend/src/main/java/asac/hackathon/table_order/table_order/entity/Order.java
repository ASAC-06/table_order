package asac.hackathon.table_order.table_order.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order extends BaseEntity {

    Long orderNumber;
    Integer tableNumber;
    Integer totalAmount;
    Integer totalPrice;


    @Column(name = "payments_status")
    @Enumerated(EnumType.STRING)
    PaymentsStatus paymentsStatus;

    @Lob
    String tosPaymentsRowData;

    LocalDateTime paidAt;
    LocalDateTime confirmedAt;

}
