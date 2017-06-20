package com.android.server.display;

import java.lang.Math;

public class ColorUtils {
     /**
     * Convert color temperature in Kelvins to ColorMatrix color
     * @param temperature
     * @return array of ColorMatrix (R, G, B)
     */
    public static float[] RGBfromK(int temperature) {
	float[] rgb = new float[3];
        temperature = temperature / 100;
        double red;
        double green;
        double blue;
        // R
        if (temperature <=66 )red = 255;
        else {
	    red = temperature - 60;
	    red = 329.698727446 * (Math.pow (red, -0.1332047592));
	    if (red < 0) red = 0;
	    if (red > 255) red = 255;
        }
        // G
        if (temperature <= 66){
	green = temperature;
	green = 99.4708025861 * Math.log(green) - 161.1195681661;
	if (green < 0) green = 0;
        if (green > 255) green = 255;
	}
	else {
        green = temperature - 60;
        green = 288.1221695283 * (Math.pow(green, -0.0755148492));
        if (green < 0) green = 0;
        if (green > 255) green = 255;
	}
	
        // B
	if (temperature >= 66) blue = 255;
	else 
        if (temperature <= 19) blue = 0;
        else {
            blue = temperature - 10;
            blue = 138.5177312231 * Math.log(blue) - 305.0447927307;
            if (blue < 0) blue = 0;
            if (blue > 255) blue = 255;
        }
	red = red /255;
	green = green /255;
	blue = blue /255;
	  rgb[0] = (float) red;
	  rgb[1] = (float) green;
	  rgb[2] = (float) blue;
        return rgb;
    }
}