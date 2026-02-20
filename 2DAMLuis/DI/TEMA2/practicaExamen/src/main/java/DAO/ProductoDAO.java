package DAO;

import DATABASE.DBConnection;
import model.Productos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductoDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public void insertarProducto(Productos productos) {
        ArrayList<Productos> ListaProductos = new ArrayList<>();
        ListaProductos.add(new Productos("Laptop Lenovo", "tecnología", 799.99, "Portátil de alto rendimiento, 16GB RAM"));
        ListaProductos.add(new Productos("Smartphone Samsung", "tecnología", 599.50, "Teléfono móvil con pantalla Super AMOLED"));
        ListaProductos.add(new Productos("Smartwatch Xiaomi", "tecnología", 89.90, "Reloj inteligente con monitoreo de salud"));
        ListaProductos.add(new Productos("Televisor LG 4K", "tecnología", 1100.00, "Smart TV 55 pulgadas, 4K Ultra HD"));
        ListaProductos.add(new Productos("Auriculares Sony", "tecnología", 129.99, "Auriculares inalámbricos con cancelación de ruido"));
        ListaProductos.add(new Productos("Camisa azul", "ropa", 24.95, "Camisa de algodón, manga larga"));
        ListaProductos.add(new Productos("Pantalón vaquero", "ropa", 34.99, "Jeans unisex de corte recto"));
        ListaProductos.add(new Productos("Chaqueta de cuero", "ropa", 99.99, "Chaqueta negra, estilo moderno"));
        ListaProductos.add(new Productos("Vestido de fiesta", "ropa", 59.90, "Vestido largo, color rojo"));
        ListaProductos.add(new Productos("Sudadera deportiva", "ropa", 42.00, "Sudadera con capucha, algodón"));
        ListaProductos.add(new Productos("Sillón reclinable", "muebles", 249.99, "Sillón tapizado, mecanismo reclinable"));
        ListaProductos.add(new Productos("Mesa de comedor", "muebles", 150.00, "Mesa rectangular para 6 personas"));
        ListaProductos.add(new Productos("Estante para libros", "muebles", 75.50, "Estante de madera, 5 niveles"));
        ListaProductos.add(new Productos("Cama doble", "muebles", 320.00, "Cama de matrimonio, colchón incluido"));
        ListaProductos.add(new Productos("Silla ergonómica", "muebles", 115.00, "Silla de oficina, respaldo ajustable"));

        connection = DBConnection.getConnection();
        String query = "INSERT INTO productos (nombreProductos,categoriaProdutos,precioProducto)VALUES (?,?,,?)";
        for(Productos producto : ListaProductos) {
            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, producto.getNombreProductos());
                preparedStatement.setString(2, producto.getCategoriaProdutos());
                preparedStatement.setDouble(3, producto.getPrecioProducto());


            } catch (Exception e) {
                System.out.println("Error al conectar a la base de datos" + e.getMessage());

            }
        }
        }
















}
