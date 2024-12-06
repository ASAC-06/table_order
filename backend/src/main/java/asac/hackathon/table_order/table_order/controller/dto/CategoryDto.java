package asac.hackathon.table_order.table_order.controller.dto;

import asac.hackathon.table_order.table_order.entity.ItemCategory;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CategoryDto {

    private String categoryName;
    private Integer categoryPriority;

    public static CategoryDto from(ItemCategory category) {
        return new CategoryDto(
                category.getName(), category.getPriority()
        );
    }
}
