package com.rentalhive.service.impl;

import com.rentalhive.domain.EquipmentItem;
import com.rentalhive.domain.Location;
import com.rentalhive.domain.Order;
import com.rentalhive.dto.OrderDto;
import com.rentalhive.dto.response.OrderResponseDto;
import com.rentalhive.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepository orderRepository;

    @Test
    public void testCreateOrder() {
        // Arrange
        List<EquipmentItem> orderEquipments = new ArrayList<>();
        orderEquipments.add(EquipmentItem.builder().build());
        LocalDateTime rentStartDate = LocalDateTime.now();
        LocalDateTime rentEndDate = rentStartDate.plusDays(7);
        Location location = Location.builder().name("casa").latitude(24.).longitude(23.).build();

        // TODO: a remplir orderDto
        OrderDto orderDto = OrderDto.builder().build();

        // Mock the behavior of the orderRepository.save method
        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        OrderResponseDto createdOrder = orderService.createOrder(orderDto);

        // Assert
        assertNotNull(createdOrder);
        assertEquals(rentStartDate, createdOrder.getStart());
        assertEquals(rentEndDate, createdOrder.getEnd());
        // assertEquals(orderEquipments, createdOrder.getEquipments());

        // Verify that the orderRepository.save method was called
        Mockito.verify(orderRepository, Mockito.times(1)).save(Mockito.any(Order.class));
    }
}