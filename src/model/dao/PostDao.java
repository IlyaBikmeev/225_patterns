package model.dao;

import model.Post;

import java.util.List;

public interface PostDao {
    List<Post> allPosts();
    Post findById(int id);
    default void save() {
        throw new UnsupportedOperationException();
    }
}
