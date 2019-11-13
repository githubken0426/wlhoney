package cn.honey.home.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

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
                .excludePathPatterns("/css/**", "/gasp/**", "/windmill/**",
                        "/jQuery/**", "/layer/**", "/swiper/**", "/files/**");
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
}