package in.prem.capp.dao;

import in.prem.capp.domain.User;
import java.util.List;


public interface UserDAO {

    public void save(User u);
    public void update(User u);
    public void delete(User u);
    public void delete(Integer userId);
    public User findById(Integer userId);   // will get only one value when primary is passed
    public List<User> findAll();
    public List<User> findByProperty(String propName /* column name*/, Object propValue /*datatype*/);
    
}
