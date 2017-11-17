package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Curso;
import conexao.conexao;

public class CursoDAO {

	private Connection con;	
	private PreparedStatement stmt;	
	private ResultSet rs;	
	
	//metodo abrir e fechar o concexao padrao sempre tem
	public CursoDAO()throws Exception{		
		con = new conexao().connect();	
	}	
	public void fechar()throws Exception{		
		con.close();	
	}
	
	
	public String gravarCurso(Curso curso) throws Exception {
		
		stmt = con.prepareStatement("INSERT INTO TB_EXER_CURSO2"
				+ "(CD_CURSO,"
				+ "NM_CURSO,"
				+ "VL_CURSO,"
				+ "DS_TITULACAO)"
				+ "VALUES (?,?,?,?)");
		
		stmt.setInt(1, curso.getCodCurso());
		stmt.setString(2, curso.getNomeCurso());
		stmt.setDouble(3, curso.getValorCurso());
		stmt.setString(4, curso.getDescTitulacao());
		
		long numLinha = stmt.executeUpdate();
		stmt.close();
		fechar();
		
		
		return numLinha + " Foram inseridas";
	}
	
	/**
	 * 
	 * Na classe CursoDAO, monte um método getCurso() que irá receber o nome do curso como parâmetro e retornar um objeto Curso.
	 * @param nome
	 * @return
	 * @throws Exception
	 */
	public Curso getCurso(String nome) throws Exception {
		Curso curso = new Curso();
		stmt = con.prepareStatement("Select * from TB_EXER_CURSO WHERE NM_CURSO = ?");
		stmt.setString(1, nome);
		
		rs = stmt.executeQuery();
		
		if(rs.next()){
			curso.setCodCurso(rs.getInt("CD_CURSO"));
			curso.setNomeCurso(rs.getString("NM_CURSO"));
			curso.setValorCurso(rs.getDouble("VL_CURSO"));
			curso.setDescTitulacao(rs.getString("DS_TITULACAO"));
		}
		stmt.close();
		fechar();
		
		return curso;
	}
	
	
	public String deletarCurso(String nomeCurso)throws Exception{
		stmt = con.prepareStatement("DELETE FROM TB_EXER_CURSO WHERE NM_CURSO = ?");
		stmt.setString(1, nomeCurso);

		int numLinha = stmt.executeUpdate();
		stmt.close();
		fechar();
		
		return numLinha + "Foram deletados";
	}
	
}
	
	
