package com.codecool;

import java.util.concurrent.ThreadLocalRandom;

public class Weather {

    static boolean isRaining = false;

    static void setRaining() {
        int decideRaining = ThreadLocalRandom.current().nextInt(1, 101);
        isRaining = decideRaining <= 30 && decideRaining >= 1;
    }
    static boolean isRaining() {
        return isRaining;
    }

}
