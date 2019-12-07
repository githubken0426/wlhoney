package cn.honey.home.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONFormatUtils {

    private static final Logger logger = LogManager.getLogger();
    private static final String EMPTY_JSON = "{}";
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    private JSONFormatUtils() {

    }

    public static String format(Object pojo) {
        try {
            return mapper.writeValueAsString(pojo);
        } catch (JsonProcessingException e) {
            logger.error("JsonProcessingException, pojo = {}", pojo, e);
            return EMPTY_JSON;
        }
    }

    public static <T> T parse(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            logger.error("IOException, json = {}, clazz = {}", json, clazz, e);
            try {
                return clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException e1) {
                logger.error("InstantiationException or IllegalAccessException, clazz = {}", clazz, e1);
                return null;
            }
        }
    }

    public static <T> List<T> parseToList(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructParametricType(ArrayList.class, clazz));
        } catch (IOException e) {
            logger.error("IOException, json = {}, clazz = {}", json, clazz, e);
            return null;
        }
    }

    public static boolean isEmptyJson(String json) {
        return EMPTY_JSON.equals(json);
    }
}
