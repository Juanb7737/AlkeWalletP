package model;

public class Cuenta {
	private int idcuenta;
	private double saldo;
	private String banco;
	private int numcuenta;
	private Cliente cliente;
	private String run_cliente;

	public Cuenta( double saldo, String banco, int numcuenta, Cliente cliente, String run_cliente) {
		super();
		this.idcuenta = idcuenta;
		this.saldo = saldo;
		this.banco = banco;
		this.numcuenta = numcuenta;
		this.cliente = cliente;
		this.run_cliente = run_cliente;
	}
	public Cuenta(int idcuenta, double saldo, String banco, int numcuenta, Cliente cliente, String run_cliente) {
		super();
		this.idcuenta = idcuenta;
		this.saldo = saldo;
		this.banco = banco;
		this.numcuenta = numcuenta;
		this.cliente = cliente;
		this.run_cliente = run_cliente;
	}
	public String getRun_cliente() {
		return run_cliente;
	}	
	public void setRun_cliente(String run_cliente) {
		this.run_cliente = run_cliente;
	}
	public Cuenta() {
		super();
	}
	public int getIdcuenta() {
		return idcuenta;
	}
	public void setIdcuenta(int idcuenta) {
		this.idcuenta = idcuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public int getNumcuenta() {
		return numcuenta;
	}
	public void setNumcuenta(int numcuenta) {
		this.numcuenta = numcuenta;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
 
}
