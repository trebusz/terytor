package pl.warg.terytor.xml;

import lombok.extern.slf4j.Slf4j;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import pl.warg.terytor.util.ReadUtil;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TercHandler extends DefaultHandler {

	StringBuilder content;

	private TercRow currentRow;

	private List<TercRow> data = new ArrayList<>();

	public void startElement(String uri, String name, String qName, Attributes attributes) {
		content = new StringBuilder();

		if (qName.equalsIgnoreCase("row")) {
			currentRow = new TercRow();
			data.add(currentRow);
		}
	}

	public void endElement(String uri, String name, String qName) {
		if (qName.equals("WOJ")) {
			currentRow.setWoj(ReadUtil.readTextContent(content));
		}
		if (qName.equals("POW")) {
			currentRow.setPow(ReadUtil.readTextContent(content));
		}
		if (qName.equals("GMI")) {
			currentRow.setGmi(ReadUtil.readTextContent(content));
		}
		if (qName.equals("RODZ")) {
			currentRow.setRodz(ReadUtil.readTextContent(content));
		}
		if (qName.equals("NAZWA")) {
			currentRow.setNazwa(ReadUtil.readTextContent(content));
		}
		if (qName.equals("NAZWA_DOD")) {
			currentRow.setNazwa_dod(ReadUtil.readTextContent(content));
		}
	}

	public void characters(char[] ch, int start, int length) {
		content.append(ch, start, length);
	}

	public List<TercRow> getData() {
		return data;
	}
}
