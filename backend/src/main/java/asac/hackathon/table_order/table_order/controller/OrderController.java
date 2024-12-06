package asac.hackathon.table_order.table_order.controller;

import asac.hackathon.table_order.table_order.controller.dto.LineItemCalculateResultDto;
import asac.hackathon.table_order.table_order.controller.dto.OrderLineItemRequestDto;
import asac.hackathon.table_order.table_order.controller.dto.OrderRequestDto;
import asac.hackathon.table_order.table_order.controller.dto.OrderResponseDto;
import asac.hackathon.table_order.table_order.service.LineItemService;
import asac.hackathon.table_order.table_order.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final LineItemService lineItemService;

    @PostMapping("")
    public ResponseEntity<LineItemCalculateResultDto> OrderSave(@RequestBody OrderRequestDto request) {

        //최초 주문 생성
        OrderResponseDto orders = orderService.orderCreate(request);
        log.error(request.getTableNumber() + "");

        for (OrderLineItemRequestDto dto : request.getLineItemList()){
            log.error(dto.getItemName() + "-------------------");
        }



        // 리스트 아이템 넣기
        LineItemCalculateResultDto resultDto = lineItemService.saveList(/*orders,*/ request.getLineItemList());

        // 주문목록과 리스트 동기화
//        orderService.synchronizeOrder(resultDto);

        return ResponseEntity.status(HttpStatus.OK).body(resultDto);
    }

}
