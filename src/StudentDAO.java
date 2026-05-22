import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {

    public void addStudent(Student student) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO students(name, branch, email, cgpa) VALUES (?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, student.getName());
            pst.setString(2, student.getBranch());
            pst.setString(3, student.getEmail());
            pst.setDouble(4, student.getCgpa());

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Added Successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public void viewStudents() {

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM students";

            PreparedStatement pst = con.prepareStatement(query);

            var rs = pst.executeQuery();

            System.out.println("\n----- Student Records -----");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("student_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Branch: " + rs.getString("branch"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("CGPA: " + rs.getDouble("cgpa"));
                System.out.println("----------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteStudent(int id) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM students WHERE student_id = ?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted Successfully!");
            } else {
                System.out.println("Student ID Not Found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateStudent(int id, String email, double cgpa) {

        try {
            Connection con = DBConnection.getConnection();

            String query = "UPDATE students SET email = ?, cgpa = ? WHERE student_id = ?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, email);
            pst.setDouble(2, cgpa);
            pst.setInt(3, id);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated Successfully!");
            } else {
                System.out.println("Student ID Not Found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}