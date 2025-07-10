package gestion;

public class GeneradorReporte {

    public void generarReporteCurso(Curso curso) {
        System.out.println("\n--- REPORTE DE CURSO ---");
        System.out.println("  Código del Curso: " + curso.getCodigo());
        System.out.println("  Nombre del Curso: " + curso.getNombre());
        if (curso.getProfesor() != null) {
            System.out.println("  Profesor Asignado: " + curso.getProfesor().getNombre() + " (" + curso.getProfesor().getEspecialidad() + ")");
        } else {
            System.out.println("  Profesor Asignado: Ninguno");
        }
        System.out.println("  Estudiantes Inscritos (" + curso.getEstudiantes().size() + "):");
        if (curso.getEstudiantes().isEmpty()) {
            System.out.println("    No hay estudiantes inscritos.");
        } else {
            for (Estudiante estudiante : curso.getEstudiantes()) {
                System.out.println("    - " + estudiante.getNombre() + " (Código: " + estudiante.getCodigo() + ")");
            }
        }
        System.out.println("--- FIN REPORTE DE CURSO ---\n");
    }

    public void generarReporteProfesoresDepartamento(Departamento departamento) {
        System.out.println("\n--- REPORTE DE PROFESORES DEL DEPARTAMENTO '" + departamento.getNombre() + "' ---");
        if (departamento.getProfesores().isEmpty()) {
            System.out.println("  No hay profesores en este departamento.");
        } else {
            for (Profesor profesor : departamento.getProfesores()) {
                System.out.println("  - " + profesor.getNombre() + " (" + profesor.getEspecialidad() + ")");
            }
        }
        System.out.println("--- FIN REPORTE --- \n");
    }
}