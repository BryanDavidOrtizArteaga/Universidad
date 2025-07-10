package gestion;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String codigo;
    private String nombre;
    private List<Curso> cursosInscritos;

    public Estudiante(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cursosInscritos = new ArrayList<>();
        System.out.println("        Estudiante '" + nombre + "' (" + codigo + ") creado.");
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void inscribirCurso(Curso curso) {
        if (!this.cursosInscritos.contains(curso)) {
            this.cursosInscritos.add(curso);
            curso.inscribirEstudiante(this);
            System.out.println("          Estudiante '" + this.nombre + "' inscrito en el curso '" + curso.getNombre() + "'.");
        } else {
            System.out.println("          Estudiante '" + this.nombre + "' ya está inscrito en el curso '" + curso.getNombre() + "'.");
        }
    }

    public void desinscribirCurso(Curso curso) {
        if (this.cursosInscritos.remove(curso)) {
            curso.desinscribirEstudiante(this.codigo);
            System.out.println("          Estudiante '" + this.nombre + "' desinscrito del curso '" + curso.getNombre() + "'.");
        }
    }

    public List<Curso> getCursosInscritos() {
        return new ArrayList<>(cursosInscritos);
    }

    @Override
    public String toString() {
        return "Estudiante{" + "codigo='" + codigo + '\'' + ", nombre='" + nombre + '\'' + '}';
    }
}