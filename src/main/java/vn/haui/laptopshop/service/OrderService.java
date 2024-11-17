package vn.haui.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.haui.laptopshop.domain.Order;
import vn.haui.laptopshop.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> fetchAllOrders() {
        return this.orderRepository.findAll();
    }
}
