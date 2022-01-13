package CG.order;

import CG.order.controller.OrderController;
import CG.order.exceptionHandlers.API_requestException;
import CG.order.model.Car;
import CG.order.model.OrderDetails;
import CG.order.repository.OrderRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderApplicationTests {
	@MockBean
	OrderRepo or;
	@Autowired
	OrderController oc;

	@Test
	public void allOrdersTest() {
		when(or.findAll()).thenReturn(Stream.of(
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City"))
				).collect(Collectors.toList()));
		assertEquals("This should return all the orders available and count them",6,oc.findallOrders().size());
	}

	@Test
	public void completedOrderTest(){
		when(or.findAll()).thenReturn(Stream.of(
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City"))
				).collect(Collectors.toList()));
		assertEquals("This should filter and count the number of completed orders",3,oc.getCompletedOrders().stream().count());
	}

	@Test
	public void PendingOrderTest(){
		when(or.findAll()).thenReturn(Stream.of(
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City"))
		).collect(Collectors.toList()));
		assertEquals("This should filter and count the number of Pending orders",3,oc.getPendingOrders().stream().count());
	}

	@Test
	public void CancelledOrderTest(){
		when(or.findAll()).thenReturn(Stream.of(
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Cancelled",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Cancelled",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Cancelled",new Car(1,"Honda","City"))
		).collect(Collectors.toList()));
		assertEquals(3,oc.getCancelledOrders().stream().count());
	}

	@Test
	public void getMyOrdersTest() {
		when(or.findAll()).thenReturn(Stream.of(
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",new Car(1,"Honda","City")),
				new OrderDetails("a","x@gmail.com","Kenny","All Clean",191928363l,"110091","Cancelled",new Car(1,"Honda","City")),
				new OrderDetails("a","y@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City"))
		).collect(Collectors.toList()));
		assertEquals("This should return all the orders for  single user",4,oc.getMyOrders("a@gmail.com").size());
	}

	@Test
	public void washerSpecificOrderTest() {
		when(or.findAll()).thenReturn(Stream.of(
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Joel","All Clean",191928363l,"110091","Completed",new Car(1,"Honda","City")),
				new OrderDetails("a","x@gmail.com","Kenny","All Clean",191928363l,"110091","Cancelled",new Car(1,"Honda","City")),
				new OrderDetails("a","y@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","James","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City"))
		).collect(Collectors.toList()));
		assertEquals("This should return all the orders done by a single washer",4,oc.getWasherSpecificOrders("Kenny").size());
	}

	@Test(expected = API_requestException.class)
	public void deleteOrderTest() throws Exception{
		OrderDetails MockOrder = new OrderDetails("a","a@gmail.com","NA","All Clean",191928363l,"110091","Completed",new Car(1,"Honda","City"));
		oc.deleteOrder(MockOrder.getOrderId());
	}

	@Test
	public void cancelOrderbySomeEntity(){
		OrderDetails od=new OrderDetails("a","a@gmail.com","NA","All Clean",191928363l,"110091","Cancelled",new Car(1,"Honda","City"));
		OrderDetails om=new OrderDetails("a","a@gmail.com","NA","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City"));
		when(or.findById(od.getOrderId())).thenReturn(Optional.of(om));
		assertEquals("The order with ID -> "+od.getOrderId()+" is cancelled successfully",oc.cancelOrder(od));
	}
	@Test
	public void UnassignedOrderTest(){
		when(or.findAll()).thenReturn(Stream.of(
				new OrderDetails("a","a@gmail.com","NA","All Clean",191928363l,"110091","Completed",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","NA","All Clean",191928363l,"110091","Cancelled",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","NA","All Clean",191928363l,"110091","Pending",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","NA","All Clean",191928363l,"110091","Cancelled",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Cancelled",new Car(1,"Honda","City"))
		).collect(Collectors.toList()));
		assertEquals(4,oc.getUnassignedOrders().size());
	}
}

