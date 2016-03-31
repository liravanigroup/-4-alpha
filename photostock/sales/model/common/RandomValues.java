package pl.com.bottega.photostock.sales.model.common;

import java.util.UUID;

/**
 * Sergej Povzaniuk
 * 2016-03-30.
 */
public class RandomValues {
    public static String getRandomUID(){
        UUID id = UUID.randomUUID();
        return id.toString();
    }
}
