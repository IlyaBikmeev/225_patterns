package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {
    //private static final long serialVersionUID = 123456765432L;
    private transient static int COUNT = 0;

    private int id;
    private String nickname;
    private String password;

    public User(String nickname, String password) {
        this.id = ++COUNT;
        this.nickname = nickname;
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && nickname.equals(user.nickname) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
