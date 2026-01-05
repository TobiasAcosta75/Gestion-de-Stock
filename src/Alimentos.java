import Interfaces.IDescuento;

public class Alimentos extends Producto implements IDescuento {

    Double porcentajeDescuento = 10.0;

    public Alimentos(String nombre, Double precioBase, String id, int stock) {
        super(nombre, precioBase, id, stock);
    }

    @Override
    public Double aplicarDescuento() {
        return super.precioBase - (super.precioBase * porcentajeDescuento / 100);
    }

    @Override
    public Double calcularPrecioFinal() {
        return (aplicarDescuento() + ((aplicarDescuento() * 4)/100));
    }

}
