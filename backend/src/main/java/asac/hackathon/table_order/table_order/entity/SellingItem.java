package asac.hackathon.table_order.table_order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SellingItem extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "category_id")
    ItemCategory itemCategory;

    String name;
    Integer price;
    String status;
    @Lob
    String description;
    @Lob
    String profilePath;

}
