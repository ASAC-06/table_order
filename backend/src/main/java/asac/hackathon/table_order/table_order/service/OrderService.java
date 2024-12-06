package asac.hackathon.table_order.table_order.service;

import asac.hackathon.table_order.table_order.controller.dto.LineItemCalculateResultDto;
import asac.hackathon.table_order.table_order.controller.dto.OrderRequestDto;
import asac.hackathon.table_order.table_order.controller.dto.OrderResponseDto;
import asac.hackathon.table_order.table_order.entity.Order;
import asac.hackathon.table_order.table_order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public OrderResponseDto orderInitCreate(OrderRequestDto request) {
        Order order = Order.firstOrder(request);
        orderRepository.save(order);
        return OrderResponseDto.from(order);
    }

    @Transactional
    public OrderResponseDto synchronizeOrder(OrderResponseDto responseDto, LineItemCalculateResultDto resultDto) {

        Order order = orderRepository.findByOrderNumber(responseDto.getOrderNumber());
        order.orderAmountAndTotalPriceUpdate(resultDto);
        return OrderResponseDto.from(order);
    }

}
