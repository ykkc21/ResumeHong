package inhatc.cse.resumehong.order.repository;

import inhatc.cse.resumehong.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
