package com.rentalhive.service.impl;

import com.rentalhive.domain.*;
import com.rentalhive.domain.embedded.OrderEquipmentId;
import com.rentalhive.dto.OrderDto;
import com.rentalhive.dto.request.EquipmentRequestDTO;
import com.rentalhive.dto.response.OrderResponseDto;
import com.rentalhive.exception.QuantityExceededException;
import com.rentalhive.mapper.OrderDtoMapper;
import com.rentalhive.mapper.OrderResponseDtoMapper;
import com.rentalhive.repository.OrderRepository;
import com.rentalhive.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final EquipmentItemServiceImpl equipmentItemService;
    private final User userConnected;
    private final OrderEquipmentService orderEquipmentService;

    @Override
    @Transactional
    public OrderResponseDto createOrder(OrderDto orderDto) throws QuantityExceededException {
        List<EquipmentRequestDTO> equipments = orderDto.getEquipments();
        checkIfCanReserveEquipments(orderDto);
        LocalDateTime endDate = orderDto.getEnd();
        LocalDateTime startDate = orderDto.getStart();
        final List<OrderEquipment> orderEquipment = new ArrayList<>();
        final List<EquipmentItem> equipmentItems = new ArrayList<>();

        for (EquipmentRequestDTO equipmentDto:
                equipments) {
            List<EquipmentItem> equipmentItems1 = equipmentItemService.findAvailableEquipmentItemsByEquipmentId(equipmentDto.getId(), startDate, endDate);
            if(equipmentDto.getQuantityReserved() > equipmentItems1.size())
                throw new QuantityExceededException("Quantity reserve more than quantity exist");

            for (int i = 0; i < equipmentDto.getQuantityReserved(); i++) {
                EquipmentItem equipmentItem = equipmentItems1.get(i);
                equipmentItems.add(equipmentItem);
            }
        }

        Order order = OrderDtoMapper.toEntity(orderDto);

        equipmentItems.forEach(equipmentItem ->
                orderEquipment.add(OrderEquipment.builder()
                                .orderEquipmentId(
                                        OrderEquipmentId.builder()
                                                .equipmentItem(equipmentItem)
                                                .order(order)
                                                .build()
                                )
                        .equipmentItem(equipmentItem)
                        .order(order)
                        .build()));

        order.setOrderEquipments(orderEquipment);
        // TODO: get the user authenticated
        order.setUser(userConnected);
        orderRepository.save(order);

        var orderEquipmentsSaved = orderEquipmentService.saveAll(orderEquipment);
        order.setOrderEquipments(orderEquipmentsSaved);
        Order savedOrder = orderRepository.save(order);

        return OrderResponseDtoMapper.toDto(savedOrder);
    }

    private void checkIfCanReserveEquipments(OrderDto orderDto) {
        List<EquipmentRequestDTO> equipments = orderDto.getEquipments();
        if(equipments.isEmpty())
            throw new RuntimeException("No equipment is selected");

        if(orderDto.getEnd()
                .isBefore(orderDto.getStart()))
            throw new RuntimeException("Date start should be before date end");
    }
}
