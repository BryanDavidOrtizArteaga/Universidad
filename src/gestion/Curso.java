package gestion;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor;
    private List<Estudiante> estudiantes;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
        System.out.println("        Curso '" + nombre + "' (" + codigo + ") creado.");
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void asignarProfesor(Profesor profesor) {
        if (this.profesor != null && this.profesor != profesor) {
            this.profesor.desasignarCurso(this);
        }
        this.profesor = profesor;
        if (profesor != null) {
            profesor.asignarCurso(this);
            System.out.println("          Profesor '" + profesor.getNombre() + "' asignado al curso '" + this.nombre + "'.");
        } else {
            System.out.println("          Profesor desasignado del curso '" + this.nombre + "'.");
        }
    }

    public void inscribirEstudiante(Estudiante estudiante) {
        if (!this.estudiantes.contains(estudiante)) {
            this.estudiantes.add(estudiante);
            estudiante.inscribirCurso(this);
            System.out.println("          Estudiante '" + estudiante.getNombre() + "' inscrito en el curso '" + this.nombre + "'.");
        }
    }

    public void desinscribirEstudiante(String codigoEstudiante) {
        boolean removido = this.estudiantes.removeIf(e -> e.getCodigo().equalsIgnoreCase(codigoEstudiante));
        if (removido) {
            System.out.println("          Estudiante con código '" + codigoEstudiante + "' desinscrito del curso '" + this.nombre + "'.");
        }
    }

    public List<Estudiante> getEstudiantes() {
        return new ArrayList<>(estudiantes);
    }

    public void generarReporte(GeneradorReporte generador) {
        System.out.println("            Generando reporte para el curso '" + this.nombre + "'...");
        generador.generarReporteCurso(this);
    }
}