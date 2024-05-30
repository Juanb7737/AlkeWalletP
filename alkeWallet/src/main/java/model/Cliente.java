package model;

public class Cliente {
	private String run_cliente;
	private String nombre1;
	private String nombre2;
	private String apellidopaterno;
	private String apellidomaterno;
	public Cliente(String run_cliente, String nombre1, String nombre2, String apellidopaterno, String apellidomaterno) {
		super();
		this.run_cliente = run_cliente;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellidopaterno = apellidopaterno;
		this.apellidomaterno = apellidomaterno;
	}
	public Cliente() {
		super();
	}
	public String getRun_cliente() {
		return run_cliente;
	}
	public void setRun_cliente(String run_cliente) {
		this.run_cliente = run_cliente;
	}
	public String getNombre1() {
		return nombre1;
	}
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}
	public String getNombre2() {
		return nombre2;
	}
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	public String getApellidopaterno() {
		return apellidopaterno;
	}
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	public String getApellidomaterno() {
		return apellidomaterno;
	}
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}
	
 
}
