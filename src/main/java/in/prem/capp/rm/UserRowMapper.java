package in.prem.capp.rm;

import in.prem.capp.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

//Row Mapper object -> will map one database record to one domain object
public class UserRowMapper implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        // i = rowNumber
        User u = new User();
        u.setUserId(rs.getInt("userId"));
        u.setName(rs.getString("name"));
        u.setPhone(rs.getString("phone"));
        u.setEmail(rs.getString("email"));
        u.setAddress(rs.getString("address"));
        u.setLoginName(rs.getString("loginName"));
        u.setRole(rs.getInt("role"));
        u.setLoginStatus(rs.getInt("loginStatus"));
        return u;
    }    
}
