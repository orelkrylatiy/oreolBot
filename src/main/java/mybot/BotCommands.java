package mybot;

public class BotCommands {
    private TestService testService = new TestService();

    public String handleCommand(String command) {

        HelpService helpService = new HelpService();
        String helpMessage = helpService.getHelpMessage();
        switch (command.toLowerCase()) {

            //------ Main functions
            case "/help":
                return helpMessage;

            /*case "/start":
                return "Все супер! Добро пожаловать в программу для изучения JavaScript.\n Я бот для изучения JavaScript. Я помогу тебе освоить JavaScript с нуля через теорию, тесты и практические задания.\n" +
                        "Чтобы начать, выбери один из следующих разделов:\n" +
                        "1 " + "/start_learn_theory - начать изучение теории\n" +
                        "2 " + "/start_tests - пройти тесты по изученным темам\n" +
                        "3 " + "/training_mode - войти в тренировочный режим\n" +
                        "4 " + "/view_progress - посмотреть свой текущий прогресс\n" +
                        "5 " + "/daily_task - получить ежедневное задание\n" +
                       "6 " +  "/ask_question - задать вопрос по JavaScript\n " +
                        "7 " + "/achievements - Посмотреть свои достижения.\n" ;*/

            case "/start_learn_theory":
                TheoryService theoryService = new TheoryService();
                return theoryService.getTheory();  // Возвращаем теоретический материал

            case "/start_tests":

                testService.resetTest();  // Сбрасываем тест, если он уже проводился ранее
                return testService.getNextQuestion();  // Показываем первый вопрос теста

            case "/training_mode":
                TrainingService trainingService = new TrainingService();
                return trainingService.startTraining();  // Тренировочный режим

            case "/view_progress":
                ProgressService progressService = new ProgressService();
                return progressService.getProgress();  // Показ прогресса

            case "/achievements":
                AchievementsService achievementsService = new AchievementsService();
                return achievementsService.getAchievements();  // Достижения

            case "/daily_task":
                DailyTaskService dailyTaskService = new DailyTaskService();
                return dailyTaskService.getDailyTask();  // Ежедневное задание

            case "/ask_question":
                QuestionService questionService = new QuestionService();
                return questionService.askQuestion();  // Ответ на вопрос пользователя

            case "/about":
                return "Я простой консольный бот, который помогает вам!\n" + helpMessage;

            case "/exit":
                return "Выход из программы...";
            //------- The END of Main functions

            // Команды для теоретических разделов:
            case "/introduction_to_javascript":
                return "Введение в JavaScript: JavaScript — это язык программирования, который используется для создания интерактивных веб-страниц...";

            case "/variables_and_data_types":
                return "Переменные и типы данных: В JavaScript есть несколько типов данных, таких как строки, числа и объекты. Переменные объявляются с помощью ключевых слов var, let или const.";

            case "/functions_in_javascript":
                return "Функции в JavaScript: Функция — это блок кода, который можно вызывать многократно. Функции объявляются с помощью ключевого слова function.";

            case "/control_flow":
                return "Управляющие конструкции: Условные операторы и циклы используются для управления потоком выполнения программы. Основные циклы — это for и while.";

            case "/arrays_and_objects":
                return "Массивы и объекты: Массивы используются для хранения упорядоченных коллекций данных, а объекты — для хранения неупорядоченных пар ключ-значение.";

            case "/dom_manipulation":
                return "Манипуляции с DOM: DOM — это интерфейс для взаимодействия с элементами HTML. JavaScript позволяет изменять структуру, стиль и содержание страницы через DOM.";

            case "/events_in_javascript":
                return "События в JavaScript: События позволяют JavaScript реагировать на действия пользователя, такие как клики мыши или нажатия клавиш.";

            case "/asynchronous_javascript":
                return "Асинхронный JavaScript: Асинхронное программирование позволяет JavaScript выполнять несколько задач одновременно. Основные элементы — это промисы и async/await.";

            case "/error_handling":
                return "Обработка ошибок: JavaScript предоставляет конструкции try, catch и finally для обработки ошибок, возникающих во время выполнения программы.";

            case "/debugging_in_javascript":
                return "Отладка кода: Для отладки JavaScript можно использовать консоль разработчика в браузере и встроенные средства отладки.";

            default:
                return "Неизвестная команда. Введите /help для списка команд.";
        }
    }

}
