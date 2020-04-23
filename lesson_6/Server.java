package lesson_6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static boolean isRunning = true;

    public static void run() {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен");

            socket = server.accept();
            System.out.println("Клиент подключен");

            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            Scanner console = new Scanner(System.in);

            Thread serverThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    String msg;
                    try {
                        while (true) {
                            msg = console.nextLine();
                            pw.println("Сервер: " + msg);
                            if (msg.equals("/end")) {
                                isRunning = false;
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                }
            });
            serverThread.start();

            while (isRunning) {
                if (in.hasNext()) {
                    String msg = in.nextLine();
                    if (msg.equalsIgnoreCase("/end")) {
                        serverThread.stop();
                        break;
                    }
                    System.out.println(msg);
                }
            }

        } catch (IOException e) {
            System.out.println("[error] ошибка запуска сервера");
        } finally {
            try {
                server.close();
                System.out.println("Сервер остановлен");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server.run();
    }
}