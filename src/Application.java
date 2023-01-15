import model.Post;
import model.User;
import model.dao.PostDao;
import model.dao.UserDao;

import java.util.List;
import java.util.Scanner;

/**
 * Пользователь авторизуется,
 * затем он может создавать новые посты, просматривать свои посты, просматривать все посты, удалять посты.
 */

public class Application {
    private final PostDao postDao;
    private final UserDao userDao;
    private final Scanner scanner;
    private boolean running;
    private User currentUser;

    public Application(PostDao postDao, UserDao userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.scanner = new Scanner(System.in);
        this.running = true;
    }

    public void run() {
        while(running) {
            //Если пользователь авторизован
            if(currentUser != null) {
                selectionMenu();
            }
            else {
                mainMenu();
            }
        }

        postDao.save();
        userDao.save();
    }

    private void mainMenu() {
        System.out.println("------------ГЛАВНОЕ МЕНЮ------------");
        System.out.println("Чтобы авторизоваться - нажмите 1\nЧтобы зарегистрироваться - 2\n Выход - 3");
        int action = scanner.nextInt();
        if(action == 1) {
            authHanlder();
        }
        else if(action == 2) {
            registerHandler();
        }
        else if(action == 3) {
            this.running = false;
        }
        else {
            System.out.println("Неизвестная команда...");
        }
    }

    private void selectionMenu() {
        System.out.println("---------Выберите действие---------");
        System.out.println("1 - Cоздать новый пост\n2 - Посмотреть свои посты\n3 - Посмотреть все посты\n4 - Удалить свой пост" +
                "\n5 - Выйти из системы");
        int action = scanner.nextInt();
        if(action == 1) {
            createNewPostHanlder();
        }
        else if(action == 2) {
            showPostsHandler();
        }
        else if(action == 3) {
            showAllPostsHandler();
        }
        else if(action == 4) {
            deletePostHandler();
        }
        else if(action == 5) {
            logoutHandler();
        }
        else {
            System.out.println("Неизвестная команда...");
        }
    }

    private void logoutHandler() {
        currentUser = null;
    }

    private void deletePostHandler() {
    }

    private void showAllPostsHandler() {
        List<Post> posts = postDao.allPosts();
        System.out.println("----------------Все посты----------------");
        for(Post post : posts) {
            System.out.println(post);
        }
    }

    //Показать посты текущего юзера
    private void showPostsHandler() {
        System.out.println("------------Ваши посты------------");
        List<Post> posts = postDao.findByUser(currentUser);
        for(Post post : posts) {
            System.out.println(post);
        }
    }

    private void createNewPostHanlder() {
        scanner.nextLine();
        System.out.println("Введите название поста:");
        String title = scanner.nextLine();
        System.out.println("Введите текст поста:");
        String text = scanner.nextLine();
        Post post = new Post(title, text, currentUser);
        postDao.savePost(post);
        System.out.println("Пост успешно сохранён!");
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
            this.currentUser = user;
            System.out.println("Вы успешно авторизованы...");
        }
        else {
            System.out.println("Неверный логин или пароль!");
        }
    }
}
