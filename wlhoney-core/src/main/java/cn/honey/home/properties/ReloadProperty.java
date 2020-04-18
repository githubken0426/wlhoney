package cn.honey.home.properties;

import cn.honey.home.util.EnvironmentUtils;
import org.apache.commons.configuration2.CompositeConfiguration;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.ConfigurationBuilderEvent;
import org.apache.commons.configuration2.builder.ReloadingFileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.convert.DefaultListDelimiterHandler;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.reloading.PeriodicReloadingTrigger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ReloadProperty {

    private static final String PROPERTIES_FILE_EXTENSION = ".properties";

    private static final Logger logger = LogManager.getLogger();

    private static CompositeConfiguration compositeConfiguration;

    private static volatile boolean isReloading = false;

    static {
        logger.info("Start initialize ReloadableProperties");
        init();
        logger.info("End initialize ReloadableProperties");
    }

    private static void init() {
        File path = new File(EnvironmentUtils.getConfBasePath());
        File[] propertiesFiles = path.listFiles((File pathname)
                -> pathname.getName().endsWith(PROPERTIES_FILE_EXTENSION));

        CompositeConfiguration cc = new CompositeConfiguration();
        for (int i = 0; i < propertiesFiles.length; i++) {
            logger.info("Load configuration file {}", propertiesFiles[i].getName());
            ReloadingFileBasedConfigurationBuilder builder = new ReloadingFileBasedConfigurationBuilder(PropertiesConfiguration.class)
                    .configure(new Parameters().fileBased().setListDelimiterHandler(new DefaultListDelimiterHandler(','))
                            .setFile(propertiesFiles[i]));
            builder.addEventListener(ConfigurationBuilderEvent.RESET,
                    new ReloadPropertyEventListener());
            PeriodicReloadingTrigger trigger = new PeriodicReloadingTrigger(builder.getReloadingController(),
                    null, getTriggerPeriod(), TimeUnit.SECONDS);
            trigger.start();
            try {
                cc.addConfiguration((Configuration) builder.getConfiguration());
            } catch (ConfigurationException e) {
                logger.error("ConfigurationException in getConfiguration", e);
            }
        }
        compositeConfiguration = cc;
    }

    private static long getTriggerPeriod() {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(EnvironmentUtils.getPropertiesPath("config-env.properties")));
            return Long.valueOf(properties.getProperty("properties.reloadTriggerPeriodSec"));

        } catch (Exception e) {
            logger.warn("Exception in getTriggerPeriod", e);
        }
        return 30;
    }

    public static void reload() {
        if (isReloading) {
            logger.info("ReloadableProperties is reloading, skip this event.");
            return;
        }
        isReloading = true;
        logger.info("Start reload ReloadableProperties");
        init();
        logger.info("End reload ReloadableProperties");
        isReloading = false;
    }

    public static CompositeConfiguration getConfiguration() {
        return compositeConfiguration;
    }


}
