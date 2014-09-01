package com.djtracksholder.djtracksholder.utils;

/**
 * Created by Вадим on 22.08.2014.
 */

import android.content.Context;
import android.graphics.Typeface;
/**
 * Created by Вадим on 01.07.2014.
 */
public class TypefaceFactory {

    private static final String FONTS_PATH = "fonts/";
    private static final String RALEWAY_BOLD = FONTS_PATH + "Raleway-Bold.otf";
    private static final String RALEWAY_EXTRA_BOLD = FONTS_PATH + "Raleway-ExtraBold.otf";
    private static final String RALEWAY_EXTRA_LIGHT = FONTS_PATH + "Raleway-ExtraLight.otf";
    private static final String RALEWAY_HEAVY = FONTS_PATH + "Raleway-Heavy.otf";
    private static final String RALEWAY_LIGHT = FONTS_PATH + "Raleway-Light.otf";
    private static final String RALEWAY_MEDIUM = FONTS_PATH + "Raleway-Medium.otf";
    private static final String RALEWAY_REGULAR = FONTS_PATH + "Raleway-Regular.otf";
    private static final String RALEWAY_SEMI_BOLD = FONTS_PATH + "Raleway-SemiBold.otf";
    private static final String RALEWAY_THIN = FONTS_PATH + "Raleway-Thin.otf";
    private static final String BRANNBOLL_FET = FONTS_PATH + "BranbollFet.ttf";
    private static final String BRANNBOLL_SMALL = FONTS_PATH + "BranbollSmall.ttf";
    private static final String LOVELO_BOLD = FONTS_PATH + "LoveloLineBold.otf";
    private static final String LOVELO_LIGHT = FONTS_PATH + "LoveloLineLight.otf";
    private static final String LOVELO_BLACK = FONTS_PATH + "LoveloBlack.otf";

    private Context context;
    private static TypefaceFactory factory;

    public static void init(Context context) {
        if (factory == null) {
            factory = new TypefaceFactory(context);
        }
    }

    private TypefaceFactory(Context context) {
        this.context = context;
    }

    private Context getContext() { return this.context; }

    private static Typeface getTypeFace(Context context, String srcFontPath) {
        return Typeface.createFromAsset(context.getAssets(), srcFontPath);
    }

    public static Typeface getRalewayBold() {
        return getTypeFace(factory.getContext(), RALEWAY_BOLD);
    }

    public static Typeface getRalewayExtraBold() {
        return getTypeFace(factory.getContext(), RALEWAY_EXTRA_BOLD);
    }

    public static Typeface getRalewayExtraLight() {
        return getTypeFace(factory.getContext(), RALEWAY_EXTRA_LIGHT);
    }

    public static Typeface getRalewayHeavy() {
        return getTypeFace(factory.getContext(), RALEWAY_HEAVY);
    }

    public static Typeface getRalewayLight() {
        return getTypeFace(factory.getContext(), RALEWAY_LIGHT);
    }

    public static Typeface getRalewayMedium() {
        return getTypeFace(factory.getContext(), RALEWAY_MEDIUM);
    }

    public static Typeface getRalewayRegular() {
        return getTypeFace(factory.getContext(), RALEWAY_REGULAR);
    }

    public static Typeface getRalewaySemiBold() {
        return getTypeFace(factory.getContext(), RALEWAY_SEMI_BOLD);
    }

    public static Typeface getBranbollFet() {
        return getTypeFace(factory.getContext(), BRANNBOLL_FET);
    }

    public static Typeface getBranbollSmall() {
        return getTypeFace(factory.getContext(), BRANNBOLL_SMALL);
    }

    public static Typeface getLoveloBlack() {
        return getTypeFace(factory.getContext(), LOVELO_BLACK);
    }

    public static Typeface getLoveloBold() {
        return getTypeFace(factory.getContext(), LOVELO_BOLD);
    }

    public static Typeface getLoveloLight() {
        return getTypeFace(factory.getContext(), LOVELO_LIGHT);
    }
    public static Typeface getRalewayThin() {
        return getTypeFace(factory.getContext(), RALEWAY_THIN);
    }

}

