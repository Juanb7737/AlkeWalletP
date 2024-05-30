package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionBD;
import model.Cuenta;

public class DaoCuenta {

	private Connection conexion = ConexionBD.establecerConexion();

	public DaoCuenta(Connection conexion) {
		this.conexion = conexion;
	};

	public List<Cuenta> obtenerTodos() {
		// public Cuenta( double saldo, String banco, int numcuenta
		String consultaSQL = "SELECT idcuenta, saldo, banco, numcuenta, run_cliente FROM cuenta ";
		List<Cuenta> lista = new ArrayList<Cuenta>();
		try {
			Statement statement = conexion.createStatement();
			ResultSet resultSet = statement.executeQuery(consultaSQL);

			while (resultSet.next()) {

				Cuenta cuenta = new Cuenta();

				int idcuenta = resultSet.getInt("idcuenta");
				double saldo = resultSet.getDouble("saldo");
				String banco = resultSet.getString("banco");
				int numcuenta = resultSet.getInt("numcuenta");
				String run_cliente = resultSet.getString("run_cliente");

				System.out.println("idcuenta: " + idcuenta + ", saldo: " + saldo + ", banco: " + banco + ", numcuenta: "
						+ numcuenta + ", run_cliente: " + run_cliente);

				cuenta.setIdcuenta(idcuenta);
				cuenta.setSaldo(saldo);
				cuenta.setBanco(banco);
				cuenta.setNumcuenta(numcuenta);
				cuenta.setRun_cliente(run_cliente);

				lista.add(cuenta);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			System.err.println("Error al ejecutar la consulta: " + e.getMessage());
		}
		return lista;
	}

	public Double consultarCuentaPorId(int id) {
		String consulta = "SELECT idcuenta, saldo, banco, numcuenta, run_cliente FROM cuenta WHERE idcuenta = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(consulta);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// return new Producto(rs.getInt("id"), rs.getString("name"),
				// rs.getString("price"));
				//System.out.println(new Cuenta(rs.getInt("idcuenta"), rs.getDouble("saldo"), rs.getString("banco"),
						//rs.getInt("numcuenta"), rs.getString("run_cliente")));+
				return rs.getDouble("saldo");
			}
		} catch (SQLException e) {
			System.err.println("Error al consultar el Producto: " + e.getMessage());
		}
		return 0.0;
	}

	public void actualizarSaldo(int id, double saldo) {
		String consulta = "UPDATE cuenta SET saldo = ? WHERE idcuenta = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(consulta);
			ps.setDouble(1, saldo);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("Saldo actualizado correctamente.");
		} catch (SQLException e) {
			System.err.println("Error al actualizar el Saldo: " + e.getMessage());
		}
	}

	/*
	 * public Producto realizarConsulta() {
	 * 
	 * String consultaSQL = "SELECT id, name, price FROM product"; try { Statement
	 * statement = conexion.createStatement(); ResultSet resultSet =
	 * statement.executeQuery(consultaSQL);
	 * 
	 * 
	 * while (resultSet.next()) { int id = resultSet.getInt("id"); String nombre =
	 * resultSet.getString("name"); String precio = resultSet.getString("price");
	 * 
	 * System.out.println("ID: " + id + ", name: " + nombre + ", price: " + precio);
	 * } resultSet.close(); statement.close(); } catch (SQLException e) {
	 * System.err.println("Error al ejecutar la consulta: " + e.getMessage()); }
	 * return null; }
	 * 
	 * public Producto consultarUsuarioPorId(int id) { String consulta =
	 * "SELECT id, name, price FROM product WHERE id = ?"; try { PreparedStatement
	 * ps = conexion.prepareStatement(consulta); ps.setInt(1, id); ResultSet rs =
	 * ps.executeQuery(); if (rs.next()) { // return new Producto(rs.getInt("id"),
	 * rs.getString("name"), rs.getString("price")); System.out.println( new
	 * Producto(rs.getInt("id"), rs.getString("name"), rs.getString("price"))); } }
	 * catch (SQLException e) {
	 * System.err.println("Error al consultar el Producto: " + e.getMessage()); }
	 * return null; }
	 * 
	 * public void insertarProducto(Producto producto) { String consulta =
	 * "INSERT INTO product (name, price) VALUES (?, ?)"; try { PreparedStatement ps
	 * = conexion.prepareStatement(consulta); ps.setString(1, producto.getName());
	 * ps.setString(2, producto.getPrice()); ps.executeUpdate();
	 * System.out.println("Producto creado correctamente."); } catch (SQLException
	 * e) { System.err.println("Error al crear el Producto: " + e.getMessage()); } }
	 * public void actualizarProducto(Producto producto) { String consulta =
	 * "UPDATE product SET name = ?, price = ? WHERE id = ?"; try {
	 * PreparedStatement ps = conexion.prepareStatement(consulta); ps.setString(1,
	 * producto.getName()); ps.setString(2, producto.getPrice()); ps.setInt(3,
	 * producto.getId()); ps.executeUpdate();
	 * System.out.println("Producto actualizado correctamente."); } catch
	 * (SQLException e) { System.err.println("Error al actualizar el Producto: " +
	 * e.getMessage()); } }
	 * 
	 * public void eliminarProducto(int id) { String consulta =
	 * "DELETE FROM product WHERE id = ?"; try { PreparedStatement ps =
	 * conexion.prepareStatement(consulta); ps.setInt(1, id); ps.executeUpdate();
	 * System.out.println("Producto eliminado correctamente."); } catch
	 * (SQLException e) { System.err.println("Error al eliminar el Producto: " +
	 * e.getMessage()); } }
	 */
}
