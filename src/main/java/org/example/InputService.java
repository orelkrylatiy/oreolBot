package org.example;

import java.util.Scanner;

public class InputService {
    Scanner input = new Scanner(System.in);  // Объявление в поле

    public String readLine() {
        return input.nextLine();  // Возвращает строку, которую ввел пользователь
    }

}
