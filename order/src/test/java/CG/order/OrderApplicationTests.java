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
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;
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
				new OrderDetails(1,"Kenny",2,67356333,"Pending", Arrays.asList(new Car(1,"Honda"))),
				new OrderDetails(2,"Joel",2,7233838,"Pending", Arrays.asList(new Car(1,"Hyundai"), new Car(2,"Skoda"))),
				new OrderDetails(3,"Kenny",3,86282223,"Completed", Arrays.asList(new Car(1,"BMW"),new Car(2,"Mercedes"), new Car(3,"Verna"))),
				new OrderDetails(4,"Joel",1,34624443,"Completed", Arrays.asList(new Car(1,"Honda"))),
				new OrderDetails(5,"Kenny",2,935324443,"Completed", Arrays.asList(new Car(1,"Maruti"))),
				new OrderDetails(6,"Joel",3,264324443,"Pending", Arrays.asList(new Car(1,"Grand i10")))
				).collect(Collectors.toList()));
				assertEquals("This should return all the orders available and count them",6,oc.findallOrders().size());
	}

	@Test
	public void completedOrderTest(){
		when(or.findAll()).thenReturn(Stream.of(
				new OrderDetails(1,"Kenny",2,67356333,"Pending", Arrays.asList(new Car(1,"Honda"))),
				new OrderDetails(2,"Joel",2,7233838,"Pending", Arrays.asList(new Car(1,"Hyundai"), new Car(2,"Skoda"))),
				new OrderDetails(3,"Kenny",3,86282223,"Completed", Arrays.asList(new Car(1,"BMW"),new Car(2,"Mercedes"), new Car(3,"Verna"))),
				new OrderDetails(5,"Joel",1,34624443,"Completed", Arrays.asList(new Car(1,"Honda"))),
				new OrderDetails(6,"Kenny",2,935324443,"Completed", Arrays.asList(new Car(1,"Maruti"))),
				new OrderDetails(7,"Joel",3,264324443,"Pending", Arrays.asList(new Car(1,"Grand i10")))
		).collect(Collectors.toList()));
		assertEquals("This should filter and count the number of completed orders",3,oc.getCompletedOrders().stream().count());
	}

	@Test
	public void PendingOrderTest(){
		when(or.findAll()).thenReturn(Stream.of(
				new OrderDetails(1,"Kenny",2,67356333,"Pending", Arrays.asList(new Car(1,"Honda"))),
				new OrderDetails(2,"Joel",2,7233838,"Pending", Arrays.asList(new Car(1,"Hyundai"), new Car(2,"Skoda"))),
				new OrderDetails(3,"Kenny",3,86282223,"Completed", Arrays.asList(new Car(1,"BMW"),new Car(2,"Mercedes"), new Car(3,"Verna"))),
				new OrderDetails(5,"Joel",1,34624443,"Completed", Arrays.asList(new Car(1,"Honda"))),
				new OrderDetails(6,"Kenny",2,935324443,"Completed", Arrays.asList(new Car(1,"Maruti"))),
				new OrderDetails(7,"Joel",3,264324443,"Pending", Arrays.asList(new Car(1,"Grand i10")))
		).collect(Collectors.toList()));
		assertEquals("This should filter and count the number of Pending orders",3,oc.getPendingOrders().stream().count());
	}

	@Test
	public void CancelledOrderTest(){
		when(or.findAll()).thenReturn(Stream.of(
				new OrderDetails(1,"Kenny",2,67356333,"Pending", Arrays.asList(new Car(1,"Honda"))),
				new OrderDetails(2,"Joel",2,7233838,"Pending", Arrays.asList(new Car(1,"Hyundai"), new Car(2,"Skoda"))),
				new OrderDetails(3,"Kenny",3,86282223,"Cancelled", Arrays.asList(new Car(1,"BMW"),new Car(2,"Mercedes"), new Car(3,"Verna"))),
				new OrderDetails(5,"Joel",1,34624443,"Completed", Arrays.asList(new Car(1,"Honda"))),
				new OrderDetails(6,"Kenny",2,935324443,"Completed", Arrays.asList(new Car(1,"Maruti"))),
				new OrderDetails(7,"Joel",3,264324443,"Cancelled", Arrays.asList(new Car(1,"Grand i10")))
		).collect(Collectors.toList()));
		assertEquals(2,oc.getCancelledOrders().stream().count());
	}

	@Test(expected = API_requestException.class)
	public void deleteUserTest() throws Exception{
		OrderDetails MockOrder = new OrderDetails(3,"Kenny",3,86282223,"Cancelled", Arrays.asList(new Car(1,"BMW"),new Car(2,"Mercedes"), new Car(3,"Verna")));
		oc.deleteOrder(MockOrder.getOrderId());
	}

}
