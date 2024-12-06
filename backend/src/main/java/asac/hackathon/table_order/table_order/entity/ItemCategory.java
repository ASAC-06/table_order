package asac.hackathon.table_order.table_order.entity;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
