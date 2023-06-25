package model.entiry;

import dao.ProdutoDAO;

public class Veiculo{
	private String placa;
	private String modelo;
	private String marca;
	private double  valor;
	private String numeroChassi;
	private int id;
	
	public Veiculo(String numeroChassi, String placa, String modelo, double valor, String marca) {
		super();
		this.numeroChassi = numeroChassi;
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id; }
		
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void Marca(String marca) {
		this.marca = marca;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNumeroChassi() {
		return numeroChassi;
	}

	public void setNumeroChassi(String numeroChassi) {
		this.numeroChassi = numeroChassi;
	}
	public void inserir() {
		System.out.println("Carro");
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.inserir(this);
	}
	public Veiculo(){
		
	}
}	