package wozardstudios;

import java.util.Date;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Client {
    Client() {
        AceOfTheSkies.password = "";

        try {
            AceOfTheSkies.reader = new BufferedReader(new FileReader("src/wozardstudios/HighScores.txt"));
            AceOfTheSkies.writer = new BufferedWriter(new FileWriter("src/wozardstudios/HighScores.txt", true));

            AceOfTheSkies.highScore = AceOfTheSkies.reader.readLine();
            AceOfTheSkies.reader.close();

            if (AceOfTheSkies.highScore == null) {
                AceOfTheSkies.writer.write("0");
                AceOfTheSkies.writer.close();

                AceOfTheSkies.reader = new BufferedReader(new FileReader("src/wozardstudios/HighScores.txt"));
                AceOfTheSkies.highScore = AceOfTheSkies.reader.readLine();
                AceOfTheSkies.reader.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    void start(int attempts) {
        System.out.println(
                "*******************************************************************************************************\n" +
                "\u001B[1;4;97m" + "\u001B[44m" + "ACE OF THE SKIES" + "\u001B[0m" + "\n" +
                "\u001B[1;4;97m" + "\u001B[46m" + "By Jeremy Liu" + "\u001B[0m" + "\n" +
                "*******************************************************************************************************\n\n" +
                "\u001B[32m" + "Type the password to launch the game." + "\u001B[0m" + "\n" +
                "\u001B[33m" + "Type " + "\u001B[0m" + "\u001B[4;33m" + "Help" + "\u001B[0m" + "\u001B[33m" + " to access a beginner's game guide." + "\u001B[0m" + "\n" +
                "\u001B[31m" + "Type " + "\u001B[0m" + "\u001B[4;31m" + "Exit" + "\u001B[0m" + "\u001B[31m" + " to close the program." + "\u001B[0m" + "\n"
        );

        System.out.print("\u001B[35m" + "Please enter your choice: " + "\u001B[0m");

        while (attempts > 0) {
            AceOfTheSkies.scanner = new Scanner(System.in);

            AceOfTheSkies.password = AceOfTheSkies.scanner.next();

            if (AceOfTheSkies.password.equals("OSA")) {
                System.out.println("\u001B[1;32m" + "Access granted! Launching..." + "\u001B[0m");

                AceOfTheSkies.launchTime = (int) new Date().getTime();

                AceOfTheSkies.scanner.close();

                break;
            } else if (AceOfTheSkies.password.toLowerCase().equals("help")) {
                System.out.println(
                        "\n" + "\u001B[4;33m" + "Flappy Crane Help" + "\u001B[0m" + "\n" +
                        "\u001B[34m" + "* This game is an alteration of the popular legend called Flappy Bird. The objective is to get the crane past as many\nobstacles as you can without hitting one of them. Try to shoot for the highscore!" + "\n" +
                        "* You can play by yourself, or in multiplayer splitscreen mode with up to 4 players." + "\u001B[0m" + "\n"
                );

                System.out.print("\u001B[35m" + "Please enter your choice: " + "\u001B[0m");
            } else if (AceOfTheSkies.password.toLowerCase().equals("exit")) {
                System.out.println("\u001B[1;31m" + "Exiting..." + "\u001B[0m");

                attempts = 0;
            } else {
                attempts--;

                if (attempts == 2) {
                    System.out.print("\u001B[1;31m" + "Incorrect password! " + "\u001B[0m" + "\u001B[31m" + "You have " + "\u001B[0m" + "\u001B[1;31m" + attempts + "\u001B[0m" + "\u001B[31m" + " attempts left. Please try again: " + "\u001B[0m");
                } else if (attempts == 1) {
                    System.out.print("\u001B[1;31m" + "Incorrect password! " + "\u001B[0m" + "\u001B[31m" + "You have " + "\u001B[0m" + "\u001B[1;31m" + attempts + "\u001B[0m" + "\u001B[31m" + " attempt left. Please try again: " + "\u001B[0m");
                } else if (attempts == 0) {
                    System.out.println("\u001B[1;31m" + "Incorrect password! Access denied." + "\u001B[0m");
                }
            }
        }

        if (attempts == 0) {
            System.exit(0);
        }
    }

    void launch(int startTime, int endTime) {
        System.out.println("\u001B[32m" + "Game launched in " + (endTime - startTime) + " ms." + "\u001B[0m");
    }

    void exit() {
        System.out.println(
                "\n" + "\u001B[1;33m" + "Thanks for playing!" + "\u001B[0m" + "\n\n" +
                "\u001B[4;33m" + "Credits" + "\u001B[0m" + "\n" +
                "\u001B[36m" + "Developer: Jeremy Liu" + "\u001B[0m" + "\n" +
                "\u001B[34m" + "Inspired by: Flappy Bird" + "\u001B[0m" + "\n" +
                "\u001B[35m" + "Powered by: IntelliJ IDEA CE, Processing 3, Minim" + "\u001B[0m" + "\n" +
                "\u001B[36m" + "Music: C418 - Sweden (Caution & Crisis Remix)" + "\u001B[0m"
        );
    }
}
