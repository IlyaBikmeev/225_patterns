import model.User;
import model.dao.PostDao;
import model.dao.UserDao;

import java.util.Scanner;

public class Application {
    private final PostDao postDao;
    private final UserDao userDao;
    private final Scanner scanner;

    public Application(PostDao postDao, UserDao userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while(true) {
            System.out.println("------------ГЛАВНОЕ МЕНЮ------------");
            System.out.println("Чтобы авторизоваться - нажмите 1\nЧтобы зарегистрироваться - 2\n Все пользователи - 3\n Выход - 4");
            int action = scanner.nextInt();
            if(action == 1) {
                authHanlder();
            }
            else if(action == 2) {
                registerHandler();
            }
            else if(action == 3) {
                showUsersHandler();
            }
            else if(action == 4) {
                break;
            }
            else {
                System.out.println("Неизвестная команда...");
            }
        }

        postDao.save();
        userDao.save();
    }

    private void showUsersHandler() {
        System.out.println("Пользователи нашего сервиса:");
        System.out.println(userDao.allUsers());
    }

    private void registerHandler() {
        System.out.println("Введите никнейм:");
        String nickName = scanner.next();
        System.out.println("Введите пароль:");
        String password = scanner.next();
        User user = new User(nickName, password);
        if(userDao.register(user)) {
            System.out.println("Вы успешно зарегистрированы!");
        }
        else {
            System.out.println("Такой пользователь уже существует.");
        }
    }

    //Обработка авторизации
    private void authHanlder() {
        System.out.println("Введите никнейм:");
        String nickName = scanner.next();
        System.out.println("Введите пароль:");
        String password = scanner.next();
        User user = new User(nickName, password);
        if(userDao.auth(user)) {
            System.out.println("Вы успешно авторизованы...");
        }
        else {
            System.out.println("Неверный логин или пароль!");
        }
    }
}
