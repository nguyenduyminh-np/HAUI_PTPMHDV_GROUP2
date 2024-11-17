package vn.haui.laptopshop.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.haui.laptopshop.domain.Order;
import vn.haui.laptopshop.service.DashboardService;
import vn.haui.laptopshop.service.OrderService;

@Controller
public class DashboardController {

    private OrderService orderService;
    private DashboardService dashboardService;

    public DashboardController(OrderService orderService, DashboardService dashboardService) {
        this.orderService = orderService;
        this.dashboardService = dashboardService;
    }

    @GetMapping("/admin")
    public String getDashboard(Model model) {
        List<Order> orders = this.orderService.fetchAllOrders(); // Lấy tất cả đơn hàng từ cơ sở dữ liệu

        // Tạo dữ liệu cho biểu đồ
        List<String> labels = new ArrayList<>();
        List<Double> data = new ArrayList<>();

        // Giả sử bạn muốn nhóm theo ngày
        Map<Integer, Double> groupedData = new HashMap<>();

        for (Order order : orders) {
            // Lấy ngày (dd) từ chuỗi 'yyyy-MM-dd'
            int day = Integer.parseInt(order.getCreatedAt().toString().substring(8, 10)); // Chuyển đổi phần ngày thành
                                                                                          // số

            // Thêm vào bản đồ, tính tổng giá trị theo ngày
            groupedData.put(day, groupedData.getOrDefault(day, 0.0) + order.getTotalPrice());
        }

        // Sắp xếp theo thứ tự ngày tăng dần
        List<Integer> sortedDays = new ArrayList<>(groupedData.keySet());
        sortedDays.sort(Integer::compareTo); // Sắp xếp các ngày theo thứ tự từ 1 đến 31

        // Thêm dữ liệu vào danh sách labels và data để gửi lên view
        for (Integer day : sortedDays) {
            labels.add(String.format("%02d", day)); // Đảm bảo định dạng ngày là 2 chữ số (01, 02, ..., 31)
            data.add(groupedData.get(day)); // Lấy tổng giá trị theo ngày
        }

        model.addAttribute("labels", labels); // Gửi labels (ngày) lên view
        model.addAttribute("data", data); // Gửi data (tổng tiền) lên view
        return "admin/dashboard/show"; // Trả về view
    }

}
