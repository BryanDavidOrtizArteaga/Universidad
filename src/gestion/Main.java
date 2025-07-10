package gestion;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Inicio del Sistema de Gestión Universitaria --- \n");
        GeneradorReporte generadorReporte = new GeneradorReporte();

        System.out.println("--- Demostrando Composición (Universidad - Departamento) ---");
        Universidad miUniversidad = new Universidad("Universidad Central");
        miUniversidad.agregarDepartamento("Ingeniería");
        miUniversidad.agregarDepartamento("Humanidades");

        System.out.println("\nDepartamentos de '" + miUniversidad.getNombre() + "':");
        miUniversidad.getDepartamentos().forEach(d -> System.out.println("  - " + d.getNombre()));

        System.out.println("\n--- Demostrando Agregación (Departamento - Profesor) ---");
        Profesor profMateo = new Profesor("Mateo Pérez", "Programación");
        Profesor profLaura = new Profesor("Laura García", "Literatura");
        Profesor profCarlos = new Profesor("Carlos Ruiz", "Bases de Datos");

        miUniversidad.buscarDepartamento("Ingeniería").ifPresent(depIngenieria -> {
            depIngenieria.contratarProfesor(profMateo);
            depIngenieria.contratarProfesor(profCarlos);
            System.out.println("\nProfesores en el departamento de " + depIngenieria.getNombre() + ":");
            depIngenieria.getProfesores().forEach(p -> System.out.println("  - " + p.getNombre()));
        });

        miUniversidad.buscarDepartamento("Humanidades").ifPresent(depHumanidades -> {
            depHumanidades.contratarProfesor(profLaura);
            System.out.println("\nProfesores en el departamento de " + depHumanidades.getNombre() + ":");
            depHumanidades.getProfesores().forEach(p -> System.out.println("  - " + p.getNombre()));
        });

        System.out.println("\nDespidiendo a Mateo Pérez del Departamento de Ingeniería...");
        miUniversidad.buscarDepartamento("Ingeniería").ifPresent(depIngenieria -> {
            depIngenieria.despedirProfesor("Mateo Pérez");
        });
        System.out.println("¿Existe todavía Mateo Pérez? " + (profMateo != null ? "Sí, " + profMateo.getNombre() + " sigue siendo un objeto Profesor." : "No."));

        System.out.println("\n--- Demostrando Asociación (Profesor - Curso, Estudiante - Curso) ---");
        miUniversidad.buscarDepartamento("Ingeniería").ifPresent(depIngenieria -> {
            Curso cursoPOO = new Curso("CS101", "Programación Orientada a Objetos");
            Curso cursoBD = new Curso("CS202", "Bases de Datos Avanzadas");
            depIngenieria.ofrecerCurso(cursoPOO);
            depIngenieria.ofrecerCurso(cursoBD);

            cursoPOO.asignarProfesor(profMateo);
            cursoBD.asignarProfesor(profCarlos);
            System.out.println("Profesor del curso POO: " + (cursoPOO.getProfesor() != null ? cursoPOO.getProfesor().getNombre() : "Ninguno"));
            System.out.println("Profesor del curso BD: " + (cursoBD.getProfesor() != null ? cursoBD.getProfesor().getNombre() : "Ninguno"));
        });

        Estudiante estJuan = new Estudiante("E001", "Juan Perez");
        Estudiante estMaria = new Estudiante("E002", "Maria Lopez");
        Estudiante estPedro = new Estudiante("E003", "Pedro Gómez");

        miUniversidad.buscarDepartamento("Ingeniería").ifPresent(depIngenieria -> {
            depIngenieria.buscarCurso("CS101").ifPresent(cursoPOO -> {
                estJuan.inscribirCurso(cursoPOO);
                estMaria.inscribirCurso(cursoPOO);
            });
            depIngenieria.buscarCurso("CS202").ifPresent(cursoBD -> {
                estJuan.inscribirCurso(cursoBD);
                estPedro.inscribirCurso(cursoBD);
            });
        });

        System.out.println("\nCursos inscritos por Juan: ");
        estJuan.getCursosInscritos().forEach(c -> System.out.println("  - " + c.getNombre()));
        System.out.println("\nEstudiantes inscritos en POO: ");
        miUniversidad.buscarDepartamento("Ingeniería").ifPresent(depIngenieria -> {
            depIngenieria.buscarCurso("CS101").ifPresent(cursoPOO -> {
                cursoPOO.getEstudiantes().forEach(e -> System.out.println("  - " + e.getNombre()));
            });
        });

        System.out.println("\n--- Demostrando Dependencia (Curso - GeneradorReporte) ---");
        miUniversidad.buscarDepartamento("Ingeniería").ifPresent(depIngenieria -> {
            depIngenieria.buscarCurso("CS101").ifPresent(cursoPOO -> {
                cursoPOO.generarReporte(generadorReporte);
            });
        });

        miUniversidad.buscarDepartamento("Ingeniería").ifPresent(depIngenieria -> {
            generadorReporte.generarReporteProfesoresDepartamento(depIngenieria);
        });

        System.out.println("\n--- Demostrando eliminación por Composición ---");
        System.out.println("Departamentos de la universidad antes de la 'eliminación':");
        miUniversidad.getDepartamentos().forEach(d -> System.out.println("  - " + d.getNombre()));
        System.out.println("\nSimulando la 'eliminación' de la Universidad Central (estableciendo la referencia a null)...");
        miUniversidad = null;

        System.out.println("\n--- Fin del Sistema de Gestión Universitaria ---");
    }
}