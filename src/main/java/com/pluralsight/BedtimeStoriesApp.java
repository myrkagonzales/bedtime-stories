package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BedtimeStoriesApp {

    public static void main(String[] args) {

        // create a scanner to capture user input from the console
        Scanner scanner = new Scanner(System.in);

        // array of actual file names existing
        String[] goodNightFile = {
                "goldilocks",
                "hansel and gretel",
                "mary had a little lamb",
        };

        // prompt the user for the name of the story file they want to read
        System.out.println("Enter the name of a story (e.g., Goldilocks ): ");
        String fileName = scanner.nextLine();

        // always close the scanner to prevent memory leaks
        scanner.close();

        // variable to hold the match filename
        String fileNameToOpen = null;
        // make it to where input is not case sensitive
        for (String file : goodNightFile) {
            if (file.equalsIgnoreCase(fileName)) {
                fileNameToOpen = file;
                break;
            }
        }
        // if no match, notify user and exit
        if (fileNameToOpen == null) {
            System.out.println("ERROR: Could not find a story matching" + " " + fileName + "." + " " + "Please check your spelling!");
            return;

        }

        // try-catch block because file operations can throw errors
        try {
            // create a FileReader connected to the file the user requested
            FileReader fileReader = new FileReader(fileName);

            // wrap the FileReader connected to the file the user requested
            BufferedReader bufReader = new BufferedReader(fileReader);
            // variable to store each line as we read it
            String input;
            // track the line numbers so we can print them out next to the text
            int lineNumber = 1;
            System.out.println("\n--- Reading File Content ---\n");

            // read line by line until readLine() returns null (END OF FILE)
            while ((input = bufReader.readLine()) != null) {
                /// print the line number
                System.out.println(lineNumber + ". " + input);
                lineNumber++;
            }
            // close stream when finished to release system resources
            bufReader.close();
        } catch (IOException e) {
            // this code runs if something goes wrong
            System.out.println("ERROR: An unexpected error occured while reading the file. ");
            e.printStackTrace(); // prints out the error for developer to debug





        }


    }
}
