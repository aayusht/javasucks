import java.util.HashMap;
import java.util.Map;

public class NullDemo {
    static String str = null;

    public static void main(String[] args) {
        System.out.println(str.length());
        System.out.println(getTranslations().get("four"));

        // subtle, but could fail due to async
        if (str != null) {
            int x = str.length();
        }
    }

    private static Map<String, String> getTranslations() {
        HashMap<String, String> translations = new HashMap<>();
        translations.put("one", "ichi");
        translations.put("two", "ni");
        translations.put("three", "san");
        return translations;
    }
}
