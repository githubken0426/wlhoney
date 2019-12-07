package cn.honey.home.util;


import cn.honey.home.properties.ReloadProperty;

import java.util.List;

public class PropertyUtils {

    private PropertyUtils() {

    }

    public static String getString(String key) {
        return ReloadProperty.getConfiguration().getString(key);
    }

    public static String getString(String key, String defaultValue) {
        return ReloadProperty.getConfiguration().getString(key, defaultValue);
    }

    public static String[] getStringArray(String key) {
        return ReloadProperty.getConfiguration().getStringArray(key);
    }

    public static List<String> getStringList(String key) {
        return ReloadProperty.getConfiguration().getList(String.class, key);
    }

    public static int getInt(String key) {
        return getInt(key, -1);
    }

    public static int getInt(String key, int defaultValue) {
        return ReloadProperty.getConfiguration().getInt(key, defaultValue);
    }

    public static long getLong(String key) {
        return getLong(key, -1);
    }

    public static long getLong(String key, long defaultValue) {
        return ReloadProperty.getConfiguration().getLong(key, defaultValue);
    }

    public static boolean getBoolean(String key) {
        return ReloadProperty.getConfiguration().getBoolean(key ,false);
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return ReloadProperty.getConfiguration().getBoolean(key, defaultValue);
    }

}
