/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.ucs.escuela.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.ucs.escuela.model.Post;
import pe.ucs.escuela.service.PostService;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/escuela")
public class PostRestController {

    @Autowired
    private PostService postService;

    @GetMapping("/all")
    public List<Post> getPosts() {
        return postService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable int id) {
        Post escuela = postService.read(id);
        return ResponseEntity.ok(escuela);
    }

    @DeleteMapping("/{id}")
    public int deletePost(@PathVariable int id) {        
        return postService.delete(id);
    }
    @PostMapping("/add")
    public int addPost(@RequestBody Post escuela) {  
        System.out.println(escuela.getNombre());
        return postService.create(escuela);
    }
    @PutMapping("/edit")
    public int editPost(@RequestBody Post escuela) {  
        Post es = new Post(escuela.getIdescuela(),escuela.getNombre());
        System.out.println(escuela.getIdescuela()+" , "+escuela.getNombre());
        return postService.update(escuela);
    }
}
