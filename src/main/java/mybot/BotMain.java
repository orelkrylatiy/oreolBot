package mybot;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class BotMain
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in); // начинаем процесс чтения с клавиатуры
        String userInput = input.nextLine();
        System.out.println( "Hello World!" );
    }
}
