package model.dao;

import model.Post;
import model.User;

import java.util.List;

public interface PostDao {
    List<Post> allPosts();
    Post findById(int id);
    List<Post> findByUser(User user);
    void savePost(Post post);

    default void save() {
        throw new UnsupportedOperationException();
    }
}
