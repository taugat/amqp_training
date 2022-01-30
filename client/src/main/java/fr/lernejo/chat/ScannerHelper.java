package fr.lernejo.chat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class ScannerHelper
{

    public Scanner scanner = new Scanner(System.in);

    private final RabbitTemplate template;

    public ScannerHelper(RabbitTemplate template) {
        this.template = template;
    }

    public void start()
    {
        boolean exit;
        do
        {
            System.out.print("Input a message, we will print it for you (q for quit)\n");
            exit = printResponse(scanner.nextLine());

        }
        while (!exit);
    }

    public boolean printResponse(String message)
    {
        boolean exit = "q".equals(message);
        if (!exit)
        {
            template.convertAndSend("","chat_messages",message);
            System.out.print("Message sent. ");
        }
        else
        {
            System.out.println("Bye");
        }
        return exit;
    }
}
