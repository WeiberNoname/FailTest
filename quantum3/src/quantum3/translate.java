package quantum3;

import java.text.NumberFormat;
import java.util.Locale;

public class translate {
	 public static void main(String[] args) {
		   Locale usLocale = Locale.forLanguageTag("en-US");
		   Locale deLocale = Locale.forLanguageTag("de-Germany");
		   long number = 123456789L;
		   NumberFormat denf = NumberFormat.getInstance(deLocale);
		   NumberFormat usnf = NumberFormat.getInstance(usLocale);
		   System.out.println( denf.format(number) );
		   System.out.println( usnf.format(number) );
		 }

}
