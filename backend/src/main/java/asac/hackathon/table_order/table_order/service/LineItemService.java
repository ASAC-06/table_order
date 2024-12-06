package asac.hackathon.table_order.table_order.service;

import asac.hackathon.table_order.table_order.controller.dto.LineItemCalculateResultDto;
import asac.hackathon.table_order.table_order.controller.dto.OrderLineItemRequestDto;
import asac.hackathon.table_order.table_order.repository.LineItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LineItemService {

    private final LineItemRepository lineItemRepository;

    @Transactional
    public LineItemCalculateResultDto saveList(List<OrderLineItemRequestDto> requests) {

        return null;

    }

}
