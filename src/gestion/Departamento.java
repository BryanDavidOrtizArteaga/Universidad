package gestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Departamento {
    private String nombre;
    private List<Profesor> profesores;
    private List<Curso> cursos;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
        System.out.println("    Departamento '" + nombre + "' creado.");
    }

    public String getNombre() {
        return nombre;
    }

    public void contratarProfesor(Profesor profesor) {
        if (!this.profesores.contains(profesor)) {
            this.profesores.add(profesor);
            System.out.println("      Profesor '" + profesor.getNombre() + "' contratado en el departamento '" + this.nombre + "'.");
        } else {
            System.out.println("      Profesor '" + profesor.getNombre() + "' ya está en el departamento '" + this.nombre + "'.");
        }
    }

    public void despedirProfesor(String nombreProfesor) {
        boolean removido = this.profesores.removeIf(p -> p.getNombre().equalsIgnoreCase(nombreProfesor));
        if (removido) {
            System.out.println("      Profesor '" + nombreProfesor + "' despedido del departamento '" + this.nombre + "'.");
        } else {
            System.out.println("      Profesor '" + nombreProfesor + "' no encontrado en el departamento '" + this.nombre + "'.");
        }
    }

    public List<Profesor> getProfesores() {
        return new ArrayList<>(profesores);
    }

    public void ofrecerCurso(Curso curso) {
        if (!this.cursos.contains(curso)) {
            this.cursos.add(curso);
            System.out.println("      Curso '" + curso.getNombre() + "' ofrecido por el departamento '" + this.nombre + "'.");
        } else {
            System.out.println("      Curso '" + curso.getNombre() + "' ya ofrecido por el departamento '" + this.nombre + "'.");
        }
    }

    public Optional<Curso> buscarCurso(String codigoCurso) {
        return cursos.stream()
                .filter(c -> c.getCodigo().equalsIgnoreCase(codigoCurso))
                .findFirst();
    }

    public List<Curso> getCursos() {
        return new ArrayList<>(cursos);
    }
}
