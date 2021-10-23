package pl.warg.terytor.xml;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TercRow {
	String woj;
	String pow;
	String gmi;
	String rodz;
	String nazwa;
	String nazwa_dod;

	public String getTercCode() {
		return ""+woj+pow+gmi+rodz;
	}
}
