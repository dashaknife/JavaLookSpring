package volos.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import volos.model.Order;
import volos.model.RoleUser;
import volos.service.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {
    
    private final OrderService orderService;

    @GetMapping("/")
    public List<Order> findAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/user/{userId}")
    public List<Order> saveOrder(@PathVariable Long userId) {
        orderService.saveOrder(userId);
        return findAllOrders();
    }

    @DeleteMapping("/{id}")
    public List<Order> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return findAllOrders();
    }

    @PatchMapping("/addLook/")
    @ResponseBody
    public List<Order> addLookToOrder(@RequestParam Long idOrder, @RequestParam Long idLook) {
        orderService.addLookToOrder(idOrder,idLook);
        return orderService.getAllOrders();
    }

    @DeleteMapping("/deleteLook/")
    @ResponseBody
    public List<Order> deleteLookFromOrder(@RequestParam Long idOrder, @RequestParam Long idLook) {
        orderService.deleteLookFromOrder(idOrder,idLook);
        return orderService.getAllOrders();
    }
}
