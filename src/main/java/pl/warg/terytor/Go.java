package pl.warg.terytor;

import lombok.extern.slf4j.Slf4j;
import pl.warg.terytor.api.TercApiClient;

@Slf4j
public class Go {

	public static void main(String... args) {

		TercApiClient tercApiClient = new TercApiClient("c:/dev/data/TERC.xml");

		log.info(tercApiClient.findNameByTerc("1465178").get());
		log.info(tercApiClient.findNameByTerc("3027034").get());
		log.info(tercApiClient.findNameByTerc("0602054").get());
	}
}
