package in.prem.capp.service;

import in.prem.capp.dao.BaseDAO;
import in.prem.capp.dao.ContactDAO;
import in.prem.capp.domain.Contact;
import in.prem.capp.rm.ContactRowMapper;
import in.prem.capp.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl extends BaseDAO implements ContactService{
    
    @Autowired
    private ContactDAO contactDAO;  //DAO is helper in service level because we use the same methods
    
    @Override    
    public void save(Contact c) {
        contactDAO.save(c);
    }

    @Override
    public void update(Contact c) {
        contactDAO.update(c);
    }

    @Override
    public void delete(Integer cotactId) {
        contactDAO.delete(cotactId);
    }

    @Override
    public void delete(Integer[] cotactIds) {
        String ids = StringUtil.toCommaSeparatedString(cotactIds);
        String sql = "DELETE FROM contact WHERE contactId IN("+ids+")";
        getJdbcTemplate().update(sql);
    }

    @Override
    public List<Contact> findUserContact(Integer userId) {
        return contactDAO.findByProperty("userId", userId);
    }

    //Search Engine
    @Override
    public List<Contact> findUserContact(Integer userId, String txt) {
        String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE userId=? AND (name LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%' OR email LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%')";
        return getJdbcTemplate().query(sql, new ContactRowMapper(),userId); 
    }

    @Override
    public Contact findById(Integer cotactId) {
        return contactDAO.findById(cotactId);
    }
    
}
