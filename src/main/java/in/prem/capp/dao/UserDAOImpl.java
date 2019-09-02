package in.prem.capp.dao;

import in.prem.capp.domain.User;
import in.prem.capp.rm.UserRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

// Class comminacate with the database so Respository
@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

    @Override
    public void save(User u) {
        String sql = "INSERT INTO user(name, phone, email, address, loginName, password, role, loginStatus)"
                + " VALUES(:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";
        // : Parameter = Named Parameter
        
        Map m = new HashMap();
        m.put("name", u.getName());
        m.put("phone", u.getPhone());
        m.put("email", u.getEmail());
        m.put("address", u.getAddress());
        m.put("loginName", u.getLoginName());
        m.put("password", u.getPassword());
        m.put("role", u.getRole());
        m.put("loginStatus", u.getLoginStatus());

        // Bind the Auto-incremented value 
        KeyHolder kh = new GeneratedKeyHolder();
        // It represents from where the named parameters taking its value
        SqlParameterSource ps = new MapSqlParameterSource(m);
        super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
        Integer userId = kh.getKey().intValue();    // UserId
        u.setUserId(userId);
    }

    @Override
    public void update(User u) {
        String sql = "UPDATE user "
                + " SET name=:name,"
                + " phone=:phone, "
                + " email=:email,"
                + " address=:address,"
                + " role=:role,"
                + " loginStatus=:loginStatus "
                + " WHERE userId=:userId";
        Map m = new HashMap();
        m.put("name", u.getName());
        m.put("phone", u.getPhone());
        m.put("email", u.getEmail());
        m.put("address", u.getAddress());       
        m.put("role", u.getRole());
        m.put("loginStatus", u.getLoginStatus());
        m.put("userId", u.getUserId());
        getNamedParameterJdbcTemplate().update(sql, m); //Pass query,map and update
    }

    @Override
    public void delete(User u) {
        this.delete(u.getUserId());
    }

    @Override
    public void delete(Integer userId) {
        String sql="DELETE FROM user WHERE userId=?";
        getJdbcTemplate().update(sql, userId);
    }

    //Row Mapper object -> will map one database record to one domain object
    @Override
    public User findById(Integer userId) {
        String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user WHERE userId=?";
        // One record for one Object
        User u = getJdbcTemplate().queryForObject(sql, new UserRowMapper(),userId);
        return u;
    }

    @Override
    public List<User> findAll(){
           String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user";
           return getJdbcTemplate().query(sql, new UserRowMapper());
    }

    @Override
    public List<User> findByProperty(String propName, Object propValue) {
         String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user WHERE "+propName+"=?";
         return getJdbcTemplate().query(sql, new UserRowMapper(), propValue);
    }
}
