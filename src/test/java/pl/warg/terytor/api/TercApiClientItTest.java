package pl.warg.terytor.api;


import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class TercApiClientItTest {

	@Test
	public void findNameByTerc() {

		TercApiClient tercApiClient = new TercApiClient("e:/dev/data/TERC.xml");

		Assert.assertEquals("Włochy", tercApiClient.findNameByTerc("1465178").get());
		Assert.assertEquals("Dobra", tercApiClient.findNameByTerc("3027034").get());
		Assert.assertEquals("Frampol", tercApiClient.findNameByTerc("0602054").get());
	}
}