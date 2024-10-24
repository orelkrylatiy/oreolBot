package org.example;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App {
    public static boolean exitFlag = false;
    private static final InputService inputService = new InputService();
    private static final BotServices botServices = new BotServices();

    public static void main(String[] args) {
        startApplication();
    }

    public static void startApplication() {
        System.out.println("Добро пожаловать в учебного бота! Введите команду /about:");
        while (!exitFlag) {
            System.out.println("Main menu");
            String inputConsole = inputService.readLine();
            if (inputConsole.equals("/exit")) break;
            botServices.handleCommand(inputConsole);
        }
    }
}
