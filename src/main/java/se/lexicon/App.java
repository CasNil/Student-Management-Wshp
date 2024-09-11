package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ScannerBeanConfig;
import se.lexicon.util.UserInputService;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ScannerBeanConfig.class);

        UserInputService userInputService = context.getBean(UserInputService.class);

        String input = userInputService.getString();
        System.out.println("Your entered: " + input);

        int number = userInputService.getInt();
        System.out.println("You entered the number: " + number);

        context.close();
    }
}
