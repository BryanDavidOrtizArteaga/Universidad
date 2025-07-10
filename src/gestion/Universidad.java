package gestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Universidad {
    private String nombre;
    private List<Departamento> departamentos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.departamentos = new ArrayList<>();
        System.out.println("Universidad '" + nombre + "' creada.");
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarDepartamento(String nombreDepartamento) {
        Departamento nuevoDepartamento = new Departamento(nombreDepartamento);
        this.departamentos.add(nuevoDepartamento);
        System.out.println("  Departamento '" + nombreDepartamento + "' agregado a la universidad '" + this.nombre + "'.");
    }

    public void eliminarDepartamento(String nombreDepartamento) {
        boolean removido = this.departamentos.removeIf(d -> d.getNombre().equals(nombreDepartamento));
        if (removido) {
            System.out.println("  Departamento '" + nombreDepartamento + "' eliminado de la universidad '" + this.nombre + "'.");
        } else {
            System.out.println("  Departamento '" + nombreDepartamento + "' no encontrado en la universidad '" + this.nombre + "'.");
        }
    }

    public List<Departamento> getDepartamentos() {
        return new ArrayList<>(departamentos);
    }

    public Optional<Departamento> buscarDepartamento(String nombreDepartamento) {
        return departamentos.stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(nombreDepartamento))
                .findFirst();
    }

    public List<Profesor> obtenerTodosProfesores() {
        List<Profesor> todosProfesores = new ArrayList<>();
        for (Departamento d : departamentos) {
            todosProfesores.addAll(d.getProfesores());
        }
        return todosProfesores;
    }
}