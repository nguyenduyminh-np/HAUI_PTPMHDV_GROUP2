package vn.haui.laptopshop.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.haui.laptopshop.domain.Order;
import vn.haui.laptopshop.domain.OrderDetail;
import vn.haui.laptopshop.service.OrderService;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/admin/order")
    public String getDashboard(Model model) {
        List<Order> orders = this.orderService.fetchAllOrders();
        List<OrderDetail> orderDetails = new ArrayList<>();

        for (Order order : orders) {
            orderDetails.addAll(order.getOrderDetails());
        }

        model.addAttribute("orders1", orders);
        model.addAttribute("order.orderDetails", orderDetails);

        return "admin/order/show";
    }
}