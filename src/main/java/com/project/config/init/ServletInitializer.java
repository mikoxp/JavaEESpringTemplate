package com.project.config.init;


import com.project.config.spring.WebConfig;
import org.apache.tiles.extras.complete.CompleteAutoloadTilesListener;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * init
 *
 * @author mroziqella
 */
public class ServletInitializer implements WebApplicationInitializer {
    /**
     * @param container container
     * @throws ServletException exception
     */
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebConfig.class);
        ctx.setServletContext(container);
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }

    private void tilesConfig(ServletContext container) {
        container.addListener(new CompleteAutoloadTilesListener());
    }
}