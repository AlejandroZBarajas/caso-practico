public class Participante {
    private int folio;
    private String nombre;
    private boolean asistencia;

    public Participante(int folio, String nombre) {
        this.folio = folio;
        this.nombre = nombre;
        this.asistencia = false;
    }

    public int getFolio() {
        return folio;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }
}
