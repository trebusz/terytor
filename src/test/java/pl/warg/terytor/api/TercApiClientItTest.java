package pl.warg.terytor.api;


import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pl.warg.terytor.api.model.TercRecord;

@Slf4j
public class TercApiClientItTest {

	@Test
	@Ignore
	public void findNameByTerc() {

		TercApiClient tercApiClient = new TercApiClient("e:/dev/data/TERC.xml");

		Assert.assertEquals("Włochy", tercApiClient.findNameByTerc("1465178").get());
		Assert.assertEquals("Dobra", tercApiClient.findNameByTerc("3027034").get());
		Assert.assertEquals("Frampol", tercApiClient.findNameByTerc("0602054").get());
	}

	@Test
	@Ignore
	public void getFullTercInfo() {

		TercApiClient tercApiClient = new TercApiClient("e:/dev/data/TERC.xml");

		TercRecord fullTercInfo = tercApiClient.getFullTercInfo("1465178");

		Assert.assertEquals("Włochy", fullTercInfo.getCommune());
		Assert.assertEquals("Warszawa", fullTercInfo.getCounty());
		Assert.assertEquals("MAZOWIECKIE", fullTercInfo.getProvince());

		fullTercInfo = tercApiClient.getFullTercInfo("0602054");

		Assert.assertEquals("Frampol", fullTercInfo.getCommune());
		Assert.assertEquals("biłgorajski", fullTercInfo.getCounty());
		Assert.assertEquals("LUBELSKIE", fullTercInfo.getProvince());
	}
}