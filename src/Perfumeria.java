import Interfaces.IDescuento;

public class Perfumeria extends Producto implements IDescuento{
    Double porcentajeDescuento = 20.0;
    public Perfumeria(String nombre, Double precioBase, String id, int stock) {
        super(nombre, precioBase, id, stock);//llamamos al constructor de la clase padre
    }

    @Override
    public Double calcularPrecioFinal() {
        return (aplicarDescuento() + ((aplicarDescuento() * 15)/100));    
    }

    @Override
    public Double aplicarDescuento() {
        return super.precioBase - (super.precioBase * porcentajeDescuento / 100);
    }

}
