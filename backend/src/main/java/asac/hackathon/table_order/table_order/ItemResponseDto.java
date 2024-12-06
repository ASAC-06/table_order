package asac.hackathon.table_order.table_order;

import asac.hackathon.table_order.table_order.entity.ItemCategory;
import asac.hackathon.table_order.table_order.entity.SellingItem;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseDto {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String name;
    private Integer price;
    private String status;
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
            sellingItem.getStatus(),
            sellingItem.getDescription(),
            sellingItem.getProfilePath(),
            category != null ? category.getId() : null,  // ItemCategory 필드
            category != null ? category.getName() : null,
            category != null ? category.getPriority() : null
        );
    }

}
