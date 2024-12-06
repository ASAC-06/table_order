package asac.hackathon.table_order.table_order.controller.dto;

import asac.hackathon.table_order.table_order.entity.ItemCategory;
import asac.hackathon.table_order.table_order.entity.ItemEntityEnum;
import asac.hackathon.table_order.table_order.entity.SellingItem;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ItemResponseDto {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String name;
    private Integer price;
    private ItemEntityEnum status;
    private String description;
    private String profilePath;

    // ItemCategory 필드
    private Long categoryId;
    private String categoryName;
    private Integer categoryPriority;

    public static ItemResponseDto from(SellingItem sellingItem) {
        ItemCategory category = sellingItem.getItemCategory();
        return new ItemResponseDto(
                sellingItem.getId(),                       // BaseEntity 필드
                sellingItem.getCreatedAt(),
                sellingItem.getUpdatedAt(),
                sellingItem.getName(),                     // SellingItem 필드
                sellingItem.getPrice(),
                sellingItem.getEntityEnumStatus(),
                sellingItem.getDescription(),
                sellingItem.getProfilePath(),
                category != null ? category.getId() : null,  // ItemCategory 필드
                category != null ? category.getName() : null,
                category != null ? category.getPriority() : null
        );
    }

}
