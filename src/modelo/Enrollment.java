package modelo;

import db.connection;
import interfaces.IMostrarDetalle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Enrollment implements IMostrarDetalle {

    @Override
    public void mostrarDetalle() {
        System.out.println("ID de Inscripción o matricula: " + id);
        System.out.println("ID del Estudiante: " + studentId);
        System.out.println("ID del Curso: " + courseId);
    }
    private int id;
    private int studentId;
    private int courseId;

    public Enrollment(int id, int studentId, int courseId) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public static void insertEnrollment(Enrollment enrollment) {
        Connection con = connection.getConnection();
        String sql =

                "INSERT INTO enrollment (id, student_id, course_id) VALUES (?, ?, ?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, enrollment.getId());
            statement.setInt(2, enrollment.getStudentId());
            statement.setInt(3, enrollment.getCourseId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Enrollment> getAllEnrollments() {
        Connection con = connection.getConnection();
        List<Enrollment> enrollmentList = new ArrayList<>();
        String sql = "SELECT * FROM enrollment";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Enrollment enrollment = new Enrollment(
                        rs.getInt("id"),
                        rs.getInt("student_id"),
                        rs.getInt("course_id")
                );
                enrollmentList.add(enrollment);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollmentList;
    }
    public static List<Enrollment> getEnrollmentsByCourse(int courseId) {
        Connection con = connection.getConnection();
        List<Enrollment> enrollmentList = new ArrayList<>();
        String sql =

                "SELECT * FROM enrollment WHERE course_id = ?";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, courseId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Enrollment enrollment = new Enrollment(
                        rs.getInt("id"),
                        rs.getInt("student_id"),
                        rs.getInt("course_id")
                );
                enrollmentList.add(enrollment);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return enrollmentList;
    }


}