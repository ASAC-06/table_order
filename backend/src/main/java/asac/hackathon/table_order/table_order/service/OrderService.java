package asac.hackathon.table_order.table_order.service;

import asac.hackathon.table_order.table_order.controller.dto.LineItemCalculateResultDto;
import asac.hackathon.table_order.table_order.controller.dto.OrderRequestDto;
import asac.hackathon.table_order.table_order.controller.dto.OrderResponseDto;
import asac.hackathon.table_order.table_order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderResponseDto orderCreate(OrderRequestDto request) {
        return null;
    }

    public OrderResponseDto synchronizeOrder(LineItemCalculateResultDto resultDto) {
        return null;
    }

}
