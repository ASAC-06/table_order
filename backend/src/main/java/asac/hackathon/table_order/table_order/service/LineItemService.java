package asac.hackathon.table_order.table_order.service;

import asac.hackathon.table_order.table_order.controller.dto.LineItemCalculateResultDto;
import asac.hackathon.table_order.table_order.controller.dto.OrderLineItemRequestDto;
import asac.hackathon.table_order.table_order.controller.dto.OrderResponseDto;
import asac.hackathon.table_order.table_order.entity.OrderLineItem;
import asac.hackathon.table_order.table_order.entity.SellingItem;
import asac.hackathon.table_order.table_order.repository.ItemRepository;
import asac.hackathon.table_order.table_order.repository.LineItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LineItemService {

    private final LineItemRepository lineItemRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public LineItemCalculateResultDto saveList(OrderResponseDto dto, List<OrderLineItemRequestDto> requests) {

        int totalAmount = 0;
        int totalPrice = 0;

        for (OrderLineItemRequestDto request : requests) {

            SellingItem sellingItem = itemRepository.findById(request.getItemId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid item ID: " + request.getItemId()));

            OrderLineItem orderLineItem = new OrderLineItem();
            orderLineItem.setSellingItem(sellingItem);
            orderLineItem.setItemName(request.getItemName());
            orderLineItem.setItemPrice(request.getItemPrice());
            orderLineItem.setAmount(request.getAmount());

            lineItemRepository.save(orderLineItem);

            totalAmount += request.getAmount();
            totalPrice += request.getItemPrice() * request.getAmount();
        }

        // 결과 DTO 반환
        LineItemCalculateResultDto result = new LineItemCalculateResultDto();
        result.setAmount(totalAmount);
        result.setTotalPrice(totalPrice);
        return result;
    }


}
