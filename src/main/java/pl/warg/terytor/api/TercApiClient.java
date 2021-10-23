package pl.warg.terytor.api;

import pl.warg.terytor.TercService;
import pl.warg.terytor.api.model.TercRecord;

import java.util.Optional;

public class TercApiClient {

	private TercService tercService;

	public TercApiClient(String tercPath) {
		this.tercService = new TercService(tercPath);
	}

	public Optional<String> findNameByTerc(String tercCode) {
		return tercService.findNameByTerc(tercCode);
	}

	public TercRecord getFullTercInfo(String tercCode) {
		return tercService.getFullTercInfo(tercCode);
	}
}
