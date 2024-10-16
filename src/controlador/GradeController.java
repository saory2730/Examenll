package controlador;

import modelo.Grade;
import vista.ViewGrade;

import java.util.List;

public class GradeController {
    private ViewGrade view;

    public GradeController (ViewGrade view) {
        this.view = view;
    }
    public void insertNewGrade(Grade newGrade) {
        Grade.insertGrade(newGrade);
        view.mostrarMensaje("\nNota guardado correctamente!");
    }

    public void displayGradesByCourse(int courseId) {
        List<Grade> grades = Grade.getAllGrades(courseId);
        view.displayListGrades(grades);
    }
}
