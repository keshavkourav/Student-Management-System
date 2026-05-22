//import java.sql.Connection;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Connection con = DBConnection.getConnection();
//
//        if (con != null) {
//            System.out.println("Database Connected Successfully!");
//        } else {
//            System.out.println("Connection Failed!");
//        }
//    }
//}

//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        StudentDAO dao = new StudentDAO();
//
//        System.out.println("----- Student Management System -----");
//
//        System.out.print("Enter Name: ");
//        String name = sc.nextLine();
//
//        System.out.print("Enter Branch: ");
//        String branch = sc.nextLine();
//
//        System.out.print("Enter Email: ");
//        String email = sc.nextLine();
//
//        System.out.print("Enter CGPA: ");
//        double cgpa = sc.nextDouble();
//
//        Student student = new Student(name, branch, email, cgpa);
//
//        dao.addStudent(student);
//    }
//}

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n----- Student Management System -----");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Branch: ");
                    String branch = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter CGPA: ");
                    double cgpa = sc.nextDouble();

                    Student student = new Student(name, branch, email, cgpa);

                    dao.addStudent(student);
                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:

                    System.out.print("Enter Student ID to Delete: ");
                    int id = sc.nextInt();

                    dao.deleteStudent(id);
                    break;
                case 4:

                    System.out.print("Enter Student ID to Updata: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();

                    System.out.print("Enter New CGPA: ");
                    double newCgpa = sc.nextDouble();

                    dao.updateStudent(updateId, newEmail, newCgpa);
                    break;

                case 5:
                    System.out.println("Exiting Program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}