package org.launchcode.techjobs.console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by LaunchCode
 */
public class TechJobs {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        // Initialize our field map with key/name pairs
        HashMap<String, String> columnChoices = new HashMap<>();
        columnChoices.put("core competency", "Skill");
        columnChoices.put("employer", "Employer");
        columnChoices.put("location", "Location");
        columnChoices.put("position type", "Position Type");
        columnChoices.put("all", "All");

        // Top-level menu options
        HashMap<String, String> actionChoices = new HashMap<>();
        actionChoices.put("search", "Search");
        actionChoices.put("list", "List");

        System.out.println("Welcome to LaunchCode's TechJobs App!");

        // Allow the user to search until they manually quit
        while (true) {

            String actionChoice = getUserSelection("View jobs by:", actionChoices);

            if (actionChoice.equals("list")) {

                String columnChoice = getUserSelection("List", columnChoices);

                if (columnChoice.equals("all")) {
                    printJobs(JobData.findAll());
                } else {

                    ArrayList<String> results = JobData.findAll(columnChoice);

                    System.out.println("\n*** All " + columnChoices.get(columnChoice) + " Values ***");

                    // Print list of skills, employers, etc
                    for (String item : results) {
                        System.out.println(item);
                    }
                }

            } else { // choice is "search"

                // How does the user want to search (e.g. by skill or employer)
                String searchField = getUserSelection("Search by:", columnChoices);

                // What is their search term?
                System.out.println("\nSearch term: ");
                String searchTerm = in.nextLine();

                if (searchField.equals("all")) {
                    printJobs(JobData.findByValue(searchTerm)); //put searchTerm in this parameter
                } else {
                    printJobs(JobData.findByColumnAndValue(searchField, searchTerm));
                }
            }
        }
    }

    // ﻿Returns the key of the selected item from the choices Dictionary
    private static String getUserSelection(String menuHeader, HashMap<String, String> choices) {

        Integer choiceIdx;
        Boolean validChoice = false;
        String[] choiceKeys = new String[choices.size()];

        // Put the choices in an ordered structure so we can
        // associate an integer with each one
        Integer i = 0;
        for (String choiceKey : choices.keySet()) {
            choiceKeys[i] = choiceKey;
            i++;
        }

        do {

            System.out.println("\n" + menuHeader);

            // Print available choices
            for (Integer j = 0; j < choiceKeys.length; j++) {
                System.out.println("" + j + " - " + choices.get(choiceKeys[j]));
            }

            choiceIdx = in.nextInt();
            in.nextLine();

            // Validate user's input
            if (choiceIdx < 0 || choiceIdx >= choiceKeys.length) {
                System.out.println("Invalid choice. Try again.");
            } else {
                validChoice = true;
            }

        } while (!validChoice);

        return choiceKeys[choiceIdx];
    }

    // Print a list of jobs
    private static void printJobs(ArrayList<HashMap<String, String>> someJobs) {
        //iterate over an ArrayList of jobs
        //while each job is a HashMap
        //create a nested loop to loop over each HashMap

//        String name = ;
////        for (int job = 0; job < someJobs.size(); job++) {
////            for (int b = a + 1; b < someJobs.size(); b++) {
////                for (String key : someJobs.get(job).values()) {
//        System.out.println(someJobs.get(name));

        if (someJobs.isEmpty()) {
            System.out.println("Search did not produce any results");
        } else {
            for (HashMap<String, String> entry : someJobs) {
                System.out.println("*******");
                {

                    for (String key : entry.keySet()) {
                        System.out.println(key + ": " + entry.get(key));
                    }
                }
            }

        }
    }
}
//        for (int i = 0; i < someJobs.size(); i++) {
//            for (String key : someJobs.get(i).keySet()) {
//                for (String value : someJobs.get(i).values()) {
//                    System.out.println(key + value);
//
//                    }
//                }
//            }
//        }
//

//        for (HashMap<String, String>map: someJobs){
//            for (String values: someJobs.get())
//            String job = map.get(someJobs);
//            System.out.println(values);


//        ArrayList[] someJobKeys = new ArrayList[someJobs.size()}];
//        Integer i = 0;
//        for (String someJobKey: someJobs.keySet()) {
//            someJobKeys[i] = someJobKey;
//            i++;
//        for (Map.Entry<String, String> someJob : someJobs.entrySet()) {
//            System.out.println(someJob.getKey() + someJob.getValue());
//                }
