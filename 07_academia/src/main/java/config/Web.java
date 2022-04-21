package config;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

//Java EE
public class Web implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) {
      
      AnnotationConfigWebApplicationContext dispatcherContext =new AnnotationConfigWebApplicationContext();
      dispatcherContext.register(ServiceConfig.class);
      dispatcherContext.register(MvcConfig.class);
      
      ServletRegistration.Dynamic dispatcher =
        container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
      dispatcher.setLoadOnStartup(1);
      dispatcher.addMapping("/");
      FilterRegistration.Dynamic filter=container.addFilter("encoding", new CharacterEncodingFilter());
      filter.setInitParameter("encoding", "UTF-8");
      filter.setInitParameter("forceEncoding", "true");
      //filter.addMappingForUrlPatterns(DispatcherType., true, "/*")
      
    }
 }