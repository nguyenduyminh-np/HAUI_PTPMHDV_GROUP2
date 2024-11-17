package vn.haui.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.haui.laptopshop.domain.Cart;
import vn.haui.laptopshop.domain.CartDetail;
import vn.haui.laptopshop.domain.Product;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
    boolean existsByCartAndProduct(Cart cart, Product product);

    CartDetail findByCartAndProduct(Cart cart, Product product);

    CartDetail findCartDetailById(long id);

    void deleteByCart(Cart cart);
}
