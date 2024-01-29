import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineVotingSystem {
    private Map<String, Integer> candidates;

    public OnlineVotingSystem() {
        candidates = new HashMap<>();
    }

    public void addCandidate(String name) {
        candidates.put(name, 0);
    }

    public void displayCandidates() {
        System.out.println("Candidates:");
        for (String candidate : candidates.keySet()) {
            System.out.println(candidate);
        }
    }

    public void vote(String candidateName) {
        if (candidates.containsKey(candidateName)) {
            candidates.put(candidateName, candidates.get(candidateName) + 1);
            System.out.println("You've successfully voted for " + candidateName);
        } else {
            System.out.println("Invalid candidate name");
        }
    }

    public void displayResults() {
        System.out.println("Voting Results:");
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public static void main(String[] args) {
        OnlineVotingSystem votingSystem = new OnlineVotingSystem();
        votingSystem.addCandidate("Candidate A");
        votingSystem.addCandidate("Candidate B");
        votingSystem.addCandidate("Candidate C");

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Display Candidates");
            System.out.println("2. Vote");
            System.out.println("3. Display Results");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    votingSystem.displayCandidates();
                    break;
                case 2:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter candidate name to vote: ");
                    String candidateName = scanner.nextLine();
                    votingSystem.vote(candidateName);
                    break;
                case 3:
                    votingSystem.displayResults();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);
        scanner.close();
    }
}
