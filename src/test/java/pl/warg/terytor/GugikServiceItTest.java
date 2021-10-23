package pl.warg.terytor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class GugikServiceItTest {


	@Test
	public void isGivenLatLonInProvidedCommune() {

	//	GugikService gugikService = new GugikService("e:\\dev\\data\\geo\\shp\\A03_Granice_gmin.shp");
		GugikService gugikService = new GugikService("e:\\dev\\data\\geo\\shp\\A05_Granice_jednostek_ewidencyjnych.shp");

		try {
			gugikService.isGivenLatLonInProvidedTercUnit(54.0, 19.0, "11111");
			Assert.assertFalse(true);
		} catch (RuntimeException e) {}

		try {
			gugikService.isGivenLatLonInProvidedTercUnit(0, 0, "123456");
			Assert.assertFalse(true);
		} catch (RuntimeException e) {}


		Assert.assertEquals(true, gugikService.isGivenLatLonInProvidedTercUnit(50.6712292,22.6665944, "0602054"));
		Assert.assertEquals(false, gugikService.isGivenLatLonInProvidedTercUnit(52.18046454021677, 20.945947871985418, "0602054"));
		Assert.assertEquals(true, gugikService.isGivenLatLonInProvidedTercUnit(52.18046454021677, 20.945947871985418, "146517"));
	}
}
