package ru.goryachev.forgeo;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    //Config classes
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                Config.class
        };
    }

    //servlet mapping
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
