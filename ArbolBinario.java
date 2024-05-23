import java.io.PrintWriter;
import java.util.Scanner;

public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void insertarParticipante(Participante participante) {
        Nodo nuevo = new Nodo(participante);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            insertarNodo(raiz, nuevo);
        }
    }

    private void insertarNodo(Nodo actual, Nodo nuevo) {
        if (nuevo.getDato().getFolio() < actual.getDato().getFolio()) {
            if (actual.getIzq() == null) {
                actual.setIzq(nuevo);
            } else {
                insertarNodo(actual.getIzq(), nuevo);
            }
        } else if (nuevo.getDato().getFolio() > actual.getDato().getFolio()) {
            if (actual.getDer() == null) {
                actual.setDer(nuevo);
            } else {
                insertarNodo(actual.getDer(), nuevo);
            }
        } else {
            System.out.println("Folio ya existente.");
        }
    }

    public Participante buscarParticipante(int folio) {
        return buscarNodo(raiz, folio);
    }

    private Participante buscarNodo(Nodo actual, int folio) {
        if (actual == null) {
            return null;
        } else if (actual.getDato().getFolio() == folio) {
            return actual.getDato();
        } else if (folio < actual.getDato().getFolio()) {
            return buscarNodo(actual.getIzq(), folio);
        } else {
            return buscarNodo(actual.getDer(), folio);
        }
    }

    public void listarAsistentes() {
        listarAsistentes(raiz);
    }

    private void listarAsistentes(Nodo actual) {
        if (actual != null) {
            listarAsistentes(actual.getIzq());
            if (actual.getDato().getAsistencia()) {
                System.out.println(actual.getDato().getNombre());
            }
            listarAsistentes(actual.getDer());
        }
    }

    public void listarNoAsistentes() {
        listarNoAsistentes(raiz);
    }

    private void listarNoAsistentes(Nodo actual) {
        if (actual != null) {
            listarNoAsistentes(actual.getIzq());
            if (!actual.getDato().getAsistencia()) {
                System.out.println(actual.getDato().getFolio() + " - " + actual.getDato().getNombre());
            }
            listarNoAsistentes(actual.getDer());
        }
    }

    public void guardarEnArchivo() {
        try (PrintWriter asistentes = new PrintWriter("asistentes.txt");
             PrintWriter noAsistentes = new PrintWriter("no_asistentes.txt")) {
            guardarEnArchivo(raiz, asistentes, noAsistentes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void guardarEnArchivo(Nodo actual, PrintWriter asistentes, PrintWriter noAsistentes) {
        if (actual != null) {
            guardarEnArchivo(actual.getIzq(), asistentes, noAsistentes);
            if (actual.getDato().getAsistencia()) {
                asistentes.println(actual.getDato().getFolio() + " - " + actual.getDato().getNombre());
            } else {
                noAsistentes.println(actual.getDato().getFolio() + " - " + actual.getDato().getNombre());
            }
            guardarEnArchivo(actual.getDer(), asistentes, noAsistentes);
        }
    }
}
