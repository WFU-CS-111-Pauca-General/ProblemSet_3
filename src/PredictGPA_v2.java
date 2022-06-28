/**
 * This program predicts a person's semester GPA based on the
 * courses they want to take and grades they expect in each course.
 *
 */

import java.util.Locale;
import java.util.Scanner;

public class PredictGPA_v2 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println();
        System.out.println("Semester GPA Predictor: Let’s see what your GPA could be this semester...");
        System.out.println();

        int numCourses = 0;
        double numerator = 0;
        double totalHours = 0;
        double creditHours;
        String course;
        String grade;
        double gradePoints;
        String choice;
        double gpa;

        while(true) {
            System.out.print("Course " + (numCourses+1) + " : Course title? ");
            course = scnr.nextLine();
            System.out.print("Course " + (numCourses+1) + " : Number of Credit Hours? ");
            creditHours = Double.parseDouble(scnr.nextLine());
            System.out.print("Course " + (numCourses+1) + " : Expected Grade? ");
            grade = scnr.nextLine();
            ++numCourses;

            gradePoints = 0;  // This needs to be changed

            numerator = numerator + (gradePoints * creditHours);
            totalHours = totalHours + creditHours;

            while(true) {
                System.out.print("Continue (y/n)? ");
                choice = scnr.nextLine();
                if(choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("Y")) {
                    System.out.println();
                    break;
                }
            }

            if(choice.equalsIgnoreCase("Y")) {
                ++numCourses;
            }
            else if(choice.equalsIgnoreCase("N")){
                break;
            }
        }

        //Final GPA calculation
        gpa = numerator / totalHours;

        //Printf is used to round to two decimal places
        System.out.print("Your semester GPA would be ");
        System.out.printf("%.4f", gpa);
    }

}
