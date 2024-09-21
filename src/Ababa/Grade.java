package Ababa;

import java.util.ArrayList;
import java.util.Scanner;

public class Grade {
    public void getGradeInput() {

        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Grades> gradeList = new ArrayList<>();
            String option;

            do {
                System.out.println("---------------------------------");
                System.out.println("WELCOME TO GRADING APP");
                System.out.println("---------------------------------");
                System.out.println("1. ADD");
                System.out.println("2. VIEW");
                System.out.println("3. EDIT");
                System.out.println("4. DELETE");
                System.out.println("5. EXIT");
                System.out.println("---------------------------------");

                System.out.println("Enter Action: ");
                int opt = sc.nextInt();

                while (opt > 5 || opt < 1) {
                    System.out.println("Invalid, Try Again: ");
                    opt = sc.nextInt();
                }

                switch (opt) {
                    case 1:
                        System.out.print("Enter number of students: ");
                        int nums = sc.nextInt();
                        sc.nextLine(); // Consume newline

                        for (int i = 0; i < nums; i++) {
                            System.out.println("Enter details of student " + (i + 1) + ":");
                            System.out.print("ID: ");
                            int id = sc.nextInt();
                            sc.nextLine(); // Consume newline
                            System.out.print("Name: ");
                            String name = sc.nextLine();
                            System.out.print("Prelim: ");
                            double pr = sc.nextDouble();
                            System.out.print("Midterm: ");
                            double md = sc.nextDouble();
                            System.out.print("Prefinal: ");
                            double pf = sc.nextDouble();
                            System.out.print("Final: ");
                            double fn = sc.nextDouble();

                            Grades g = new Grades();
                            g.addGrades(name, id, pr, md, pf, fn);
                            gradeList.add(g);
                        }
                        break;
                    case 2:
                        if (gradeList.isEmpty()) {
                            System.out.println("No students added yet!");
                        } else {
                            gradeList.forEach((g) -> {
                                g.viewGrades();
                    });
                        }
                        break;
                    case 3:
                        if (gradeList.isEmpty()) {
                            System.out.println("No students to edit!");
                        } else {
                            System.out.println("Enter Student ID: ");
                            int sid = sc.nextInt();

                            boolean found = false;
                            for (Grades g : gradeList) {
                                if (g.getId() == sid) {
                                    System.out.println("Enter updated details for student " + g.getName());
                                    System.out.print("Prelim: ");
                                    double prl = sc.nextDouble();
                                    System.out.print("Midterm: ");
                                    double mdl = sc.nextDouble();
                                    System.out.print("Prefinal: ");
                                    double pfl = sc.nextDouble();
                                    System.out.print("Final: ");
                                    double fnl = sc.nextDouble();
                                    g.editGrades(sid, prl, mdl, pfl, fnl);
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("Student ID not found!");
                            }
                        }
                        break;
                    case 4:
                        if (gradeList.isEmpty()) {
                            System.out.println("No students to delete!");
                        } else {
                            System.out.println("Enter Student ID to delete: ");
                            int sid = sc.nextInt();

                            boolean found = false;
                            for (int i = 0; i < gradeList.size(); i++) {
                                if (gradeList.get(i).getId() == sid) {
                                    gradeList.remove(i);
                                    System.out.println("Student deleted successfully!");
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("Student ID not found!");
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Exiting Grading App...");
                        return;
                    default:
                        System.out.println("Invalid action. Please try again.");
                }
                System.out.print("Do you want to perform another action? (Y/N): ");
                option = sc.next();
            } while (option.equalsIgnoreCase("Y"));
        }
    }

    public static void main(String[] args) {
        Grade app = new Grade();
        app.getGradeInput();
    }
}