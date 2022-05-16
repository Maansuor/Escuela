/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.ucs.escuela.service;

import java.util.List;
import pe.ucs.escuela.model.Post;

/**
 *
 * @author admin
 */
public interface PostService {
    int create(Post escuela);
    int update(Post escuela);
    int delete(int id);
    Post read(int id);
    List<Post> readAll();
}
