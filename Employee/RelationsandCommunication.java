package Employee;

import java.util.ArrayList;
import java.util.List;

public class RelationsandCommunication {
    private List<String> communicationChannels;
    private List<String> conflictResolutionMethods;
    private List<String> employeeFeedback;

    public RelationsandCommunication() {
        communicationChannels = new ArrayList<>();
        conflictResolutionMethods = new ArrayList<>();
        employeeFeedback = new ArrayList<>();
    }

    // Method to manage communication channels
    public void addCommunicationChannel(String channel) {
        communicationChannels.add(channel);
        System.out.println("Added " + channel + " as a communication channel.");
    }

    // Method to handle conflict resolution methods
    public void addConflictResolutionMethod(String method) {
        conflictResolutionMethods.add(method);
        System.out.println("Added " + method + " as a conflict resolution method.");
    }

    // Method to collect employee feedback
    public void collectEmployeeFeedback(String feedback) {
        employeeFeedback.add(feedback);
        System.out.println("Collected employee feedback: " + feedback);
    }

    // Method to display available communication channels
    public void displayCommunicationChannels() {
        System.out.println("Available communication channels:");
        for (String channel : communicationChannels) {
            System.out.println(channel);
        }
    }

    // Method to display conflict resolution methods
    public void displayConflictResolutionMethods() {
        System.out.println("Available conflict resolution methods:");
        for (String method : conflictResolutionMethods) {
            System.out.println(method);
        }
    }

    // Method to display collected employee feedback
    public void displayEmployeeFeedback() {
        System.out.println("Employee feedback received:");
        for (String feedback : employeeFeedback) {
            System.out.println(feedback);
        }
    }

    // public static void main(String[] args) {
    //     RelationsandCommunication relations = new RelationsandCommunication();

    //     // Adding communication channels
    //     relations.addCommunicationChannel("Email");
    //     relations.addCommunicationChannel("Slack");
    //     relations.addCommunicationChannel("Intranet");

    //     // Adding conflict resolution methods
    //     relations.addConflictResolutionMethod("Mediation");
    //     relations.addConflictResolutionMethod("Negotiation");
    //     relations.addConflictResolutionMethod("Training on Conflict Resolution");

    //     // Collecting employee feedback
    //     relations.collectEmployeeFeedback("Suggestion for team-building activities");
    //     relations.collectEmployeeFeedback("Request for flexible work hours");

    //     // Displaying information
    //     relations.displayCommunicationChannels();
    //     relations.displayConflictResolutionMethods();
    //     relations.displayEmployeeFeedback();
    // }
}

    