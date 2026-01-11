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
            chequeoStock();
            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                        System.out.println("<<<<ALTA DE PRODUCTO>>>>");
                        System.out.println("Ingrese la categoria del producto a agregar: ");
                        System.out.println("1- Alimentos");
                        System.out.println("2- Tecnologia");
                        System.out.println("3- Perfumeria");

                        categoria = scanner.nextInt();
                        altaProducto(categoria);

                    break;
                case 2: listar();
                    break;
                case 3: venta();    
                    break;
                case 4:
                        System.out.println("SALIENDO DEL PROGRAMA....");
                    break;
            
                default:
                        System.out.println("Ingrese una opcion valida, por favor!");
                    break;
            }
        }while(opcion < 4);

    }
    public static void chequeoStock(){
        System.out.println("CARGANDO STOCK....");
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] !=null) {
                if (productos[i].stock == 0) {
                    productos[i] = null;
                }
            } 
        }
        System.out.println("STOCK CARGADO....");
        return;
    }
    public static void venta(){
        scanner.nextLine();
        String nombreVenta;
        System.out.println("Introduce el nombre del producto que desea comprar:");
        nombreVenta = scanner.nextLine().toLowerCase();
        
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] !=null) {
                if (productos[i].nombre.equals(nombreVenta)) {
                productos[i].stock --;
                System.out.println("¡¡PRODUCTO VENDIDO!!");
                System.out.println("ID: " + productos[i].id);
                System.out.println("Nombre: " + productos[i].nombre);
                System.out.println("Precio: " + productos[i].calcularPrecioFinal());
                System.out.println("Precio (sin iva): " + productos[i].precioBase);
                System.out.println("Stock: " + productos[i].stock);

                return;
                }
            }
        }
        System.out.println("Nos quedamos sin STOCK...PERO LE PODEMOS OFRECER: ");
        listar();
        return;
    }
    public static void listar(){
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null) {
                System.out.println("ID: " + productos[i].id);
                System.out.println("Nombre: " + productos[i].nombre);
                System.out.println("Precio: " + productos[i].calcularPrecioFinal());
                System.out.println("Precio (sin iva): " + productos[i].precioBase);
                System.out.println("Stock: " + productos[i].stock);
            }
        }
        return;
    }
    public static void altaProducto( int categoria){
        
        String nombre;
        String id;
        Double precioBase;
        int stock;
        
        
        System.out.println("**Alta de Alimento**");
        scanner.nextLine();
            System.out.print("Nombre: ");
                nombre = scanner.nextLine().toLowerCase();
            System.out.print("\nPrecio (sin iva): ");
                precioBase = scanner.nextDouble();
            scanner.nextLine();    
            System.out.print("\nId: ");
                id = scanner.nextLine().toLowerCase();
            System.out.print("\nStock: ");
                stock = scanner.nextInt();
            scanner.nextLine();
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] !=null) {
                if (productos[i].nombre.equals(nombre)) {
                productos[i].stock += stock;
                System.out.println("Se sumo el Producto al Stock!");
                return;
                }
            }
        }
        for (int i = 0; i < productos.length; i++) {
            if (productos[i]==null) {
                switch (categoria) {
                    case 1://ALIMENTOS
                            productos[i] = new Alimentos(nombre, precioBase, id, stock);
                        break;
                    case 2://TECNOLOGIA
                            productos[i] = new Tecnologia(nombre, precioBase, id, stock);
                        break;
                    case 3://PERFUMERIA
                            productos[i] = new Perfumeria(nombre, precioBase, id, stock);
                        break;
                    default: System.err.println("Seleccione una opcion valida!");
                        return;
                }
                System.out.println("El producto ha sido agregado con exito!");
                return;
            }  
        }
        System.out.println("---NO HAY MAS ESPACIO EN EL DEPOSITO---");
        return;
    }
}
 