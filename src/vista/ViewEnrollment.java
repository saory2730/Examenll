package vista;

import modelo.Enrollment;
import java.util.List;

public class ViewEnrollment  {

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void displayListEnrollments(List<Enrollment> enrollments) {
        for (Enrollment enrollment : enrollments) {
            System.out.println("Inscripción ID: " + enrollment.getId() +
                    ", Estudiante ID: " + enrollment.getStudentId() +
                    ", Curso ID: " + enrollment.getCourseId());
        }
    }

}