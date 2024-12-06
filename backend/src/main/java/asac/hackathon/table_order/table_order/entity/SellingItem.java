package asac.hackathon.table_order.table_order.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SellingItem extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "category_id")
    ItemCategory itemCategory;

    String name;
    Integer price;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    ItemEntityEnum entityEnumStatus;
    @Lob
    String description;
    @Lob
    String profilePath;

}
