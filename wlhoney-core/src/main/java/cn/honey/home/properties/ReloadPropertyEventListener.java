package cn.honey.home.properties;

import org.apache.commons.configuration2.builder.ConfigurationBuilderEvent;
import org.apache.commons.configuration2.event.EventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ReloadPropertyEventListener implements EventListener<ConfigurationBuilderEvent> {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void onEvent(ConfigurationBuilderEvent event) {
        logger.info("Start for ConfigurationBuilderEvent");
        ReloadProperty.reload();
        logger.info("End for ConfigurationBuilderEvent");
    }

}
