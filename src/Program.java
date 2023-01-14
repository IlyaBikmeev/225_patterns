import model.Post;
import model.User;
import model.dao.PostDaoInFileImpl;
import model.dao.UserDaoInFileImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {
    public static void main(String[] args) {
        Application app = new Application(new PostDaoInFileImpl("posts.bin"),
                    new UserDaoInFileImpl("users.bin"));
        app.run();
    }
}
