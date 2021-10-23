package pl.warg.terytor.api;

import pl.warg.terytor.GugikService;

public class GugikApiClient {

	private GugikService gugikService;

	public GugikApiClient(String communeBordersShpFilePath) {
		this.gugikService = new GugikService(communeBordersShpFilePath);
	}

	public boolean isGivenLatLonInProvidedTercUnit(double lat, double lon, String tercCode) {
		return gugikService.isGivenLatLonInProvidedTercUnit(lat, lon, tercCode);
	}
}
