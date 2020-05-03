package lesson_8.server;

public interface AuthService {
    String getNicknameByLoginAndPassword(String login, String password);
}
