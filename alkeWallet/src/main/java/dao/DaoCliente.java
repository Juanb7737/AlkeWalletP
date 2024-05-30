package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionBD;
import model.Cliente;

public class DaoCliente {
	
    private Connection conexion  = ConexionBD.establecerConexion();

    public DaoCliente(Connection conexion) {
        this.conexion = conexion;
    };
     
    public List<Cliente> obtenerTodos(){
    	//public Cliente(String run_cliente, String nombre1, String nombre2, String apellidopaterno, String apellidomaterno)
    	String consultaSQL = "SELECT run_cliente, nombre1, nombre2, apellidopaterno, apellidomaterno FROM cliente ";
    	List<Cliente> lista = new ArrayList<Cliente>();
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(consultaSQL);

            while (resultSet.next()) {

                Cliente cliente = new Cliente();
                		
                String run_cliente = resultSet.getString("run_cliente");
                String nombre1 = resultSet.getString("nombre1");
                String nombre2 = resultSet.getString("nombre2");
                String apellidopaterno = resultSet.getString("apellidopaterno");
                String apellidomaterno = resultSet.getString("apellidomaterno");
                System.out.println("run_cliente: " + run_cliente + ", nombre1: " + nombre1 + ", nombre2: " + nombre2 + ", apellidopaterno: " + apellidopaterno + ", apellidomaterno: " + apellidomaterno);
                
                cliente.setRun_cliente(run_cliente);
                cliente.setNombre1(nombre1);
                cliente.setNombre2(nombre2);
                cliente.setApellidopaterno(apellidopaterno);
                cliente.setApellidomaterno(apellidomaterno);
                
                 lista.add(cliente);
                
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    	return lista;
    }
    /*
    public Producto realizarConsulta() {
    	
    String consultaSQL = "SELECT id, name, price FROM product";
    try {
        Statement statement = conexion.createStatement();
        ResultSet resultSet = statement.executeQuery(consultaSQL);

         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nombre = resultSet.getString("name");
            String precio = resultSet.getString("price");

            System.out.println("ID: " + id + ", name: " + nombre + ", price: " + precio);
        }
        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        System.err.println("Error al ejecutar la consulta: " + e.getMessage());
    }
	return null;
    }
    
    public Producto consultarUsuarioPorId(int id) {
        String consulta = "SELECT id, name, price FROM product WHERE id = ?";
        try {
        	PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	// return new Producto(rs.getInt("id"), rs.getString("name"), rs.getString("price"));
            	System.out.println( new Producto(rs.getInt("id"), rs.getString("name"), rs.getString("price")));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar el Producto: " + e.getMessage());
        }
        return null;
    }
    
    public void insertarProducto(Producto producto) {
    	  String consulta = "INSERT INTO product (name, price) VALUES (?, ?)";
          try {
        	  PreparedStatement ps = conexion.prepareStatement(consulta);
              ps.setString(1, producto.getName());
              ps.setString(2, producto.getPrice());
              ps.executeUpdate();
              System.out.println("Producto creado correctamente.");
          } catch (SQLException e) {
              System.err.println("Error al crear el Producto: " + e.getMessage());
          }
    }
    public void actualizarProducto(Producto producto) {
        String consulta = "UPDATE product SET name = ?, price = ? WHERE id = ?";
        try
        {
        	PreparedStatement ps = conexion.prepareStatement(consulta);
        	ps.setString(1, producto.getName());
            ps.setString(2, producto.getPrice());
            ps.setInt(3, producto.getId());
            ps.executeUpdate();
            System.out.println("Producto actualizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar el Producto: " + e.getMessage());
        }
    }

    public void eliminarProducto(int id) {
    	  String consulta = "DELETE FROM product WHERE id = ?";
          try {
        	  PreparedStatement ps = conexion.prepareStatement(consulta);
              ps.setInt(1, id);
              ps.executeUpdate();
              System.out.println("Producto eliminado correctamente.");
          } catch (SQLException e) {
              System.err.println("Error al eliminar el Producto: " + e.getMessage());
          }
    }*/
}

