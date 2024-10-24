package mybot;
import java.util.HashMap;
import java.util.Map;

public class TestService {
    // Вопросы по темам
    private Map<String, String[]> questionsByTopic = new HashMap<>();
    private Map<String, String[]> answersByTopic = new HashMap<>();
    private String[] currentQuestions;  // Текущий набор вопросов
    private String[] currentAnswers;    // Текущий набор ответов
    private int currentQuestion = 0;    // Индекс текущего вопроса
    private int correctAnswers = 0;     // Счётчик правильных ответов

    // Конструктор, инициализирующий вопросы по темам
    public TestService() {
        // Вопросы и ответы по теме "Введение в JavaScript"
        questionsByTopic.put("introduction_to_javascript", new String[]{
                "Что такое JavaScript?",
                "Где применяется JavaScript?"
        });
        answersByTopic.put("introduction_to_javascript", new String[]{
                "язык программирования",
                "веб-разработка"
        });

        // Вопросы и ответы по теме "Переменные и типы данных"
        questionsByTopic.put("variables_and_data_types", new String[]{
                "Как объявляется переменная в JavaScript?",
                "Какие типы данных существуют в JavaScript?"
        });
        answersByTopic.put("variables_and_data_types", new String[]{
                "var, let, const",
                "строка, число, объект"
        });

        // Можно добавить больше тем по аналогии...
    }

    // Метод для установки текущего набора вопросов по выбранной теме
    public boolean startTestByTopic(String topic) {
        if (questionsByTopic.containsKey(topic)) {
            currentQuestions = questionsByTopic.get(topic);
            currentAnswers = answersByTopic.get(topic);
            currentQuestion = 0;  // Сбрасываем индекс текущего вопроса
            correctAnswers = 0;   // Сбрасываем счётчик правильных ответов
            return true;
        } else {
            return false;  // Если тема не найдена
        }
    }

    // Метод для получения следующего вопроса
    public String getNextQuestion() {
        if (currentQuestion < currentQuestions.length) {
            return currentQuestions[currentQuestion];
        } else {
            return "Тест завершён! Вы правильно ответили на " + correctAnswers + " из " + currentQuestions.length + " вопросов.";
        }
    }

    // Метод для проверки ответа
    public boolean checkAnswer(String userAnswer) {
        if (userAnswer.equalsIgnoreCase(currentAnswers[currentQuestion])) {
            correctAnswers++;  // Если ответ правильный, увеличиваем счётчик правильных ответов
            return true;
        } else {
            return false;
        }
    }

    // Переход к следующему вопросу
    public void nextQuestion() {
        currentQuestion++;
    }

    // Проверка, есть ли ещё вопросы
    public boolean hasMoreQuestions() {
        return currentQuestion < currentQuestions.length;
    }

    public void resetTest(){
        currentQuestion = 0;
        correctAnswers = 0;
    }
}
