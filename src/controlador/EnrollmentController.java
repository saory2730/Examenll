package controlador;

import modelo.Enrollment;
import vista.ViewEnrollment;

import java.util.List;

public class EnrollmentController {
    private ViewEnrollment view;

    // Constructor que recibe la vista
    public EnrollmentController(ViewEnrollment view) {
        this.view = view;
    }

    public void insertNewEnrollment(Enrollment newEnrollment) {
        Enrollment.insertEnrollment(newEnrollment);
        view.mostrarMensaje("\nInscripción guardado correctamente!");
    }

    public void displayAllEnrollments() {
        List<Enrollment> enrollments = Enrollment.getAllEnrollments();
        view.displayListEnrollments(enrollments);
    }


}