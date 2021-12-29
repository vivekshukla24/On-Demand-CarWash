package CG.washer;

import CG.washer.exceptionHandlers.API_requestException;
import CG.washer.model.WasherDetails;
import CG.washer.repository.WasherRepository;
import CG.washer.service.WasherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WasherApplicationTests {
	@MockBean
	WasherRepository wr;
	@Autowired
	WasherService ws;

	@Test
	public void findWashersByNAmeTest() {
		WasherDetails washer1 = new WasherDetails(1, "Joel","4324tPW");
		WasherDetails washer2 = new WasherDetails(2, "Kenny","2342stPW");
		WasherDetails washer3 = new WasherDetails(3, "Manuel","t4545W");
		WasherDetails washer4 = new WasherDetails(4, "James","teew44");
		when(wr.findAll()).thenReturn(Stream.of(washer1,washer2,washer3,washer4).collect(Collectors.toList()));
		assertEquals(washer2,ws.findOnebyName("Kenny"));
		assertEquals(washer1,ws.findOnebyName("Joel"));
		assertEquals(washer3,ws.findOnebyName("Manuel"));
	}

}
