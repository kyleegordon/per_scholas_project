package jpa.mainrunner;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SMSRunner {

    private Scanner scan;
    private CourseService courseService;
    private StudentService studentService;
    private Student currentStudent;

    //initializes necessary objects
    public SMSRunner() {
        scan = new Scanner(System.in);
        courseService = new CourseService();
        studentService = new StudentService();
    }


    //starts the program
    public static void main(String[] args) {

        SMSRunner sms = new SMSRunner();
        sms.run();
    }

    //processes value returned from loginMenu() to either proceed with the login process or quit the program
    private void run() {
        // Login or quit
        switch (loginMenu()) {
            case 1:
                //processes value returned from studentLogin(), will proceed to registration menu if login successful
                if (studentLogin()) {
                    registerMenu();
                }
                break;
            case 2:
                System.out.println("Goodbye!");
                break;

            default:
                System.out.println("Must select 1 or 2");
                run();

        }
    }

    //returns menu selection, 1 to login or 2 to quit
    private int loginMenu() {
        System.out.println("\n1.Student Login\n2. Quit Application\nPlease Enter Selection: ");
        try {
            return scan.nextInt();
        } catch (InputMismatchException exception)
        {
            System.out.println("Selection must be an integer");
            scan.nextLine();
        }
        return 0;
    }

    //returns true if login successful
    private boolean studentLogin() {
        boolean retValue = false;
        System.out.println("Enter your email address: ");
        String email = scan.next();
        System.out.println("Enter your password: ");
        String password = scan.next();

        currentStudent = studentService.getStudentByEmail(email);
        //checks whether email and password are correct, prints out current classes if true
        if (currentStudent != null & studentService.validateStudent(email, password)) {
            List<Course> courses = studentService.getStudentCourses(email);
            System.out.println("MyClasses");
            for (Course course : courses) {
                System.out.println(course);
            }
            retValue = true;
        } else {
            System.out.println("Wrong Credentials. GoodBye!");
        }
        return retValue;
    }

    //display courses available and allows student to register for course
    private void registerMenu() {
        System.out.println("\n1.Register a class\n2. Logout\nPlease Enter Selection: ");
        int selection = 0;
        try {
            selection = scan.nextInt();
        } catch (InputMismatchException exception)
        {
            System.out.println("Selection must be an integer");
            scan.nextLine();
        }

        switch (selection) {
            case 1:
                List<Course> allCourses = courseService.getAllCourses();
                List<Course> studentCourses = studentService.getStudentCourses(currentStudent.getsEmail());
                allCourses.removeAll(studentCourses);
                System.out.printf("%2s%7s%12s\n", "ID", "Course", "Instructor");
                for (Course course : allCourses) {
                    System.out.println(course);
                }
                System.out.println();
                System.out.print("Enter Course Number: ");
                int number = scan.nextInt();

                    studentService.registerStudentToCourse(currentStudent.getsEmail(), number);

                    List<Course> sCourses = studentService.getStudentCourses(currentStudent.getsEmail());


                    System.out.println("MyClasses");
                    for (Course course : sCourses) {
                        System.out.println(course);
                    }
                System.out.println("Class registration successful, you have now been signed out");
                break;
            case 2:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Must select 1 or 2");
                registerMenu();

        }
    }
}