package pet.java.utils;

import java.text.Normalizer;

public class StringUtil {
    public StringUtil() {
    }

    public String normalizeString(String string) {
        String stringNormalized = Normalizer.normalize(string, Normalizer.Form.NFD).replaceAll("\\p{Mn}", "");
        return stringNormalized;
    }
}
