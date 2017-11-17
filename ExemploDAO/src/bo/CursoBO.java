package bo;

import beans.Curso;
import dao.CursoDAO;
import excecao.Excecao;

public class CursoBO {
	
	
	public String gravarCurso(Curso curso) {
	
		if (curso.getNomeCurso().length()<10) {
			return "Nome de curso muito pequeno";			
			
		} else {
			try {
				CursoDAO cursoDAO = new CursoDAO();
				return cursoDAO.gravarCurso(curso);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(Excecao.tratarExcecao(e));
			}
			
		}
	return null;
	}

}
