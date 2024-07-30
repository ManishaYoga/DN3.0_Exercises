public class MVCPatternTest {
    public static void main(String[] args) {
        // Create a student model
        Student student = new Student("1", "John Doe", "A");

        // Create a view to display student details
        StudentView view = new StudentView();

        // Create a controller
        StudentController controller = new StudentController(student, view);

        // Display initial student details
        controller.updateView();

        // Update student details
        controller.setStudentName("Jane Smith");
        controller.setStudentGrade("B");

        // Display updated student details
        controller.updateView();
    }
}
