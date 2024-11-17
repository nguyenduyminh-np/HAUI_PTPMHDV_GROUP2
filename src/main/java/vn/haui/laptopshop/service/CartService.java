package vn.haui.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.haui.laptopshop.domain.Cart;
import vn.haui.laptopshop.domain.CartDetail;
import vn.haui.laptopshop.repository.CartDetailRepository;
import vn.haui.laptopshop.repository.CartRepository;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;

    public CartService(CartRepository cartRepository, CartDetailRepository cartDetailRepository) {
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
    }

    public List<Cart> fetchCarts() {
        return this.cartRepository.findAll();
    }

}
