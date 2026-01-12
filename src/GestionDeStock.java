import java.util.Scanner;

public class GestionDeStock {

    static  Producto[] productos = new Producto[10];// Creamos un array de productos con capacidad para 10 productos
    static  Scanner scanner = new Scanner(System.in);// Scanner para leer entradas del usuario
    public static void main(String[] args) throws Exception {
        
        int opcion;
        int categoria;
        
        System.out.println("=== SISTEMA DE AUTOGESTIÓN DE SUPERMERCADO ===");
        System.out.println("1- Alta de producto");
        System.out.println("2- Listado");
        System.out.println("3- Venta (simulación)");
        System.out.println("4- Salir");

        do{//Bucle principal del programa
            chequeoStock();//Llamada al metodo que chequea el stock
            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {//Menu de opciones 
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
    public static void chequeoStock(){//Metodo que chequea el stock de los productos
        System.out.println("CARGANDO STOCK....");
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] !=null) {//Si el producto no es nulo
                if (productos[i].stock == 0) {
                    productos[i] = null;//Eliminamos el producto del array si su stock es 0
                }
            } 
        }
        System.out.println("STOCK CARGADO....");
        return;
    }
    public static void venta(){//Metodo que simula una venta
        scanner.nextLine();//Limpiamos el buffer del scanner
        String nombreVenta;
        System.out.println("Introduce el nombre del producto que desea comprar:");
        nombreVenta = scanner.nextLine().toLowerCase();
        
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] !=null) {
                if (productos[i].nombre.equals(nombreVenta)) {//Si el nombre del producto coincide con el nombre ingresado
                productos[i].stock --;//Disminuimos el stock en 1
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
    public static void listar(){//Metodo que lista los productos en stock
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
    public static void altaProducto( int categoria){//Metodo que da de alta un producto
        
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
                if (productos[i].nombre.equals(nombre)) {//Si el nombre del producto ya existe, sumamos el stock
                productos[i].stock += stock;
                System.out.println("Se sumo el Producto al Stock!");
                return;
                }
            }
        }
        for (int i = 0; i < productos.length; i++) {
            if (productos[i]==null) {
                switch (categoria) {//Segun la categoria, creamos un objeto de la clase correspondiente
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
 