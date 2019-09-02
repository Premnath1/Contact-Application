 package in.prem.capp.test;

import in.prem.capp.config.SpringRootConfig;
import in.prem.capp.dao.UserDAO;
import in.prem.capp.domain.User;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserDAOFindAll {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO=ctx.getBean(UserDAO.class);   
        
        List<User> users = userDAO.findAll();
        for (User u : users) {
             System.out.println(u.getUserId()+" "+u.getName()+" "+u.getRole());
             //TODO: access other columns
        }
    }    
}
