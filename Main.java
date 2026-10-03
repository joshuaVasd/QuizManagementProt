import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    static ArrayList<String> usernames = new ArrayList<>();
    static ArrayList<String> passwords = new ArrayList<>();
    static ArrayList<String> roles = new ArrayList<>();

    public static void main(String[] args) {

        usernames.add("admin");
        passwords.add("admin123");
        roles.add("Admin");

        usernames.add("teacher");
        passwords.add("teacher123");
        roles.add("Instructor");

        usernames.add("student");
        passwords.add("student123");
        roles.add("Student");

        login();
    }

    static void login() {

        while (true) {
            System.out.println("\n==============================");
            System.out.println("     QUIZ MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("[1] Login");
            System.out.println("[2] Exit");
            System.out.print("Choose: ");

            int choice;

            try {
                choice = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            if (choice == 2) {
                System.out.println("Goodbye!");
                break;
            }

            if (choice != 1) {
                System.out.println("Invalid choice.");
                continue;
            }

            System.out.print("\nUsername: ");
            String username = scan.nextLine();

            System.out.print("Password: ");
            String password = scan.nextLine();

            int userIndex = authenticate(username, password);

            if (userIndex != -1) {

                String role = roles.get(userIndex);

                System.out.println("\nLogin successful!");
                System.out.println("Welcome, " + username + "!");
                System.out.println("Role: " + role);

                if (role.equals("Admin")) {
                    adminMenu();
                }
                else if (role.equals("Instructor")) {
                    instructorMenu();
                }
                else if (role.equals("Student")) {
                    studentMenu();
                }

            } else {
                System.out.println("\nIncorrect username or password.");
            }
        }
    }

    static int authenticate(String username, String password) {

        for (int i = 0; i < usernames.size(); i++) {

            if (usernames.get(i).equals(username)
                    && passwords.get(i).equals(password)) {

                return i;
            }
        }

        return -1;
    }

    static void adminMenu() {

        while (true) {

            System.out.println("\n===== ADMIN DASHBOARD =====");
            System.out.println("[1] Manage Users");
            System.out.println("[2] View System");
            System.out.println("[3] Logout");
            System.out.print("Choose: ");

            int choice;

            try {
                choice = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            if (choice == 1) {
                System.out.println("User management goes here.");
            }
            else if (choice == 2) {
                System.out.println("System information goes here.");
            }
            else if (choice == 3) {
                System.out.println("Logging out...");
                break;
            }
            else {
                System.out.println("Invalid choice.");
            }
        }
    }

    static void instructorMenu() {

        while (true) {

            System.out.println("\n===== INSTRUCTOR DASHBOARD =====");
            System.out.println("[1] Create Quiz");
            System.out.println("[2] Manage Quizzes");
            System.out.println("[3] View Student Scores");
            System.out.println("[4] Logout");
            System.out.print("Choose: ");

            int choice;

            try {
                choice = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            if (choice == 1) {
                System.out.println("Create quiz goes here.");
            }
            else if (choice == 2) {
                System.out.println("Manage quizzes goes here.");
            }
            else if (choice == 3) {
                System.out.println("Student scores go here.");
            }
            else if (choice == 4) {
                System.out.println("Logging out...");
                break;
            }
            else {
                System.out.println("Invalid choice.");
            }
        }
    }

    static void studentMenu() {

        while (true) {

            System.out.println("\n===== STUDENT DASHBOARD =====");
            System.out.println("[1] Take Quiz");
            System.out.println("[2] View Scores");
            System.out.println("[3] View Rankings");
            System.out.println("[4] Logout");
            System.out.print("Choose: ");

            int choice;

            try {
                choice = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            if (choice == 1) {
                System.out.println("Take quiz goes here.");
            }
            else if (choice == 2) {
                System.out.println("Student scores go here.");
            }
            else if (choice == 3) {
                System.out.println("Rankings go here.");
            }
            else if (choice == 4) {
                System.out.println("Logging out...");
                break;
            }
            else {
                System.out.println("Invalid choice.");
            }
        }
    }
}