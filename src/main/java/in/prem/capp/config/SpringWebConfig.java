package in.prem.capp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration                               // Configure the parameters and settings on our PC
@ComponentScan(basePackages = {"in.ezeon"})  // Indicates where my components are stored    
@EnableWebMvc                                // Activate MVC module
public class SpringWebConfig extends WebMvcConfigurerAdapter{

    // To add static resources like css,Javascript,etc.. 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
    
    // Spring IoC Container = Bean(which wire, manage and configure among the objects)
    @Bean
    public ViewResolver viewResolver(){
        
        // Resources available within the private directory(WEB_INF) for security
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setViewClass(JstlView.class);        // To use jstl code in JSP
        vr.setPrefix("/WEB-INF/view/");         // prefix says where my jsps are
        vr.setSuffix(".jsp");                   // Extension
        return vr;
    }    
    
}
