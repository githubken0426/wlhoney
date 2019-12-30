package cn.honey.home.web;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WLHoneyConfigure implements WebMvcConfigurer {

    @Value("${global.fileRequestUrl}")
    private String fileRequestUrl;
    @Value("${global.fileUploadPath}")
    private String fileUploadPath;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**", fileRequestUrl).
                addResourceLocations("classpath:/static/", "file:" + fileUploadPath);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ThemeChangeInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/bootstrap/**", "/css/**", "/gasp/**", "/mobiscroll/**",
                        "/windmill/**", "/jQuery/**", "/layer/**", "/swiper/**",
                        "/files/**");
    }

    /**
     * 跨域支持
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600 * 24);
    }

    @Bean("restTemplate")
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate template = new RestTemplate();
       /* ClientHttpRequestInterceptor interceptor = new BasicAuthenticationInterceptor("eureka-server", "eureka-server");
        template.getInterceptors().add(interceptor);*/
        template.getMessageConverters().clear();
        template.getMessageConverters().add(new MyJsonHttpMessageConverter());
        return template;
    }

    class MyJsonHttpMessageConverter extends FastJsonHttpMessageConverter {
        public MyJsonHttpMessageConverter() {
            this.setSupportedMediaTypes(supportedMediaTypes());
        }

        private List<MediaType> supportedMediaTypes() {
            List<MediaType> supportedMediaTypes = new ArrayList<>();
            supportedMediaTypes.add(MediaType.APPLICATION_JSON);
            supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
            supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
            supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
            supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
            supportedMediaTypes.add(MediaType.APPLICATION_PDF);
            supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
            supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
            supportedMediaTypes.add(MediaType.APPLICATION_XML);
            supportedMediaTypes.add(MediaType.IMAGE_GIF);
            supportedMediaTypes.add(MediaType.IMAGE_JPEG);
            supportedMediaTypes.add(MediaType.IMAGE_PNG);
            supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
            supportedMediaTypes.add(MediaType.TEXT_HTML);
            supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
            supportedMediaTypes.add(MediaType.TEXT_PLAIN);
            supportedMediaTypes.add(MediaType.TEXT_XML);
            return supportedMediaTypes;
        }
    }
}