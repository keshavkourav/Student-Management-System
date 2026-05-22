public class Student {

    private int studentId;
    private String name;
    private String branch;
    private String email;
    private double cgpa;

    // Constructor
    public Student(String name, String branch, String email, double cgpa) {
        this.name = name;
        this.branch = branch;
        this.email = email;
        this.cgpa = cgpa;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public String getEmail() {
        return email;
    }

    public double getCgpa() {
        return cgpa;
    }
}