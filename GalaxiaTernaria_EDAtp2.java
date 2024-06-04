
package galaxiaternaria_edatp2;

/**
 *
 * @author Hollmann
 */
public class GalaxiaTernaria_EDAtp2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArbolTernario galaxia = new ArbolTernario();
        
        galaxia.insertar("nico", " ", 0);
        galaxia.insertar("cristian", "nico", 0);
        galaxia.insertar("a", "nico ", 1);
        galaxia.insertar("b", "nico ", 2);
        galaxia.insertar("c", "cristian", 0);
        galaxia.insertar("d", "cristian", 1);
        galaxia.insertar("e", "cristian", 2);
        galaxia.insertar("nico", "a", 0);
        galaxia.insertar("nico", "a", 1);
        galaxia.insertar("nico", "a", 2);
        galaxia.insertar("nico", "b", 0);
        galaxia.insertar("nico", "b", 1);
        galaxia.insertar("nico", "b", 2);
        
        System.out.println(galaxia);
        
    }
    
}
