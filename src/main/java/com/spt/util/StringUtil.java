package com.spt.util;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by maher on 10/30/2015.
 */
public class StringUtil {
    public static String randomHighStrengthPassword(int length) {
        Random random = new Random(System.currentTimeMillis());
        int minLetters = 1;
        int minNumbers = 1;
        int minSpecials = 1;
        int letters = minLetters + Math.abs(random.nextInt()) % (length - minNumbers - minSpecials);
        int specials = minSpecials + Math.abs(random.nextInt()) % (length - letters - minNumbers);
        int numbers = length - letters - specials;
        return randomString(letters, numbers, specials);
    }

    private static String randomString(int letters, int numbers, int specials) {
        Random random = new Random(System.currentTimeMillis());
        letters = letters >= 0 ? letters : 0;
        numbers = numbers >= 0 ? numbers : 0;
        specials = specials >= 0 ? specials : 0;
        ArrayList<RandomElementFactory> factories = new ArrayList<RandomElementFactory>();
        if (letters > 0) {
            factories.add(new RandomElementFactory(random, letters, RandomElementFactory.LETTERS));
        }
        if (numbers > 0) {
            factories.add(new RandomElementFactory(random, numbers, RandomElementFactory.NUMBERS));
        }
        if (specials > 0) {
            factories.add(new RandomElementFactory(random, specials, RandomElementFactory.SPECIALS));
        }
        StringBuffer password = new StringBuffer();
        while (password.length() < (letters + numbers + specials)) {
            int idx = Math.abs(random.nextInt()) % factories.size();
            RandomElementFactory factory = factories.get(idx);
            password.append(factory.next());
            if (!factory.hasRemainingElements()) {
                factories.remove(factory);
            }
        }
        return password.toString();
    }
}
