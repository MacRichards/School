//Student: Michael Richards
//Course: CS 140C
//Date: 2/15/19
//Project: Lab #4
//
//This program will give you a number to guess

import java.util.*;

public class GuessingGame {

    // Guesses for this round
    public static int GUESSES = 0;

    // Public vars for data method
    public static int TOTAL_GAMES = 0;
    public static int TOTAL_GUESSES = 0;
    public static int BEST_GAME = 0;

    // Intros the game
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("=============================");
        System.out.println("Welcome to The Guessing Game!");
        System.out.println("    By: Michael Richards");
        System.out.println("-----------------------------");
        System.out.println("  Need help? Type help.");
        System.out.println("=============================");
        System.out.println();
        System.out.print("Would you like to play? ");
        String answer = console.next();
        play(answer);
    }

    // Starts the game.
    public static void play(String answer) {
        if (answer.substring(0,1).toLowerCase().equals("n")) {
            System.out.println("Sorry to see you go. :(");
            System.out.print("Come back SOON!");
        } else if (answer.substring(0,1).toLowerCase().equals("y")) {
            // Runs game
            Random rn = new Random();
            int rnum = rn.nextInt(100) + 1;
            System.out.println(rnum);
            System.out.println("I'm thinking of a number between 1 and 100...");
            guess(rnum);
        } else if (answer.toLowerCase().equals("help")) {
            help();
        } else {
            really();
        }
    }

    // Displays instructions on how to play.
    public static void help() {
        System.out.println();
        System.out.println("This is how it works. I'll come up with a number between 1 and 100 and it is your job");
        System.out.println("to guess it. I'll let you know if your too high or too low. That's it.");
        System.out.println("Ready to go?");
        Scanner console = new Scanner(System.in);
        String answer = console.next();
        play(answer);
    }

    // Message to be displayed when the proper answer wasn't given.
    public static void really() {
        System.out.println();
        System.out.println("Really...? Why do you have to be difficult. Make this easy on the both of us and just say");
        System.out.println("yes... or no... that wouldn't be nice tho. ;)");
        Scanner console = new Scanner(System.in);
        String answer = console.next();
        play(answer);
    }

    // Holds the main logic for the game.
    public static void guess(int rnum) {
        GUESSES++;
        System.out.print("Your guess? ");
        Scanner console = new Scanner(System.in);
        int guess = console.nextInt();
        while (guess != rnum) {
            System.out.println();
            if (guess < rnum) {
                GUESSES++;
                System.out.println("Too low");
                System.out.print("Your guess? ");
                guess = console.nextInt();
            } else if (guess > rnum) {
                GUESSES++;
                System.out.println("Too high");
                System.out.print("Your guess? ");
                guess = console.nextInt();
            } else {
                System.out.println("Error");
                break;
            }
        }
        data(GUESSES);
    }

    // Figures out all stats for the game.
    public static void data(int guesses) {
        GUESSES = 0;

        if (TOTAL_GAMES == 0) {
            TOTAL_GAMES = 1;
            TOTAL_GUESSES = guesses;
            BEST_GAME = guesses;
        } else {
            TOTAL_GAMES++;
            TOTAL_GUESSES = TOTAL_GUESSES + guesses;
        }
        if (guesses < BEST_GAME) {
            BEST_GAME = guesses;
        }

        double totalGames = TOTAL_GAMES;
        double totalGuesses = TOTAL_GUESSES;
        double guessOverGames = totalGames / totalGuesses;

        System.out.println();
        System.out.println("========================");
        System.out.println("Total games: " + TOTAL_GAMES);
        System.out.println("Total guesses: " + TOTAL_GUESSES);
        System.out.println("Guesses/Games: " + guessOverGames);
        System.out.println("Best Game " + BEST_GAME);
        System.out.println("========================");
        System.out.println();

        ask();
    }

    // Asks if you would like to continue.
    public static void ask() {
        System.out.println("Would you like to play again?");
        Scanner console = new Scanner(System.in);
        String answer = console.next();
        play(answer);
    }
}
