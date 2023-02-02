package string_hacks;

import java.text.MessageFormat;

public class StringFormat {
    public static void main(String[] args) {
        String stringWithPlaceHolder = "test String with placeholders {0} {1} {2} {0}";
        String formattedString = MessageFormat.format(stringWithPlaceHolder, "PLACE-HOLDER-1", "PLACE-HOLDER-2", "PLACE-HOLDER-3", "PLACE-HOLDER-4");
        System.out.println(formattedString);

    }
}
