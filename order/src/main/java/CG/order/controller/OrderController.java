package CG.order.controller;

import CG.order.model.OrderDetails;
import CG.order.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepo or;

    //To get all orders
    @GetMapping("/findall")
    public List<OrderDetails> findallOrders(){
        return or.findAll();
    }
    //Find one object by ID
    @GetMapping("/findone/{id}")
    public OrderDetails findoneOrder(@PathVariable int id){
         return or.findById(id).get();
    }
    //To add an order
    @PostMapping("/add")
    public OrderDetails addOrder(@RequestBody OrderDetails order) {
        return or.save(order);
    }
    //To delete specific order with id
    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable int id){
        or.deleteById(id);
        return "Order with ID "+id+" deleted successfully";
    }
    //To update an order
    @PutMapping("/update")
    public OrderDetails updateOrder(@RequestBody OrderDetails orderDetails){
        OrderDetails existingOrder = or.findById(orderDetails.getOrderId()).orElse(null);
        existingOrder.setWasherName(orderDetails.getWasherName());
        existingOrder.setWashpackId(orderDetails.getWashpackId());
        existingOrder.setCars(orderDetails.getCars());
        //Reserved for admin
        //existingOrder.setStatus(orderDetails.getStatus());
        existingOrder.setPhoneNo(orderDetails.getPhoneNo());
        return or.save(existingOrder);
    }
    //This is called by Admin to update the status of the order
    @PutMapping("/updateStatus")
    public OrderDetails updateStatus(@RequestBody OrderDetails orderDetails){
        OrderDetails existingOrder = or.findById(orderDetails.getOrderId()).orElse(null);
        existingOrder.setStatus(orderDetails.getStatus());
        return or.save(existingOrder);
    }
}
