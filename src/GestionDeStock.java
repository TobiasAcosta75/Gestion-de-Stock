import java.util.Scanner;

public class GestionDeStock {

    static  Producto[] productos = new Producto[10];// Creamos un array de productos con capacidad para 10 productos
    static  Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        int opcion;
        int categoria;
        // String nombre = scanner.nextLine();
        // String id = scanner.nextLine();
        // Double precioBase = scanner.nextDouble();
        // int stock =  scanner.nextInt();
        
        System.out.println("=== SISTEMA DE AUTOGESTIÓN DE SUPERMERCADO ===");
        System.out.println("1- Alta de producto");
        System.out.println("2- Listado");
        System.out.println("3- Venta (simulación)");
        System.out.println("4- Salir");

        do{
            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                        System.out.println("<<<<ALTA DE PRODUCTO>>>>");
                        System.out.print("Ingrese la categoria del producto a agregar: ");
                        System.out.println("1- Alimentos");
                        System.out.println("2- Tecnologia");
                        System.out.println("3- Perfumeria");

                        categoria = scanner.nextInt();
                        agregar(categoria);

                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
            
                default:

                    break;
            }
        }while(opcion < 4);

    }
    public static void agregar(int categoria){
       

        switch (categoria) {
            case 1:
                    altaAlimento();
                break;
            case 2:
                
                break;
            case 3:
                
                break;
        
            default:
                break;
        }
    }
    public static void altaAlimento(){
        
        String nombre;
        String id;
        Double precioBase;
        int stock;
        Boolean valid = true;
        
        System.out.println("**Alta de Alimento**");
            System.out.print("Nombre: ");
                nombre = scanner.nextLine();
            System.out.print("\nPrecio (sin iva): ");
                precioBase = scanner.nextDouble();
            System.out.print("\nId: ");
                id = scanner.nextLine();
            System.out.print("\nStock: ");
                stock = scanner.nextInt();
            
        for (int i = 0; i < productos.length; i++) {
            //se valida si hay stock del producto, si hay se suma y no ocupa un lugar nuevo en el almacen
            for (int j = 0; j < productos.length && valid; j++) {
                if (productos[i].nombre.equals(nombre) && productos[j].id == id) {
                    productos[j].stock += stock;
                    
                    System.out.println("Se sumo al stock!");
                    return;
                }
            }
            valid = false; //EVITAMOS QUE HAGA UNA VALIDACION YA HECHA!
            //si no hay stock y hay lugar disponible, se agrega
            if (productos[i] == null) { 
                productos[i] = new Alimentos(nombre, precioBase, id, stock);
                System.out.println("Producto Agregado!");
                return;
            }
        }
        System.out.println("---NO HAY MAS ESPACIO EN EL DEPOSITO---");
        return;
    }
}
 