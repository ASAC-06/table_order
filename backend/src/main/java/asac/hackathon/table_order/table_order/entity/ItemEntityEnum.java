package asac.hackathon.table_order.table_order.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum ItemEntityEnum {
    A("판매중"),
    D("판매 안함"),
    SO("매진");

    private final String statusText;
}
