package model;

public class Productos {
    private int idProductos;
    private String nombreProductos;
    private String categoriaProdutos;
    private double precioProducto;
    private String descripcionProducto;

    public Productos() {
    }

    public Productos( String nombreProductos, String categoriaProdutos, double precioProducto, String descripcionProducto) {
        this.nombreProductos = nombreProductos;
        this.categoriaProdutos = categoriaProdutos;
        this.precioProducto = precioProducto;
        this.descripcionProducto = descripcionProducto;
    }

    public int getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    public String getNombreProductos() {
        return nombreProductos;
    }

    public void setNombreProductos(String nombreProductos) {
        this.nombreProductos = nombreProductos;
    }

    public String getCategoriaProdutos() {
        return categoriaProdutos;
    }

    public void setCategoriaProdutos(String categoriaProdutos) {
        this.categoriaProdutos = categoriaProdutos;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }
}



