package pe.ucs.escuela.daoImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.ucs.escuela.dao.PostDao;
import pe.ucs.escuela.model.Post;


/**
 *
 * @author admin
 */
@Repository
public class PostDaoImpl implements PostDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(Post escuela) {
        String SQL ="INSERT INTO escuela(nombre) VALUES(?)";
        return jdbcTemplate.update(SQL,new Object[]{escuela.getNombre()});
    }

    @Override
    public int update(Post escuela) {
        String SQL ="UPDATE escuela SET nombre=? WHERE idescuela=?";                 
        return jdbcTemplate.update(SQL,new Object[]{escuela.getNombre(), escuela.getIdescuela()});
    }

    @Override
    public int delete(int id) {
        String SQL ="DELETE FROM escuela WHERE idescuela=?"; 
        return jdbcTemplate.update(SQL,id);
        
    }

    @Override
    public Post read(int id) {
        String SQL ="SELECT * FROM escuela WHERE idescuela=?";
        try {
            Post escuela = jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(Post.class),id);
            return escuela;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Post> readAll() {
        String SQL ="SELECT idescuela, nombre FROM escuela ORDER BY idescuela ASC";        
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Post.class));
    }
    
}
