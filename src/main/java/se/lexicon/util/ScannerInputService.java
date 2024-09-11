package se.lexicon.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService {

    private final Scanner scanner;

    @Autowired
    public ScannerInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getString() {
        System.out.println("Enter a string: ");
        return scanner.nextLine();
    }

    @Override
    public int getInt() {
        System.out.println("Enter an integer: ");
        return scanner.nextInt();
    }
}
