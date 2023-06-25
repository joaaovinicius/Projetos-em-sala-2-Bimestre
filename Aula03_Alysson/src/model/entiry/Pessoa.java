package model.entiry;

import dao.PessoaDAO;

public class Pessoa {
	
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
	
	public Pessoa(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void inserir() {
		System.out.println("Pessoa");
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.inserir(this);
	}

	private int id;
	private String nome;
	private String email;
}