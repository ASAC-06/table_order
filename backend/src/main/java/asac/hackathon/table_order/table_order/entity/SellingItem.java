package asac.hackathon.table_order.table_order.entity;

import asac.hackathon.table_order.table_order.controller.dto.SellingItemUpdateDto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SellingItem extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @Setter
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

    public static SellingItem from(ItemCategory category,String name, Integer price, ItemEntityEnum status,String description,String profilePath){
        return new SellingItem(category,name,price,status,description,profilePath);
    }

    public void updateForm(SellingItemUpdateDto sellingItemUpdateDto) {

        this.name = sellingItemUpdateDto.getName();
        this.price = sellingItemUpdateDto.getPrice();
        this.entityEnumStatus = ItemEntityEnum.deserialize(sellingItemUpdateDto.getStatus());
        this.profilePath = sellingItemUpdateDto.getProfilePath();
        this.description = sellingItemUpdateDto.getDescription();
        this.profilePath = sellingItemUpdateDto.getProfilePath();
    }

    @PostUpdate
    public void postUpdate() {
        setUpdatedAt(LocalDateTime.now());
    }
}
