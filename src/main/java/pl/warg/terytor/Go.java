package pl.warg.terytor;

import lombok.extern.slf4j.Slf4j;
import pl.warg.terytor.xml.TercHandler;
import pl.warg.terytor.xml.TercRow;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

@Slf4j
public class Go {

	public static void main(String... args) {

		TercHandler tercHandler = new TercHandler();

		try {
			InputStream is = new FileInputStream("c:/dev/data/TERC.xml");
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();
			saxParser.parse(is, tercHandler);

			HashMap<String, TercRow> byId = new HashMap<>();

			for (TercRow r : tercHandler.getData()) {
				String id = r.getWoj() + r.getPow() + r.getGmi() + r.getRodz();
				byId.put(id, r);
			}

			//Set<String> nazwyDod = tercHandler.data.stream().map(row -> row.getNazwa_dod() + "-" + row.getRodz()).collect(Collectors.toSet());
			//log.info("" + nazwyDod);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
