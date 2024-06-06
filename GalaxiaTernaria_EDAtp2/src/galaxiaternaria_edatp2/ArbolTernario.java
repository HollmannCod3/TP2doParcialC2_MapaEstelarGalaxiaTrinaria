package galaxiaternaria_edatp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Hollmann y Cristian
 */
public class ArbolTernario {

    Nodo raiz;

    public ArbolTernario() {
        this.raiz = null;
    }

   
    public void insertar(String nombre, String padre, int posicion) {
        if (raiz == null) {
            raiz = new Nodo(nombre);
        } else {
            insertarRecursivo(raiz, nombre, padre, posicion);
        }
    }

    private boolean insertarRecursivo(Nodo actual, String nombre, String padre, int posicion) {
        if (actual == null) {
            return false;
        }
        if (actual.getNombre().equals(padre)) {
            Nodo nodoNuevo = new Nodo(nombre);
            switch (posicion) {
                case 0:
                    actual.setIzq(nodoNuevo);
                    break;
                case 1:
                    actual.setMed(nodoNuevo);
                    break;
                case 2:
                    actual.setDer(nodoNuevo);
                    break;
            }
            return true;
        }
        return insertarRecursivo(actual.izquierdo, nombre, padre, posicion)
                || insertarRecursivo(actual.medio, nombre, padre, posicion)
                || insertarRecursivo(actual.derecho, nombre, padre, posicion);
    }

    
    public List<String> encontrarCaminoMasEficiente(String inicio, String destino) {
        List<String> caminoActual = new ArrayList<>();
        List<String> mejorCamino = new ArrayList<>();
        encontrarCaminoRecursivo(raiz, inicio, destino, caminoActual, mejorCamino);
        return mejorCamino;
    }

    private boolean encontrarCaminoRecursivo(Nodo actual, String inicio, String destino, List<String> caminoActual, List<String> mejorCamino) {
        if (actual == null) {
            return false;
        }
        caminoActual.add(actual.getNombre());
        if (actual.getNombre().equals(destino)) {
            if (mejorCamino.isEmpty() || caminoActual.size() < mejorCamino.size()) {
                mejorCamino.clear();
                mejorCamino.addAll(caminoActual);
            }
            caminoActual.remove(caminoActual.size() - 1);
            return true;
        }
        boolean encontrado = encontrarCaminoRecursivo(actual.izquierdo, inicio, destino, caminoActual, mejorCamino)
                || encontrarCaminoRecursivo(actual.medio, inicio, destino, caminoActual, mejorCamino)
                || encontrarCaminoRecursivo(actual.derecho, inicio, destino, caminoActual, mejorCamino);
        caminoActual.remove(caminoActual.size() - 1);
        return encontrado;
    }

    public void insertarInteractivo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al mapa estelar de la Galaxia Trinaria!");

        while (true) {
            System.out.println("Ingrese el nombre del sistema estelar (o 'fin' para terminar): ");
            String nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("fin")) {
                break;
            }

            System.out.println("Ingrese el nombre del sistema estelar padre (en caso de ser la raiz, no ingrese nada): ");
            String padre = scanner.nextLine();

            System.out.println("Ingrese la posición (0 para izquierda, 1 para medio, 2 para derecha): ");
            int posicion = scanner.nextInt();
            scanner.nextLine();  

            insertar(nombre, padre, posicion);
        }
    }

    public void buscarCaminoInteractivo() {
        Scanner scanner = new Scanner(System.in);
        
        while(true){
        System.out.println("Ingrese el sistema estelar de inicio (o 'fin' para terminar el programa) ");
        String inicio = scanner.nextLine();
         if(inicio.equalsIgnoreCase("fin")){
            break;
        }

        System.out.println("Ingrese el sistema estelar de destino: ");
        String destino = scanner.nextLine();
       

        List<String> camino = encontrarCaminoMasEficiente(inicio, destino);
        System.out.println("Camino más eficiente de " + inicio + " a " + destino + ": " + camino);
    }
    }

}
