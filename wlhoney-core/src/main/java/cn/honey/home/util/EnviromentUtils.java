package cn.honey.home.util;

import org.apache.commons.lang3.StringUtils;

public class EnviromentUtils {
    
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String HOMER_VERSION = "APP_VERSION";

    public static String getConfBasePath() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.getenv("APP_CONFIGURATION"))
        .append(FILE_SEPARATOR)
        .append("acl-conf");
        return stringBuilder.toString();
    }
    
    public static String getKeystorePath(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getConfBasePath())
        .append(FILE_SEPARATOR)
        .append("keystore")
        .append(FILE_SEPARATOR)
        .append(fileName);
        return stringBuilder.toString();
    }
    
    public static String getPropertiesPath(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getConfBasePath())
        .append(FILE_SEPARATOR)
        .append(fileName);
        return stringBuilder.toString();
    }
    
    /**
     * Convert to effective virtual host because it needs upper case letter for homer version.
     */
    public static String convertVirtualHost(String name) {
        String homerVersion = System.getenv(HOMER_VERSION);
        if (StringUtils.isBlank(homerVersion)) {
            return name;
        }
        name = name.replace(homerVersion, homerVersion.trim().toUpperCase());
        return name;
    }

    public static boolean isProdEnvironment() {
        String environment = PropertyUtils.getString("environment");
        if (StringUtils.isBlank(environment)) {
            throw new IllegalStateException("'environment' required in configuration properties!");
        }
        return environment.trim().equals("prod");
    }
}
