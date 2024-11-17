package vn.haui.laptopshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.haui.laptopshop.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Double> getTotalPrices() {
        return orderRepository.findAll()
                .stream()
                .map(order -> order.getTotalPrice())
                .collect(Collectors.toList());
    }

    public List<String> getOrderDates() {
        return orderRepository.findAll()
                .stream()
                .map(order -> order.getCreatedAt().toString().split("T")[0]) // Format YYYY-MM-DD
                .collect(Collectors.toList());
    }
}
