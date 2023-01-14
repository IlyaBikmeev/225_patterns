package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    //private static final long serialVersionUID = 123456765432L;
    private transient static int COUNT = 0;

    private final int id;
    private String nickname;
    private String password;

    private List<Post> posts;

    public User(String nickname, String password, List<Post> posts) {
        this.id = ++COUNT;
        this.nickname = nickname;
        this.password = password;
        this.posts = new ArrayList<>(posts);
    }

    public User(String nickname, String password) {
        this.id = ++COUNT;
        this.nickname = nickname;
        this.password = password;
        this.posts = new ArrayList<>();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", posts=" + posts +
                '}';
    }

    public int getId() {
        return this.id;
    }
}
