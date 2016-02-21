package com.spt.util;

import java.util.Random;

public class RandomElementFactory {
    public static final char[] SPECIALS = new char[] {'!','@','#','$','%','^','&','*','(',')',':','<','>','?'};
    public static final char[] LETTERS = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public static final char[] NUMBERS = new char[] {'1','2','3','4','5','6','7','8','9','0'};
    public static final char[] SMALL_LETTERS = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static final char[] CAPITAL_LETTERS = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    private Random random;
    private int remaining;
    private char[] chars;

    public RandomElementFactory(Random random, int count, char[] chars) {
        this.random = random;
        this.remaining = count;
        this.chars = chars;
    }

    public boolean hasRemainingElements() {
        return remaining > 0;
    }

    public char next() {
        remaining--;
        return chars[Math.abs(random.nextInt())%chars.length];
    }

}