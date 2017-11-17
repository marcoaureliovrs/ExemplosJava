package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Curso;
import beans.Disciplina;
import conexao.conexao;

public class DisciplinaDAO {
	private Connection con;	
	private PreparedStatement stmt;	
	private ResultSet rs;
	
	CursoDAO dao = new CursoDAO();
	
	//Metodo abrir e fechar conexao
	public DisciplinaDAO()throws Exception{		
		con = new conexao().connect();	
	}	
	public void fechar()throws Exception{		
		con.close();	
	}
	
	/**
	 * Na classe DisciplinaDAO, monte um método gravar() este método deverá retornar uma String. Dentro do método você deverá verificar se o objeto curso já existe no banco, se existir você utilizará o código do curso e cadastrar apenas a Disciplina, caso contrário, deverá cadastrar o Curso e a Disciplina.
	 * @param disciplina
	 * @return {String}  
	 * @throws Exception
	 * 
	 */
	public String gravar(Disciplina disciplina)throws Exception{
		
		Curso curso = dao.getCurso(disciplina.curso.getNomeCurso());
		if (curso != null) {
			stmt = con.prepareStatement("INSERT INTO TB_EXER_DISCIPLINA"
					+ "(CD_DISCIPLINA,"
					+ "NM_DISCIPLINA,"
					+ "QT_CARGAHORARIA,"
					+ "CD_CURSO)"
					+ "VALUES(?,?,?,?)");
			stmt.setInt(1, disciplina.getCodDisciplina());
			stmt.setString(2, disciplina.getNomeDisciplina());
			stmt.setInt(3, disciplina.getQtdCargaHoraria());	
			stmt.setInt(4, curso.getCodCurso());
			int numLinha = stmt.executeUpdate();
			stmt.close();
			fechar();
			return numLinha + " disciplina inserida";
		}else{
			dao.gravarCurso(disciplina.curso);
			gravar(disciplina);
			return null;
		}
		
	}
	/**
	 * Crie na classe DisciplinaDAO, crie um método chamado getAll(), que deverá receber uma String (nome do curso), e então deverá retornar todas as disciplinas, deste curso. Este método deverá  retornar uma lista de disciplinas.
	 *
	 * @param nomeCurso
	 * @return {ArrayList<String>} resultado;
	 * @throws Exception
	 */
	public ArrayList<String> getAll(String nomeCurso) throws Exception{
		ArrayList resultado = new ArrayList();
		Curso curso = dao.getCurso(nomeCurso);
		
		stmt = con.prepareStatement("SELECT * INTO TB_EXER_DISCIPLINA WHERE FK_CURSO = ?");
		stmt.setInt(1, curso.getCodCurso());
		rs = stmt.executeQuery();
		
		while (rs.next()){
			String NomeDisciplina = rs.getString("NM_DISCIPLINA");
			int CodigoDisciplina = rs.getInt("CD_DISCIPLINA");
			int CargaHoraria = rs.getInt("QT_CARGAHORARIA");
			String total = "nome disciplina: " + NomeDisciplina + "codigo disciplina: " + CodigoDisciplina + "Carga Horaria: " + CargaHoraria;
			resultado.add(total);
		}
		stmt.close();
		fechar();
		return resultado;
	}

}
