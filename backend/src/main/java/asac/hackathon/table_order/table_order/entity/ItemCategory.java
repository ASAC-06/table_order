package asac.hackathon.table_order.table_order.entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemCategory extends BaseEntity {

    String name;
    Integer priority;

}
