package volos.service;

import volos.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders ();
    Order getOrderById (Long id);

    void saveOrder (Long userId);
    void deleteOrder (Long id);

    void addLookToOrder (Long idOrder, Long idLook);
    void deleteLookFromOrder (Long idOrder, Long idLook);
}
