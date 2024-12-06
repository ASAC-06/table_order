package asac.hackathon.table_order.table_order.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@ToString
@AllArgsConstructor
public enum PaymentsStatus {

    READY("결제 준비"),
    COMPLETE("결제 완료"),
    CANCEL("결제 취소");

    private final String statusText;

    public static PaymentsStatus deserialize(String type) {
        for (PaymentsStatus paymentsStatus : PaymentsStatus.values()) {
            if (paymentsStatus.name().equals(type.toUpperCase())) {
                return paymentsStatus;
            }
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "상품 상태가 잘못 됐습니다.");
    }
}
