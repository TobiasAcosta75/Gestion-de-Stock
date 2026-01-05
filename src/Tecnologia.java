public class Tecnologia extends Producto{

    public Tecnologia(String nombre, Double precioBase, String id, int stock) {
        super(nombre, precioBase, id, stock);//llamamos al constructor de la clase padre
    }

    @Override
    public Double calcularPrecioFinal() {
        return (super.precioBase + ((super.precioBase * 21)/100));    
    }

        
}
