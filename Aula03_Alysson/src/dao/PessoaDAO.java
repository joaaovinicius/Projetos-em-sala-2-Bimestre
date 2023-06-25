package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.entiry.Pessoa;

public class PessoaDAO {

    public void inserir(Pessoa pessoa) {
    	ConectaBD conexao = new ConectaBD();
    	String sql = "INSERT INTO pessoa (nome, email) VALUES (?,?)";
    	try {
    		PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
    		pst.setString(1, pessoa.getNome());
    		pst.setString(2,pessoa.getEmail());
    		pst.execute();
    		System.out.println(pessoa.getNome()+" Inserido");
    	}catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    }

    public Pessoa consultar(int id){
		ConectaBD con = new ConectaBD();
		String sql = "SELECT * FROM pessoa WHERE idpessoa = ?";
    	Pessoa p = null; 
    	try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				p = new Pessoa(nome, email);
				p.setId(rs.getInt("idpessoa"));
			}
			
    	} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    	
    	return p;
    }
    public List<Pessoa> consultarTodos(){
        ConectaBD con = new ConectaBD();
        String sql = "SELECT * FROM pessoa";
        List<Pessoa> lista = new LinkedList<Pessoa>();
        try {
            PreparedStatement pst = con.getConexao().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Pessoa pessoa = new Pessoa(); 
                int id = rs.getInt("idpessoa");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                pessoa.setId(id);
                pessoa.setNome(nome);
                pessoa.setEmail(email);
                lista.add(pessoa);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    public boolean excluir(int chave){
        String sql = "DELETE FROM pessoa WHERE idpessoa = ?";
        try{
            ConectaBD conexao = new ConectaBD();
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, chave);
            int linhas = pst.executeUpdate();
            return linhas>0;

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean atualizar(Pessoa pessoa){
        try {
            String sql = "UPDATE pessoa SET nome = ?, email = ? WHERE idpessoa = ?";
            ConectaBD conexao = new ConectaBD();
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getEmail());
            pst.setInt(3, pessoa.getId());
            int linhas = pst.executeUpdate();
            return linhas>0;            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

