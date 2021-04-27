package volos.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import volos.exception.ObjectNotFoundException;
import volos.model.Look;
import volos.model.Order;
import volos.model.User;
import volos.model.enums.OrderStatus;
import volos.repository.OrderRepository;
import volos.service.LookService;
import volos.service.OrderService;
import volos.service.UserService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final LookService lookService;

    public List<Order> getAllOrders () {
        return orderRepository.findAll();
    }
    public Order getOrderById (Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(Order.class.getName(), id));
    }

    public void saveOrder (Long userId) {
        User temp;
        temp = userService.getUserById(userId);
        Order order = new Order(temp, OrderStatus.Pending);
        orderRepository.save(order);
    }
    public void deleteOrder (Long id) {
        if(orderRepository.findById(id).isEmpty())
            throw new ObjectNotFoundException(Order.class.getName(),id);
        orderRepository.deleteById(id);
    }
    public void addLookToOrder(Long idOrder, Long idLook) {
        Order order = orderRepository.findById(idOrder).orElseThrow(() -> new ObjectNotFoundException(Order.class.getName(), idOrder));
        order.getLooks().add(lookService.getLookById(idLook));
        orderRepository.save(order);
    }
    public void deleteLookFromOrder(Long idOrder, Long idLook) {
        Order order = orderRepository.findById(idOrder).orElseThrow(() -> new ObjectNotFoundException(Order.class.getName(), idOrder));
        order.getLooks().remove(lookService.getLookById(idLook));
        orderRepository.save(order);
    }
}
