package lesson_6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static boolean isRunning = true;

    public static void run() {
        String SERVER_ADDR = "localhost";
        int SERVER_PORT = 8189;
        Socket socket = null;
        Scanner in;
        PrintWriter pw;

        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            System.out.println("Клиент запущен");

            in = new Scanner(socket.getInputStream());
            pw = new PrintWriter(socket.getOutputStream(), true);
            Scanner console = new Scanner(System.in);

            Thread clientThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    String msg;
                    try {
                        while (true) {
                            msg = console.nextLine();
                            pw.println("Клиент: " + msg);
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
            clientThread.start();

            while (isRunning) {
                if (in.hasNext()) {
                    String msg = in.nextLine();
                    if (msg.equalsIgnoreCase("/end")) {
                        clientThread.stop();
                        break;
                    }
                    System.out.println(msg);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                System.out.println("Клиент остановлен");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Client.run();
    }
}