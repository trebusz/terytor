package pl.warg.terytor.api;

import pl.warg.terytor.TercService;

import java.util.Optional;

public class TercApiClient {

	private TercService tercService;

	public TercApiClient(String tercPath) {
		this.tercService = new TercService(tercPath);
	}

	public Optional<String> findNameByTerc(String terc) {
		return tercService.findNameByTerc(Integer.valueOf(terc));
	}
}
