package com.rentalhive.service.impl;

import com.rentalhive.domain.EquipmentItem;
import com.rentalhive.domain.Location;
import com.rentalhive.domain.Order;
import com.rentalhive.domain.OrderEquipment;
import com.rentalhive.repository.OrderRepository;
import com.rentalhive.web.rest.httpDto.OrderRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
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
        LocalDateTime rentStartDate = LocalDateTime.now();
        LocalDateTime rentEndDate = rentStartDate.plusDays(7);
        Location location = Location.builder().name("casa").latitude(24.).longitude(23.).build();

        // Mock the behavior of the orderRepository.save method
        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Order createdOrder = orderService.createOrder(
                new OrderRequestDto(orderEquipments, rentStartDate, rentEndDate, location));

        // Assert
        assertNotNull(createdOrder);
        assertEquals(rentStartDate, createdOrder.getRentStartDate());
        assertEquals(rentEndDate, createdOrder.getRentEndDate());
        assertEquals(orderEquipments, createdOrder.getOrderEquipments());

        // Verify that the orderRepository.save method was called
        Mockito.verify(orderRepository, Mockito.times(1)).save(Mockito.any(Order.class));
    }
}