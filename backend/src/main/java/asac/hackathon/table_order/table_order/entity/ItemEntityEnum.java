package asac.hackathon.table_order.table_order.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@ToString
@AllArgsConstructor
public enum ItemEntityEnum {
    A("판매중"),
    D("판매 안함"),
    SO("매진");

    private final String statusText;

    public static ItemEntityEnum deserialize(String type) {
        for (ItemEntityEnum postVoteType : ItemEntityEnum.values()) {
            if (postVoteType.name().equals(type.toUpperCase())) {
                return postVoteType;
            }
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "상품 상태가 잘못 됐습니다.");
    }
}
