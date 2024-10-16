package vista;
import modelo.Grade;
import java.util.List;

public class ViewGrade{

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void displayListGrades(List<Grade> grades) {
        for (Grade grade : grades) {
            System.out.println("ID Nota: " + grade.getId());
            System.out.println("ID Estudiante: " + grade.getEnrollmentId());
            System.out.println("ID Tipo Nota: " + grade.getGradeTypeId());
            System.out.println("Nota: " + grade.getGrade());
            System.out.println();
        }
    }

}