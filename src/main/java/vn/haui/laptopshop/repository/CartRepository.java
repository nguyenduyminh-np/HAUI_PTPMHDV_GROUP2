package vn.haui.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.haui.laptopshop.domain.Cart;
import vn.haui.laptopshop.domain.User;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(User user);

    void deleteCartById(long id);

    List<Cart> findAll();
}
