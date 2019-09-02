/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.prem.capp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class ContactAppDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringRootConfig.class};  //Returns multiple classes so class[]
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringWebConfig.class};      
    }

    // Servlet allows multiple mappings
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //For whole application
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext); //must present
        //Configure global task here if required
    }  
}
