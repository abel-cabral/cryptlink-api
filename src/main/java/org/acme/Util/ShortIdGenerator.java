package org.acme.Util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class ShortIdGenerator {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int LENGTH = 6;
    private static final Random random = new Random();

    public static String generateShortId() {
        // Possibilidades de combinações -> 56.800.235.584
        StringBuilder shortId = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            shortId.append(CHARACTERS.charAt(randomIndex));
        }
        return shortId.toString();
    }

    public static boolean isValidURL(String urlString) {
        try {
            new URL(urlString);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }
}
