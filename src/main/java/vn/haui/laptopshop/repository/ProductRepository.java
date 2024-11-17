package vn.haui.laptopshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.haui.laptopshop.domain.Cart;
import vn.haui.laptopshop.domain.Product;
import vn.haui.laptopshop.domain.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(long id);

    void deleteById(long id);

    Product save(Product product);

}
