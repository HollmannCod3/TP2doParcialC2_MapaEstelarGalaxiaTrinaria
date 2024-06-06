package galaxiaternaria_edatp2;

/**
 *
 * @author Hollmann y crfistian
 */
public class Nodo {

    String nombreSistemaEstelar;
    Nodo izquierdo, medio, derecho;

    public Nodo(String nombre) {
        this.nombreSistemaEstelar = nombre;
        this.izquierdo = this.medio = this.derecho = null;
    }

    public String getNombre() {
        return nombreSistemaEstelar;
    }

    public void setIzq(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setMed(Nodo medio) {
        this.medio = medio;
    }

    public void setDer(Nodo derecho) {
        this.derecho = derecho;
    }

}
