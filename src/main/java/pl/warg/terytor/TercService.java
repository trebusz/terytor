package pl.warg.terytor;

import lombok.extern.slf4j.Slf4j;
import pl.warg.terytor.api.model.TercRecord;
import pl.warg.terytor.util.TercUtil;
import pl.warg.terytor.xml.TercHandler;
import pl.warg.terytor.xml.TercRow;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Slf4j
public class TercService {

	private final Map<String, String> terc2name = new TreeMap<>(); // caching <String, TercRecord> maybe would be better?

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

			Map<String, String> communesWithoutType = new HashMap<>();

			for (Map.Entry<String, String> entry : terc2name.entrySet()) {

				String key = entry.getKey();

				if (key.length() == 7) {
					communesWithoutType.put(key.substring(0, 6), entry.getValue());
				}
			}

			terc2name.putAll(communesWithoutType);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Optional<String> findNameByTerc(String tercCode) {
		return Optional.ofNullable(terc2name.get(tercCode));
	}

	public TercRecord getFullTercInfo(String tercCode) {
		if (!TercUtil.isTercCodeValid(tercCode)) {
			throw new IllegalArgumentException();
		}

		String provinceCode = tercCode.substring(0, 2);
		String countyCode = tercCode.substring(0, 4);

		return new TercRecord(terc2name.getOrDefault(provinceCode, ""), terc2name.getOrDefault(countyCode, ""), terc2name.getOrDefault(tercCode, ""));
	}
}
