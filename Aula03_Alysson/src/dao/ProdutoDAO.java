package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.entiry.Pessoa;
import model.entiry.Veiculo;

public class ProdutoDAO {


    public void inserir(Veiculo veiculo) {
    	ConectaBD conexao = new ConectaBD();
    	String sql = "INSERT INTO veiculo (numeroChassi, placa, modelo, marca, valor) VALUES (?,?,?,?,?)";
    	try {
    		PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
    		pst.setString(1, veiculo.getNumeroChassi());
    		pst.setString(2, veiculo.getPlaca());
    		pst.setString(3, veiculo.getModelo());
    		pst.setString(4, veiculo.getMarca());
    		pst.setDouble(5, veiculo.getValor());
    		pst.execute();
    		System.out.println(veiculo.getMarca()+" Inserido");
    	}catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    public Veiculo consultar(int id){
		ConectaBD con = new ConectaBD();
		String sql = "SELECT * FROM veiculo WHERE idVeiculo = ?";
    	Veiculo v = null; 
    	try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String Chassi = rs.getString("numeroChassi");
				String Placa =  rs.getString("placa");
				String Modelo = rs.getString("modelo");
				String marca = rs.getString("marca");
				double Valor = rs.getDouble("valor");
				v = new Veiculo(Chassi, Placa, Modelo, Valor, marca);
				v.setId(rs.getInt("idVeiculo"));
			}
			
    	} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    	
    	return v;
    }
    
    public List<Veiculo>ConsultarTodos(){
        ConectaBD con = new ConectaBD();
        String sql = "SELECT * FROM veiculo";
        List<Veiculo> lista = new LinkedList<Veiculo>();
        try {
            PreparedStatement pst = con.getConexao().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Veiculo veiculo = new Veiculo(); 
                int id = rs.getInt("idVeiculo");
                String Chassi = rs.getString("numeroChassi");
				String Placa =  rs.getString("placa");
				String Modelo = rs.getString("modelo");
				String marca = rs.getString("marca");
				double Valor = rs.getDouble("valor");
               
				veiculo.setId(id);
				veiculo.setNumeroChassi(Chassi);
				veiculo.setPlaca(Placa);
				veiculo.setModelo(Modelo);
				veiculo.setMarca(marca);
				veiculo.setValor(Valor);
                lista.add(veiculo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    public boolean excluir(int chave){
        String sql = "DELETE FROM veiculo WHERE idVeiculo= ?";
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
    
    public boolean atualizar(Veiculo veiculo){
        try {
            String sql = "UPDATE veiculo SET numeroChassi = ?, placa = ?, modelo = ?, marca = ?, valor = ? WHERE idVeiculo = ?";
            ConectaBD conexao = new ConectaBD();
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            pst.setString(1, veiculo.getNumeroChassi());
    		pst.setString(2, veiculo.getPlaca());
    		pst.setString(3, veiculo.getModelo());
    		pst.setString(4, veiculo.getMarca());
    		pst.setDouble(5, veiculo.getValor());
            pst.setInt(6, veiculo.getId());
            int linhas = pst.executeUpdate();
            return linhas>0;            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
