package pl.warg.terytor.api.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TercRecord {
	private String province; // wojewodztwo
	private String county; // powiat
	private String commune; // gmina

	public TercRecord(String province, String county, String commune) {
		this.province = province;
		this.county = county;
		this.commune = commune;
	}
}
