package org.example;
import java.util.HashMap;
import java.util.Map;


public class BotServices {
    private final Map<String, Runnable> serviceMap = new HashMap<>();
    OutputService outputService = new OutputService();
    public BotServices() {
        // Сохраняем ссылки на объекты других классов
        serviceMap.put("/exit", this::stop);
        serviceMap.put("/menu", () -> outputService.print(getHelpMessage()));
        serviceMap.put("/about", () -> outputService.print(aboutMessage()));
        serviceMap.put("/start_learn_theory", () -> new TheoryService().startTheory());
        serviceMap.put("/start_tests", () -> new TestService().getTest());
    }

    public void handleCommand(String command) {
        serviceMap.getOrDefault(command, () -> System.out.println("Неизвестная команда или сервис. Введите /help:")).run();

    }

    public String getHelpMessage() {
        return "Список доступных команд, которые ты можешь использовать:\n\n" +
                "2 " + "/start_learn_theory - Начать изучение теории по JavaScript.\n" +
                "3 " + "/start_tests - Пройти тесты для проверки своих знаний.\n" +
                "4 " + "/training_mode - Включить тренировочный режим для практики.\n" +
                "5 " + "/view_progress - Просмотреть свой прогресс и достижения.\n" +
                "6 " + "/achievements - Посмотреть свои достижения.\n" +
                "7 " + "/daily_task - Получить ежедневное задание для практики.\n" +
                "8 " + "/ask_question - Задать вопрос по теории или JavaScript, и я постараюсь ответить.\n\n" +
                "Используй эти команды, чтобы изучать JavaScript и проверять свои знания! Если тебе нужна помощь по конкретной команде, просто напиши её название, и я помогу.";
    }

    public String aboutMessage(){
        return "Я бот, который поможет тебе стать сеньором-помидором!";
    }

    public void stop(){
        App.exitFlag = true;
        outputService.print("YEEEE");
    }
}
