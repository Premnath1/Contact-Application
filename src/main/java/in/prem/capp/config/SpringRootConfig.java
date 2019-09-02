package in.prem.capp.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"in.prem.capp.dao","in.prem.capp.service"})
public class SpringRootConfig {    
    //TODO: Services, DAO, DataSource, Email Sender or some other business layer beans  
    
    @Bean
    public BasicDataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");     // MySql Driver
        ds.setUrl("jdbc:mysql://localhost:3306/capp_db");   
        ds.setUsername("root");
        ds.setPassword("1234");
        ds.setMaxTotal(2);
        ds.setInitialSize(1);
        ds.setTestOnBorrow(true);
        ds.setValidationQuery("SELECT 1");
        ds.setDefaultAutoCommit(true);
        return ds;
    }
}
