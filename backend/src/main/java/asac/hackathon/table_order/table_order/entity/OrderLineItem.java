package asac.hackathon.table_order.table_order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderLineItem extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "item_id")
    SellingItem sellingItem;

    @ManyToOne
    @JoinColumn(name = "order_id")
    Order order;

    String itemName;
    Integer itemPrice;
    Integer amount;
}
