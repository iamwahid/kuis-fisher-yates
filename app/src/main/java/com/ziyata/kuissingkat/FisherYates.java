package com.ziyata.kuissingkat;

import java.util.Random;

public class FisherYates {
    public static <T> void shuffle(T[] abc) {
        int size = abc.length;
        Random random = new Random();
        for(int alph=0; alph<abc.length; alph++) {
            int randomIndex = alph + random.nextInt(size - alph);
            T randomLetter = abc[randomIndex];
            abc[randomIndex] = abc[alph];
            abc[alph] = randomLetter;
        }
        for(int shuffled = 0; shuffled<abc.length; shuffled++)
            System.out.print(abc[shuffled]+" ");
        System.out.println();
        // a, b, c, d, e, f, g
        // 0+1 = b randomletter
        // b., a., c, d, e, f, g
        // 0+5 = f randomletter
        // b, f., c, d, e, a., g
    }
}
