package pl.warg.terytor.util;

import com.google.common.base.Strings;

public class TercUtil {

	public static boolean isTercCodeValid(String tercCode) {
		if (Strings.isNullOrEmpty(tercCode) || tercCode.length() < 6 || tercCode.length() > 7) {
			return false;
		}
		return true;
	}
}
