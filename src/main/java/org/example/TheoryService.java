package org.example;

import java.util.function.Supplier;

import com.google.gson.Gson;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Основной сервис
public class TheoryService {

    public class TheoryData {
        private List<Theory> theory;  // Список всех тем

        // Геттер для получения списка тем
        public List<Theory> getTheory() {
            return theory;
        }
    }

    public class Section {
        private String title;
        private String content;
        private int number;

        // Геттеры для доступа к полям
        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public int getNumber(){return number;}
    }

    public class Theory {
        private String command;  // Команда для вызова темы
        private String title;    // Заголовок темы
        private List<Section> sections;  // Список разделов темы

        // Геттеры для доступа к полям
        public String getCommand() {
            return command;
        }

        public String getTitle() {
            return title;
        }

        public List<Section> getSections() {
            return sections;
        }
    }



    private final InputService inputService = new InputService();
    private final OutputService outputService = new OutputService();
    private final BotServices botServices = new BotServices();

    private TheoryData theoryData;  // Переменная для хранения данных из JSON
    private int progress = 0;  // Счётчик прогресса
    private boolean isRunning = true;
    private boolean insideTheory = false;
    private boolean insideTopics = false;

    // Конструктор, который читает JSON при инициализации
    public TheoryService() {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("C:\\Users\\USER\\Desktop\\MyTestBot\\src\\main\\java\\theoryData.json");  // Чтение JSON-файла
            theoryData = gson.fromJson(reader, TheoryData.class);  // Парсим JSON в объект TheoryData
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Этот метод запускает процесс изучения теории
    public void startTheory() {
        displayTopics();  // Показываем список тем
        while (isRunning) {
            //outputService.print("Theory Service!");
            String userCommand = inputService.readLine();

            if (userCommand.equals("/back"))    {
                botServices.handleCommand("/menu");
                isRunning = false;
                return;
            }
            displayContent(userCommand);
        }
    }


    public void displayTopics() {
        if (theoryData != null && theoryData.getTheory() != null) {
        List<Theory> theories = theoryData.getTheory();  // Получаем список тем

            if (theories != null) {
                outputService.print("Доступные темы:");
                // Получаем объект по индексу
                for (Theory theory : theories) {  // Итерируем по индексам
                    outputService.print(theory.getCommand() + ": " + theory.getTitle());
                }
            } else {
                outputService.print("Темы не найдены.");
            }

        }
    }


    public void displayContent(String command){
        final Map<String, Runnable> serviceMap = new HashMap<>();
     //   final Map<Theory, Supplier<Theory>> commandMap = new HashMap<>();
        insideTheory = true;
        serviceMap.put("/introduction_to_javascript", () -> getTheoryByCommand("/introduction_to_javascript"));
        serviceMap.put("/basic_syntax", () -> getTheoryByCommand("/basic_syntax"));
        serviceMap.put("/back", () -> botServices.handleCommand("/menu"));

        serviceMap.getOrDefault(command, () -> System.out.println("Неизвестная команда раздела Теория. Введите команду /about:")).run();

    }


    public void getTheoryByCommand(String command) {
        // Проходим по списку тем и ищем ту, у которой команда совпадает с введённой
        boolean found = false;  // Флаг для отслеживания, была ли найдена тема
        int num = 0;
        for (Theory theory : theoryData.getTheory()) {
            if (theory.getCommand().equalsIgnoreCase(command)) {
                outputService.print("Доступные разделы темы:");
                for (int i = 0; i < theory.getSections().size(); ++i) {
                    insideTopics = false;
                    outputService.print(String.valueOf(theory.getSections().get(i).getNumber()) + theory.getSections().get(i).getTitle());  // Выводим заголовок раздела по индексу
                }
                String topicCommand =  inputService.readLine();
                displayContentByTopic(theory, topicCommand);
                found = true;

            }
            if (command.equals("/back") && !insideTopics){
                botServices.handleCommand("/menu");
                isRunning = false;
                break;
            }
        }
            if (!found)  {
                outputService.print("Нет доступных разделов для этой темы.");
                displayTopics();
            }
    }

    public boolean displayContentByTopic(Theory theory, String number) {
        // Проверка, является ли строка number числом
        int sectionIndex;
        try {
            if (number.equals("/back")){
                displayTopics();
                return false;
            }
            sectionIndex = Integer.parseInt(number) - 1;  // Преобразуем и корректируем индекс (0-based index)
        } catch (NumberFormatException e) {
            outputService.print("Номер раздела должен быть числом.");
            return false;
        }

        // Проверка корректности индекса раздела
        if (sectionIndex < 0 || sectionIndex >= theory.getSections().size()) {
            outputService.print("Нет доступных разделов для этой темы.");
            displayTopics();
            return false;
        }
        insideTopics = true;
        // Отображаем содержимое раздела
        outputService.print(theory.getSections().get(sectionIndex).getContent());
        String lastInput = inputService.readLine();
        if (lastInput.equals("/back")){
            getTheoryByCommand(theory.getCommand());
        }   else {
            displayContent(lastInput);
        }
        return true;
    }
}
