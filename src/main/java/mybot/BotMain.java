package mybot;
import java.util.Scanner;


public class BotMain
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Добро пожаловать в учебного бота! Введите команду:");

        BotCommands processCommand = new BotCommands();

        while (true){

            String userInput = input.nextLine();
            String response = processCommand.handleCommand(userInput);
            System.out.println(response);
            if (userInput.equalsIgnoreCase("/exit")) {
                break;  // Завершение программы при команде /exit
            }

        }

        input.close();
    }

}