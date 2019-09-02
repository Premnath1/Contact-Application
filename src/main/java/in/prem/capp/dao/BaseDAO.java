package in.prem.capp.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

//NOTE: do not @Repository or @Service or @Component annotation
// It must be inherited in DAOImpl so it is abstract
abstract public class BaseDAO extends NamedParameterJdbcDaoSupport{
    
    // Alreadyy there is method called setDataSource in NamedParameterJdbcDaoSupport
    // 
    @Autowired
    public void setDataSource2(DataSource ds){
        super.setDataSource(ds);
    }
}
