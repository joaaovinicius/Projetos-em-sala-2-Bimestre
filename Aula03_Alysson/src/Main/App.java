package Main;

import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import dao.PessoaDAO;
import dao.ProdutoDAO;
import model.entiry.Pessoa;
import model.entiry.Veiculo;

public class App {
	public static String leString(String msg) {
		String valor = JOptionPane.showInputDialog(null, msg);
		return valor;
				
}
	
	public static int menu() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("MENU\n");
	    System.out.println("1- Pessoa");
	    System.out.println("2- Produto"); 
	    System.out.println("0- Sair\n");
	    System.out.println("Digite: ");
		return teclado.nextInt();
	    
	}
	public static int MenuProduto(){
		Scanner teclado = new Scanner(System.in);
		System.out.println("MENU PRODUTO\n");
	    System.out.println("1- Inserir");
	    System.out.println("2- Listar todos");
	    System.out.println("3- Listar por id");
	    System.out.println("4- Excluir por id");
	    System.out.println("5- Atualizar");
	    System.out.println("6- Sair\n");
	    System.out.print("Digite: ");
		
		return teclado.nextInt();
	}
	
	public static int MenuPessoa(){
		Scanner teclado = new Scanner(System.in);
		System.out.println("MENU PESSOA\n");
	    System.out.println("1- Inserir");
	    System.out.println("2- Listar todos");
	    System.out.println("3- Listar por id");
	    System.out.println("4- Excluir por id");
	    System.out.println("5- Atualizar");
	    System.out.println("6- Sair\n");
	    System.out.print("Digite: ");
		
		return teclado.nextInt();
	}
	public static void metodoInserir() {
		String nome = leString("Digite nome:");
		String email = leString("Digite e-mail:"); 
		Pessoa pessoa = new Pessoa(nome,email);
		PessoaDAO pessoaDAO01 = new PessoaDAO();
		pessoaDAO01.inserir(pessoa);
		
	}
	
	public static void metedoInserirProduto() {
		String Chassi = leString("Digite número Chassi: ");
		String Placa = leString("Digite a Placa: ");
		String Modelo = leString("Digite o Modelo: ");
		String marca = leString("Digite Marca: ");
		String Valor = leString("Digite o Valor: ");
		double doubleValor = Double.parseDouble(Valor);
		Veiculo veiculo01 = new Veiculo(Chassi, Placa, Modelo, doubleValor, marca);
		
		
		ProdutoDAO produto01 = new ProdutoDAO();
		produto01.inserir(veiculo01);
		
	}
	
	public static void metodoConsultarTodos() {
		List<Pessoa> registro = new PessoaDAO().consultarTodos();
		if (!registro.isEmpty()) {
			String saida = "";
			saida += ("id\t Nome\t E-mail\n");
		 for (int i = 0; i < registro.size(); i++) {
			 Pessoa p = registro.get(i);
			 saida += p.getId()+"\t";
			 saida += p.getNome()+"\t";
			 saida += p.getEmail()+"\n";
		 }
		JOptionPane.showMessageDialog(null, new JTextArea (saida));
	}else{
		System.out.println("Não tem registros!");
	}
	}
	
	public static void metodoConsultarProdutos() {
		List<Veiculo> registro = new ProdutoDAO().ConsultarTodos();
		if (!registro.isEmpty()) {
			String saida = "";
			saida += ("id\t NumeroChassi\t Placa \t Modelo \t Marca \t Valor\n");
		 for (int i = 0; i < registro.size(); i++) {
			 Veiculo v = registro.get(i);
			 saida += v.getId()+"\t";
			 saida += v.getNumeroChassi()+"\t";
			 saida += v.getPlaca()+"\t";
			 saida += v.getModelo()+"\t";
			 saida += v.getMarca()+"\t";
			 saida += v.getValor()+"\n";
		 }
		JOptionPane.showMessageDialog(null, new JTextArea (saida));
		
	     
	}else{
		System.out.println("Não tem registros!");
	}
	}
	
	
	public static Veiculo metodoConsultarIdVeiculo(){
		String idStr = leString("Digite id: ");
	     
        int id = Integer.parseInt(idStr);
        ProdutoDAO dao = new ProdutoDAO();
        Veiculo v = dao.consultar(id);
		return v;
		
	}
	
	public static void metodoExcluir() {
        String tmp = leString("Digite id para excluir: ");
        int id = Integer.parseInt(tmp); 
        PessoaDAO dao = new PessoaDAO();
        if (dao.excluir(id)){
            JOptionPane.showMessageDialog(null, "Registro " +id + " Excluído!!");
        }else{
            JOptionPane.showMessageDialog(null, "Registro " +id + " Não inexistente!!");
        }
    }
	
    public static Pessoa metodoConsultarId() {
        String idStr = leString("Digite id");
     
        int id = Integer.parseInt(idStr);
        PessoaDAO dao = new PessoaDAO();
        Pessoa p = dao.consultar(id);
        return p;       
    }

    public static void metodoAtualizar(Pessoa p) {
        String nomeAntigo = p.getNome();
        String emailAntigo = p.getEmail();
        String novoNome = leString("Alterar nome: "+ nomeAntigo);
        String novoEmail = leString("Alterar email: "+ emailAntigo);
        p.setNome(novoNome);
        p.setEmail(novoEmail);
        PessoaDAO dao = new PessoaDAO();
        dao.atualizar(p);
    }
    
    public static void metodoExcluirProduto() {
        String tmp = leString("Digite id para excluir");
        int id = Integer.parseInt(tmp); 
        ProdutoDAO dao = new ProdutoDAO();
        if (dao.excluir(id)){
            JOptionPane.showMessageDialog(null, "Registro " +id + " Excluido");
        }else{
            JOptionPane.showMessageDialog(null, "Registro " +id + " Não existe");
        }
    }
    
    public static void metodoAtualizarProduto(Veiculo v) {
        String ChassiAntigo = v.getNumeroChassi();
        String PlacaAntiga = v.getPlaca();
        String ModeloAntigo = v.getModelo();
        String MarcaAntiga = v.getMarca();
        double DoubleValorAntigo = v.getValor();
        String valorAntigo = String.valueOf(DoubleValorAntigo);
        String novoChassi = leString("Alterar Número de Chassi "+ ChassiAntigo);
        String novaPlaca = leString("Alterar Placa " + PlacaAntiga);
        String novoModelo = leString("Alterar Modelo " + ModeloAntigo);
        String novaMarca = leString("Alterar Marca " + MarcaAntiga);
        String StrNovoValor = leString("Alterar Valor " + valorAntigo);
        double NovoValor = Double.parseDouble(StrNovoValor);
        
        v.setNumeroChassi(novoChassi);
        v.setPlaca(novaPlaca);
        v.setModelo(novoModelo);
        v.setMarca(novaMarca);
        v.setValor(NovoValor);

        ProdutoDAO dao = new ProdutoDAO();
        dao.atualizar(v);
        JOptionPane.showMessageDialog(null, "Registro Atualizado com Sucesso!");
    }
    
	public static void main(String[] args) {
		int op;
		 
		do {
			op = menu();
		switch(op) {
		case 1:{
			do {
				 op = MenuPessoa();
			switch(op) {
			case 1:
				metodoInserir();
				break;
			case 2:
				metodoConsultarTodos();
				break;
			case 3:
				String idStr = leString("Digite id: ");
				int id = Integer.parseInt(idStr);
				PessoaDAO dao = new PessoaDAO();
				Pessoa pess = dao.consultar(id);
				String saida;
				if (pess != null) {
					saida = "id\tnome\temail\n";
					saida += pess.getId()+"\t";
					saida += saida + pess.getNome()+"\t";
					saida += pess.getEmail()+"\n";
				}else {
					saida = "Registro não localizado";
				}
				JOptionPane.showMessageDialog(null, new JTextArea(saida));
				break;
			   case 4:
	               metodoExcluir();
	               break;
	           case 5:
	        	   Pessoa p = metodoConsultarId();
                   if (p !=null){
                       metodoAtualizar(p);
                   }else{
                       System.out.println("Registro não encontrado");
                   }                  

                   break;
	           case 6:
	               System.out.println("Saindo!");
	               break;
	           default:
	               System.out.println("Opcão inválida");
	       }
	   }while(op!=6);	
			
		}case 2:{
			
			do {
				op = MenuProduto();
				switch (op) {
				case 1: {
					metedoInserirProduto();
					break;
				}case 2:{
					metodoConsultarProdutos();
					break;
					
				}case 3:{
					String idStr = leString("Digite id: ");
				int id = Integer.parseInt(idStr);
				ProdutoDAO dao = new ProdutoDAO();
				Veiculo veiculo = dao.consultar(id);
				String saida = null;
				saida += ("id\t NumeroChassi\t Placa \t Modelo \t Marca \t Valor\n");
				if (veiculo != null) {
					saida += veiculo.getId()+"\t";
					saida = saida + veiculo.getNumeroChassi()+"\t";
					saida = saida + veiculo.getPlaca()+"\t";
					saida = saida + veiculo.getModelo()+"\t";
					saida = saida + veiculo.getMarca()+"\t";
					saida = saida + veiculo.getValor()+"\n";
					
				}else {
					saida = "Registro não localizado!!";
				}
					
				JOptionPane.showMessageDialog(null, new JTextArea(saida));
					break;
				}case 4:{
					metodoExcluirProduto();
					break;
				}case 5:{
					 Veiculo v = metodoConsultarIdVeiculo();
	                   if (v !=null){
	                	   metodoAtualizarProduto(v);
	                   }else{
	                       System.out.println("Registro não encontrado");
	                   }break;
				}case 6:
		               System.out.println("Saindo!!!");
		               break;
		           default:
				
					 System.out.println("Opcao invalida");
				}	
			} while (op!=6);
		}default:
			
			 System.out.println("Opcão inválida\n");
	}			
		}while(op!=0);
		
		
}
}
