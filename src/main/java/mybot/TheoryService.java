package mybot;

public class TheoryService {

    String theorySections =
            "Выберите тему: \n" +
            "/introduction_to_javascript - Введение в JavaScript: Что такое JavaScript и зачем он нужен?\n" +
            "/variables_and_data_types - Переменные и типы данных: Как работать с переменными и типами данных в JavaScript?\n" +
            "/functions_in_javascript - Функции в JavaScript: Как создавать функции и зачем они нужны?\n" +
            "/control_flow - Управляющие конструкции: Условные операторы и циклы.\n" +
            "/arrays_and_objects - Массивы и объекты: Как работать с коллекциями данных.\n" +
            "/dom_manipulation - Манипуляции с DOM: Как взаимодействовать с элементами HTML с помощью JavaScript.\n" +
            "/events_in_javascript - События в JavaScript: Как обрабатывать пользовательские действия.\n" +
            "/asynchronous_javascript - Асинхронный JavaScript: Работа с промисами и async/await.\n" +
            "/error_handling - Обработка ошибок: Как правильно обрабатывать ошибки в JavaScript.\n" +
            "/debugging_in_javascript - Отладка кода: Как находить и исправлять ошибки в JavaScript.\n";

    public String getTheory(){
        return this.theorySections;
    }
}
