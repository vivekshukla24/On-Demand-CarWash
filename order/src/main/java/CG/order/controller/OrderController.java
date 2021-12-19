package CG.order.controller;

import CG.order.exceptionHandlers.API_requestException;
import CG.order.model.OrderDetails;
import CG.order.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

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
        boolean doesOrderExist=or.existsById(id);
        if(doesOrderExist){
            or.deleteById(id);
            return "Order with ID -> "+id+" deleted successfully from OrderDB";
        }
        else {
            throw new API_requestException("Order not found, deletion failed");
        }
    }
    //To update an order
    @PutMapping("/update")
    public OrderDetails updateOrder(@RequestBody OrderDetails orderDetails){
        boolean doesOrderExist=or.existsById(orderDetails.getOrderId());
        if(doesOrderExist){
            OrderDetails existingOrder = or.findById(orderDetails.getOrderId()).orElse(null);
            existingOrder.setWasherName(orderDetails.getWasherName());
            existingOrder.setWashpackId(orderDetails.getWashpackId());
            //Status can't be updated by the user
            existingOrder.setCars(orderDetails.getCars());
            existingOrder.setPhoneNo(orderDetails.getPhoneNo());
            return or.save(existingOrder);
        }
        else {
            throw new API_requestException("Order not found in database, update request failed");
        }
    }

    /** Getting consumed by the Washer model */
    //To find all the completed orders
    @GetMapping("/findCompleted")
    public List<OrderDetails> getCompletedOrders(){
         return or.findAll().stream().filter(x -> x.getStatus().contains("Completed")).collect(Collectors.toList());
    }
    //To find all the pending orders
    @GetMapping("/findPending")
    public List<OrderDetails> getPendingOrders(){
        return or.findAll().stream().filter(x -> x.getStatus().contains("Pending")).collect(Collectors.toList());
    }
    //To find all the cancelled orders
    @GetMapping("/findCancelled")
    public List<OrderDetails> getCancelledOrders(){
        return or.findAll().stream().filter(x -> x.getStatus().contains("Cancelled")).collect(Collectors.toList());
    }
    //To find all the unassigned orders
    @GetMapping("/findUnassigned")
    public List<OrderDetails> getUnassignedOrders(){
        return or.findAll().stream().filter(x -> x.getWasherName().contains("NA")).collect(Collectors.toList());
    }
    //To cancel the order
    @PutMapping("/cancelOrder")
    public String cancelOrder(@RequestBody OrderDetails orderDetails){
        OrderDetails od=or.findById(orderDetails.getOrderId()).get();
        od.setStatus("Cancelled");
        or.save(od);
        return "The order with ID -> "+orderDetails.getOrderId()+" is cancelled successfully";
    }

    /** Methods that are consumed exclusively by rest templates below this comment */
    //This is called by Admin to update the status of the order
    @PutMapping("/updateStatus")
    public OrderDetails updateStatus(@RequestBody OrderDetails orderDetails){
        boolean doesOrderExists=or.existsById(orderDetails.getOrderId());
        if (doesOrderExists){
            OrderDetails existingOrder = or.findById(orderDetails.getOrderId()).orElse(null);
            existingOrder.setStatus(orderDetails.getStatus());
            return or.save(existingOrder);
        }
        else {
            throw new API_requestException("Order not found in database, status not updated");
        }
    }
}
