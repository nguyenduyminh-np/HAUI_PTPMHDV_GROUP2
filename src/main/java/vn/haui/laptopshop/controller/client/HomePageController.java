package vn.haui.laptopshop.controller.client;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import vn.haui.laptopshop.domain.Product;
import vn.haui.laptopshop.domain.User;
import vn.haui.laptopshop.domain.dto.RegisterDTO;
import vn.haui.laptopshop.service.ProductService;
import vn.haui.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {

    private final ProductService productService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public HomePageController(ProductService productService, UserService userService, PasswordEncoder passwordEncoder) {
        this.productService = productService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String getMethodName(Model model) {
        List<Product> products = this.productService.fetchProducts();
        model.addAttribute("products", products);

        return "client/homepage/show";

    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerUser", new RegisterDTO());
        return "client/auth/register";
    }

    @PostMapping("/register")
    public String handleRegister(@ModelAttribute("registerUser") @Valid RegisterDTO registerDTO,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "client/auth/register";
        }
        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            // Check function BindingResult
            System.out.println(error.getObjectName() + "Fault here REGISTER Post >>>>>>> " +
                    error.getDefaultMessage());
        }

        User user = this.userService.registerDTOtoUser(registerDTO);

        String hashPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        user.setRole(this.userService.getRoleByName("USER"));

        this.userService.handleSaveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {

        return "client/auth/login";
    }

    @GetMapping("/access-deny")
    public String getDenyPage(Model model) {
        return "client/auth/deny";
    }

}