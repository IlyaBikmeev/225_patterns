package model.dao;

import model.Post;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PostDaoInFileImpl implements PostDao {
    private final String fileName;
    private List<Post> posts;

    public PostDaoInFileImpl(String fileName) {
        this.fileName = fileName;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            this.posts = (List<Post>) inputStream.readObject();
        }
        catch(IOException | ClassNotFoundException ex) {
            this.posts = new ArrayList<>();
        }
    }

    @Override
    public void save() {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(posts);
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Post> allPosts() {
        return posts;
    }

    @Override
    public Post findById(int id) {
        return posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst().orElseThrow();
    }
}
