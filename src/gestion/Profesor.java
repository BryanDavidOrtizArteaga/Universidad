package gestion;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String nombre;
    private String especialidad;
    private List<Curso> cursosImpartidos;

    public Profesor(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cursosImpartidos = new ArrayList<>();
        System.out.println("        Profesor '" + nombre + "' (" + especialidad + ") creado.");
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void asignarCurso(Curso curso) {
        if (!this.cursosImpartidos.contains(curso)) {
            this.cursosImpartidos.add(curso);
            if (curso.getProfesor() != this) {
                curso.asignarProfesor(this);
            }
            System.out.println("          Profesor '" + this.nombre + "' asignado al curso '" + curso.getNombre() + "'.");
        }
    }

    public void desasignarCurso(Curso curso) {
        if (this.cursosImpartidos.remove(curso)) {
            if (curso.getProfesor() == this) {
                curso.asignarProfesor(null);
            }
            System.out.println("          Profesor '" + this.nombre + "' desasignado del curso '" + curso.getNombre() + "'.");
        }
    }

    public List<Curso> getCursosImpartidos() {
        return new ArrayList<>(cursosImpartidos);
    }

    @Override
    public String toString() {
        return "Profesor{" + "nombre='" + nombre + '\'' + ", especialidad='" + especialidad + '\'' + '}';
    }
}