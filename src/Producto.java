public abstract class Producto {
    // Atributos
    String nombre;
    String id; // cada producto tiene un id unico
    Double precioBase;
    int stock;
    // Constructor
    public Producto(String nombre, Double precioBase, String id, int stock){
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.id = id;
        this.stock = stock;
    }
    // Método para ver la etiqueta del producto
    public void verEtiqueta(){
        System.out.println("--- ETIQUETA DEL PRODUCTO ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Precio: $" + calcularPrecioFinal());
        System.out.println("Stock: " + stock);
    };
    // Método abstracto para calcular el precio final
    public abstract Double calcularPrecioFinal();
}
