package volos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import volos.model.Order;
import volos.model.RoleUser;

public interface OrderRepository extends JpaRepository<Order, Long> { }
