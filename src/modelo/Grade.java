package modelo;

import db.connection;
import interfaces.IMostrarDetalle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Grade implements IMostrarDetalle {

    @Override
    public void mostrarDetalle() {
        System.out.println("ID de Nota: " + id);
        System.out.println("ID de Inscripción o Matriculs: " + enrollmentId);
        System.out.println("ID de Tipo de Nota: " + gradeTypeId);
        System.out.println("Valor de la Nota: " + grade);
    }
    private int id;
    private int enrollmentId;
    private int gradeTypeId;
    private double grade;

    public Grade(int id, int enrollmentId, int gradeTypeId, double grade) {
        this.id = id;
        this.enrollmentId = enrollmentId;
        this.gradeTypeId = gradeTypeId;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public int getGradeTypeId() {
        return gradeTypeId;
    }

    public double getGrade() {
        return grade;
    }

    public static void insertGrade(Grade grade) {
        Connection con = connection.getConnection();
        String sql =

                "INSERT INTO grades (id, enrollment_id, grade_type_id, grade) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, grade.getId());
            statement.setInt(2, grade.getEnrollmentId());
            statement.setInt(3, grade.getGradeTypeId());
            statement.setDouble(4, grade.getGrade());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Grade> getAllGrades(int courseId) {
        Connection con = connection.getConnection();
        List<Grade> gradesList = new ArrayList<>();

        String sql = "SELECT g.id AS grade_id, e.student_id, gt.name AS grade_type, g.grade, gt.weight FROM grades g  JOIN enrollment e ON g.enrollment_id = e.id JOIN grade_type gt ON g.grade_type_id = gt.id WHERE e.course_id = ?";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, courseId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Grade grade = new Grade(
                        rs.getInt("grade_id"),
                        rs.getInt("student_id"),
                        rs.getInt("grade_type_id"),
                        rs.getDouble("grade")
                );
                gradesList.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradesList;

    }


}
