package Utility;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;




public class CreditCardInfoMask {

	public static String maskJson(final String json) {
		if (StringUtils.isNotBlank( json )) {
			final String cc = getMarkupContent( json, "\"CreditCardNumber\":\"([0-9]*)\"" );
			final String cvv = getMarkupContent( json, "\"SecurityCode\":\"([0-9]*)\"" );
			return json.replace( cc, getMaskedCardNumber( cc ) ).replace( cvv, getMaskedCvvNumber( cvv ) );
		}
		return json;
	}

	private static String getMarkupContent(final String content, final String regex) {
		final Pattern p = Pattern.compile( regex );
		final Matcher m = p.matcher( content );
		if (m.find()) {
			return m.group( 1 );
		}
		return StringUtils.EMPTY;
	}

	private static String getMaskedCardNumber(final String cc) {
		if (StringUtils.isNotBlank( cc )) {
			return cc.substring( 0, 6 ) + "****" + cc.substring( cc.length() - 4 );
		}
		return StringUtils.EMPTY;
	}

	private static String getMaskedCvvNumber(final String cvv) {
		if (StringUtils.isNotBlank( cvv )) {
			return StringUtils.repeat( "*", cvv.length() );
		}
		return StringUtils.EMPTY;
	}
}
