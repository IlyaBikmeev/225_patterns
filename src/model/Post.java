package model;

import java.io.Serializable;
import java.util.Objects;

public class Post implements Serializable {
    //private static final long serialVersionUID = 12345526765432L;

    private transient static int COUNT = 0;
    private final int id;
    private String title;       //Заголовок
    private String text;        //Текст поста
    private User user;

    public Post(String title, String text, User user) {
        this.id = ++COUNT;
        this.title = title;
        this.text = text;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id && title.equals(post.title) && text.equals(post.text) && user.equals(post.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, text, user);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", user=" + user +
                '}';
    }
}
