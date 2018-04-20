package mx.com.itam.adsi.ejercicio;
/**
 *La clase solución contiene los métodos necesarios para  construir
 *una prueba para la clase Nodo. Básicamente crea una secuencia de
 *nodos y la modifica. 
*/
import org.apache.log4j.Logger;
public class Solucion {
/**
 *La clase Nodo tiene dos atributos. El primero es de tipo String
 *y representa la información del Nodo. El siguiente atributo es de
 *tipo Nodo y representa al siguiente Nodo para poder formar una
 *lista ligada.
*/
   private final static Logger LOG = Logger.getLogger(Solucion.class);
   public class Node {
       public  String data;
       public Node next;
        /**
	 *Constructor de la clase Nodo, recibe como parámetro un 
	 *String data que representa la información del nodo.
	 */
        public Node(String data) {
            this.data = data;
        }
        /**
	 *El método gus invierte el orden de la lista de nodos
	 */
        public Node gus() {
            if(next == null) return this; //si el atributo next del nodo es nulo, el método regresa el nodo que lo invocó
            Node otro = next; //nodo axiliar otro que es el siguiente de quien lo invocó
            next      = null; //se borra el siguiente nodo de quien invocó
            Node tavo = otro.gus(); 
            otro.next = this;//asigna al siguiente del nodo otro, el nodo que invocó el método
            return tavo;
        }
      
        /**
         * Imprime en la consola la secuencia de Nodos que 
         * componen a esta lista. Por ejemplo, para la lista
         * que devuelve el método "build", la invocación de
         * este método escribe en la consola: 
         * 
         * A-->B-->C-->D-->E-->F-->
         * 
         * Lo anterior sería lo que se visualiza en la consola 
         * justo después de ejecutar las siguintes dos lineas:
         * 
         *         Node a = build();
         *         a.prn();
         *         
         */
        public void prn() {
	    Node aux = this.next;
	    System.out.print(this.data + "-->");
	    while(aux != null)
	    {
	       System.out.print(aux.data + "-->");
	       aux = aux.next;
	    }
            // Este método requiere sólo de 3 a 7 lineas de código para funcionar correctamente
        }
	public String prnt(){
	Node aux = this.next;
	String resp = "";
	resp += this.data + "-->";
	while(aux != null)
	{
	  resp += aux.data + "-->";
	  aux = aux.next;
	}
	return resp;
}
        
    }// ends Node class
    
    /**
     * 
     * Método que crea 6 Nodos cada uno con una letra diferente y
     * luego a cada uno en su propiedad next le asigna en siguiente.
     * 
     * @return Node Regresa el nodo raíz (primero que se creó).
     */
    private Node build() {
	LOG.info("Creando nodos");
        Node n1 = new Node("A");
        Node n2 = new Node("B");
        Node n3 = new Node("C");
        Node n4 = new Node("D");
        Node n5 = new Node("E");
        Node n6 = new Node("F");
	LOG.info("Asignando next a cada uno de los nodos creados.");
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
	n6.next = null;
        return n1;
    }

    /**
     * Prueba la funcionalidad de el método "gus" con distintos casos de prueba
     */
    public void ok() {
        Node a = build();
	LOG.info("imprimiendo lista empezando con a");
        a.prn();
	LOG.info("llamando al método gus");
        a = a.gus();
	LOG.info("imprimiendo lo que queda después de gus desde a");
        a.prn();
	LOG.info("volviendo a llamar gus desde A");
        a = a.gus();
	LOG.info("volviendo a imprimir la lista comenzando en A");
        a.prn();
        LOG.info("Creando nodo b, no está ligado a ningún otro");
        Node b = new Node("X");
        b = b.gus();
	LOG.info("Imprimiendo la lista desde b, solo debería salir b");
        b.prn();
        
        Node c = new Node("X");
        Node d = new Node("Y");
        c.next = d;
        c = c.gus();
        c.prn();   
    }
    public static void main(String...argv) {
	LOG.info("Comenzando ejecución");
        new Solucion().ok();
    }

}
