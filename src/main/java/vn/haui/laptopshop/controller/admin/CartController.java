package vn.haui.laptopshop.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.haui.laptopshop.domain.Cart;
import vn.haui.laptopshop.domain.CartDetail;
import vn.haui.laptopshop.service.CartService;

@Controller
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("admin/cart")
    public String getCartPage(Model model) {
        List<Cart> carts = this.cartService.fetchCarts();

        List<CartDetail> cartDetails = new ArrayList<>(); // Khởi tạo danh sách trống

        for (Cart cart : carts) {
            cartDetails.addAll(cart.getCartDetails()); // Thêm tất cả CartDetail của mỗi Cart vào danh sách
        }
        model.addAttribute("cartDetails", cartDetails);
        model.addAttribute("carts", carts);
        return "admin/cart/show";
    }

}
