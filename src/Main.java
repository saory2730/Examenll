import controlador.CourseController;
import controlador.EnrollmentController;
import controlador.GradeController;
import controlador.StudentController;
import controlador.TeacherController;
import db.connection;
import modelo.Course;
import modelo.Enrollment;
import modelo.Grade;
import modelo.Student;
import modelo.Teacher;
import vista.ViewCourse;
import vista.ViewEnrollment;
import vista.ViewGrade;
import vista.ViewStudent;
import vista.ViewTeacher;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido a nuestro sistema académico!");


        ViewStudent viewStudent = new ViewStudent();
        ViewTeacher viewTeacher = new ViewTeacher();
        ViewCourse viewCourse = new ViewCourse();
        ViewEnrollment viewEnrollment = new ViewEnrollment();
        ViewGrade viewGrade = new ViewGrade();
        StudentController studentController = new StudentController(viewStudent);
        TeacherController teacherController = new TeacherController(viewTeacher);
        CourseController courseController = new CourseController(viewCourse);
        EnrollmentController enrollmentController = new EnrollmentController(viewEnrollment);
        GradeController gradeController = new GradeController(viewGrade);

        Student newStudent = new Student(12345, "Daniel", "daniel@gmail.com");
        Student newStudent1 = new Student(4321, "Juanito", "juanito@gmail.com");

        studentController.insertNewStudent(newStudent);
        studentController.insertNewStudent(newStudent1);

        studentController.displayAllStudents();

        Teacher newTeacher = new Teacher(1235, "Pablo", "Ciencias Sociales");
        teacherController.insertNewTeacher(newTeacher);
        teacherController.displayAllTeachers();

        Course newCourse = new Course(1234, "Historia", "...", true, newTeacher.getId());
        courseController.insertNewCourse(newCourse);
        courseController.displayAllCourses();

        Enrollment newEnrollment = new Enrollment(1, newStudent.getId(), newCourse.getId()); // Asumiendo un ID para la inscripción
        enrollmentController.insertNewEnrollment(newEnrollment);

        enrollmentController.displayAllEnrollments();


    }
}
