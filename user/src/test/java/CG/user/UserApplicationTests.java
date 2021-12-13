package CG.user;

import CG.user.Repository.UserRepository;
import CG.user.exceptionHandlers.API_requestException;
import CG.user.model.UserDetails;
import CG.user.service.userService;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserApplicationTests {
	@MockBean
	private UserRepository ur;
	@Autowired
	private userService us;

	@Test
	public void findUsersTest() {
		when(ur.findAll()).thenReturn(Stream.of(new UserDetails(2,"Some User","Some Location","SomePassword"),new UserDetails(3, "Third User","Some Location","SomePW")).collect(Collectors.toList()));
		assertEquals("This test case should return all users in database(Mock)",2, us.findallUsers().size());
	}
	@Test
	public void findUsersTest2() {
		when(ur.findAll()).thenReturn(Stream.of(
				new UserDetails(9, "Aditya","Delhi","ady123"),
				new UserDetails(8, "Saurav","Bangalore","saurav123"),
				new UserDetails(7, "Gaurav","Chennai","Gaurav123"),
				new UserDetails(6, "Gautam,","Kerala","gtm123"),
				new UserDetails(5, "Ayush","Delhi","ayu123"),
				new UserDetails(4, "Robin","Bangalore","rob123")
		).collect(Collectors.toList()));
		assertEquals(6, us.findallUsers().size());
	}
	@Test
	public void saveUserTest() {
		UserDetails user = new UserDetails(22, "A username","Bangalore","user243");
		when(ur.save(user)).thenReturn(user);
		assertEquals("This should return the same object that is saved in DB(Mock)",user, us.addUser(user));
	}
	@Test(expected = API_requestException.class)
	public void deleteUserTest() throws Exception{
		UserDetails user = new UserDetails(1, "Dummy name","Haryana","testPW");
		us.deleteUser(user.getId());
	}
	@Test
	public void findOneUser(){
		UserDetails user = new UserDetails(1, "Dummy name","Haryana","testPW");
		when(ur.findById(user.getId())).thenReturn(java.util.Optional.of(user));
		assertEquals("It should return the object with certain id",user,us.findoneUser(user.getId()));
	}
}
