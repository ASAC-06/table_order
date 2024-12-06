package asac.hackathon.table_order.table_order.controller.dto;

import asac.hackathon.table_order.table_order.entity.ItemCategory;
import asac.hackathon.table_order.table_order.entity.ItemEntityEnum;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SellingItemRequestDto {
    private String categoryName;
    private String name;
    private Integer price;
    private ItemEntityEnum status;
    private String description;
    private String profilePath;

}
