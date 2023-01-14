package model;

import java.io.Serializable;

public class Post implements Serializable {
    //private static final long serialVersionUID = 12345526765432L;

    private transient static int COUNT = 0;
    private final int id;
    private String title;       //Заголовок
    private String text;        //Текст поста

    public Post(String title, String text) {
        this.id = ++COUNT;
        this.title = title;
        this.text = text;
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

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
