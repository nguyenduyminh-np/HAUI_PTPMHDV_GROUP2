package vn.haui.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.haui.laptopshop.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User eric);

    List<User> findOneByEmail(String email);

    List<User> findAll();

    User findById(long id); // null

    void deleteById(long id);

    boolean existsByEmail(String email);

    User findByEmail(String email);
}