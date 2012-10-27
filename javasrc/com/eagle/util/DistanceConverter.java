package com.eagle.util;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 27/10/12
 * Time: 8:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class DistanceConverter {
    public static float convertKmToMile(float km) {
        return km / 1.60934f;
    }
    public static float convertMileToKm(float mi){
        return mi*1.60934f;
    }
}
