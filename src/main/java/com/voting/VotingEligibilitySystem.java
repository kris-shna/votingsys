package com.voting;

import java.util.Scanner;

class Voter {

    private String name;
    private int age;
    private String citizenship;
    private String voterId;
    private boolean idValid;

    public Voter(String name, int age, String citizenship,
                 String voterId, boolean idValid) {

        this.name = name;
        this.age = age;
        this.citizenship = citizenship;
        this.voterId = voterId;
        this.idValid = idValid;
    }

    public void checkEligibility() {

        System.out.println("\nVoter Name: " + name);
        System.out.println("Voter ID: " + voterId);

        boolean eligible = true;

        if (age < 18) {
            System.out.println("Reason: Underage (must be 18 or above)");
            eligible = false;
        }

        if (!citizenship.equalsIgnoreCase("Indian")) {
            System.out.println("Reason: Not an Indian citizen");
            eligible = false;
        }

        if (!idValid) {
            System.out.println("Reason: Invalid Voter ID");
            eligible = false;
        }

        if (eligible) {
            System.out.println("Result: ELIGIBLE TO VOTE");
        } else {
            System.out.println("Result: NOT ELIGIBLE TO VOTE");
        }
    }
}


public class VotingEligibilitySystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of voters: ");
        int numberOfVoters = scanner.nextInt();
        scanner.nextLine();

        Voter[] voters = new Voter[numberOfVoters];

        for (int i = 0; i < numberOfVoters; i++) {

            System.out.println("\nEnter details for Voter " + (i + 1));

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Citizenship: ");
            String citizenship = scanner.nextLine();

            System.out.print("Enter Voter ID: ");
            String voterId = scanner.nextLine();

            System.out.print("Is Voter ID Valid? (true/false): ");
            boolean idValid = scanner.nextBoolean();
            scanner.nextLine();

            voters[i] = new Voter(
                    name, age, citizenship, voterId, idValid
            );
        }

        System.out.println("\n===== VOTING ELIGIBILITY RESULTS =====");

        for (Voter voter : voters) {
            voter.checkEligibility();
        }

        scanner.close();
    }
}