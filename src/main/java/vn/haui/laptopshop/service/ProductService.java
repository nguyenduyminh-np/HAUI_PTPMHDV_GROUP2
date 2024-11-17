package vn.haui.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import vn.haui.laptopshop.domain.Cart;
import vn.haui.laptopshop.domain.CartDetail;
import vn.haui.laptopshop.domain.Order;
import vn.haui.laptopshop.domain.Product;
import vn.haui.laptopshop.domain.User;
import vn.haui.laptopshop.repository.CartDetailRepository;
import vn.haui.laptopshop.repository.CartRepository;
import vn.haui.laptopshop.repository.OrderDetailRepository;
import vn.haui.laptopshop.repository.OrderRepository;
import vn.haui.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;
    private final UserService userService;
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    public ProductService(ProductRepository productRepository, CartRepository cartRepository,
            CartDetailRepository cartDetailRepository, UserService userService, OrderRepository orderRepository,
            OrderDetailRepository orderDetailRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.userService = userService;
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    public Product handleSaveProduct(Product product) {
        Product eric = this.productRepository.save(product);
        return eric;
    }

    public Product createProduct(Product product) {
        return this.productRepository.save(product);
    }

    public List<Product> fetchProducts() {
        return this.productRepository.findAll();
    }

    public Optional<Product> fetchProductById(long id) {
        return this.productRepository.findById(id);
    }

    public void deleteById(long id) {
        this.productRepository.deleteById(id);
    }

    public Product saveProduct(Product product) {
        return this.productRepository.save(product);
    }

    public void handleAddProductToCart(String email, long productId, HttpSession session) {
        // Check user da co cart chua? neu chua -> tao moi
        User user = this.userService.getUserByEmail(email);
        if (user != null) {
            Cart cart = this.cartRepository.findByUser(user);

            if (cart == null) {
                // tao moi cart
                Cart otherCart = new Cart();
                otherCart.setUser(user);
                otherCart.setSum(0);

                cart = this.cartRepository.save(otherCart);
            }

            // save cart detail

            // find Product by ID
            Optional<Product> productOptional = this.productRepository.findById(productId);
            if (productOptional.isPresent()) {
                Product realProduct = productOptional.get();

                // Check sản phẩm đã được thêm vào giỏ hàng trước đây chưa
                CartDetail oldDetail = this.cartDetailRepository.findByCartAndProduct(cart, realProduct);

                if (oldDetail == null) {
                    CartDetail cd = new CartDetail();
                    cd.setCart(cart);
                    cd.setProduct(realProduct);
                    cd.setPrice(realProduct.getPrice());
                    cd.setQuantity(1);
                    this.cartDetailRepository.save(cd);

                    // update cart sum
                    int s = cart.getSum() + 1;
                    cart.setSum(s);
                    this.cartRepository.save(cart);
                    session.setAttribute("sum", s);

                } else {
                    oldDetail.setQuantity(oldDetail.getQuantity() + 1);
                    this.cartDetailRepository.save(oldDetail);
                }

            }

        }
    }

    public Cart fetchCartByUser(User user) {
        return this.cartRepository.findByUser(user);
    }

    public CartDetail findCartDetailById(long id) {
        return this.cartDetailRepository.findCartDetailById(id);
    }

    public void deleteCartAndCartDetail(long idDetailCart) {
        CartDetail cartDetail = this.cartDetailRepository.findCartDetailById(idDetailCart);
        Cart cart = cartDetail.getCart();
        long id = cart.getId();

        int sum = cart.getSum();
        long quantity = cartDetail.getQuantity();
        List<CartDetail> cartDetails = cart.getCartDetails();

        if (quantity > 1) {
            cartDetail.setQuantity(quantity - 1);
        } else if (quantity == 1) {
            this.cartDetailRepository.delete(cartDetail);
            cart.setSum(sum - 1);
        } else if (cartDetails.isEmpty() && cart.getSum() == 0) {
            this.cartRepository.deleteById(id);
        }

        // Optional<CartDetail> cartDetaiOptional =
        // this.cartDetailRepository.findById(cartDetailId);
        // if (cartDetaiOptional.isPresent()) {
        // CartDetail cartDetail = cartDetaiOptional.get();

        // Cart currentCart = cartDetail.getCart();

        // if (currentCart.getSum() > 1) {
        // int sum = currentCart.getSum() - 1;
        // session.setAttribute("sum", sum);
        // this.cartRepository.save(currentCart);
        // } else {
        // this.cartRepository.deleteById(currentCart.getId());
        // session.setAttribute("sum", 0);
        // }
        // }
        // }
    }

    public void handleUpdateCartBeforeCheckout(List<CartDetail> cartDetails) {
        for (CartDetail cartDetail : cartDetails) {
            Optional<CartDetail> cOptional = this.cartDetailRepository.findById(cartDetail.getId());
            if (cOptional.isPresent()) {
                CartDetail currentCartDetail = cOptional.get();
                currentCartDetail.setQuantity(cartDetail.getQuantity());
                this.cartDetailRepository.save(currentCartDetail);
            }
        }
    }

    public Cart fetchByUser(User user) {
        return this.cartRepository.findByUser(user);
    }

    public void handlePlaceOrder(User user, HttpSession session, String receiverName, String receiverAddress,
            String receiverPhone) {
        Order order = new Order();
        order.setUser(user);
        order.setReceiverName(receiverName);
        order.setReceiverAddress(receiverAddress);
        order.setReceiverPhone(receiverPhone);
        this.orderRepository.save(order);

        // create order detail

    }
}
