package pl.warg.terytor;

import pl.warg.terytor.xml.TercHandler;
import pl.warg.terytor.xml.TercRow;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TercService {

	private final Map<Integer, String> terc2name = new TreeMap<>();

	public TercService(String tercPath) {
		loadData(tercPath);
	}

	private void loadData(String tercPath) {
		try {
			TercHandler tercHandler = new TercHandler();
			InputStream is = new FileInputStream(tercPath);
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();
			saxParser.parse(is, tercHandler);
			terc2name.putAll(tercHandler.getData().stream().collect(Collectors.toMap(TercRow::getTercCode, TercRow::getNazwa)));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Optional<String> findNameByTerc(Integer terc) {
		return Optional.ofNullable(terc2name.get(terc));
	}
}
