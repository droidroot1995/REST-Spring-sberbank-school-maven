package tk.droidroot.restservice.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryDao {
    @Autowired
    private NamedParameterJdbcTemplate template;

    public void save(){

    }
}
