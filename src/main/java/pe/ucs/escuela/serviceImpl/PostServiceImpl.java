/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.ucs.escuela.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.ucs.escuela.dao.PostDao;
import pe.ucs.escuela.model.Post;
import pe.ucs.escuela.service.PostService;

/**
 *
 * @author admin
 */
@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostDao postDao;
    @Override
    public int create(Post escuela) {
        return postDao.create(escuela);
    }

    @Override
    public int update(Post escuela) {
        return postDao.update(escuela);
    }

    @Override
    public int delete(int id) {
        return postDao.delete(id);
    }

    @Override
    public Post read(int id) {
        return postDao.read(id);
    }

    @Override
    public List<Post> readAll() {
        return postDao.readAll();
    }
    
}
