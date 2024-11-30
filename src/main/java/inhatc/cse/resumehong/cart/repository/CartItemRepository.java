package inhatc.cse.resumehong.cart.repository;

import inhatc.cse.resumehong.cart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
