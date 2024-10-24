//package org.example;
//
//public class UserInterface {
//    private BotServices botServices;
//    private InputService inputService;
//
//    public UserInterface() {
//        botServices = new BotServices();  // Создаем экземпляр BotServices
//        inputService = new InputService(); // Предполагаем, что InputService обрабатывает ввод пользователя
//
//
//    public void run() {
//        System.out.println("Введите команду:");
//        while (!App.exitFlag) {
//            String command = inputService.readLine();  // Читаем команду от пользователя
//            botServices.handleCommand(command);  // Передаем команду в BotServices для обработки
//        }
//    }
//
//    public static void main(String[] args) {
//        UserInterface ui = new UserInterface();
//        ui.run();  // Запускаем интерфейс пользователя
//    }
//}
