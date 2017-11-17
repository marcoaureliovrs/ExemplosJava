package bo;

import beans.Disciplina;
import dao.DisciplinaDAO;
import excecao.Excecao;

public class DisciplinaBO {
	
	/**
	 * Crie a classe DisciplinaBO e um método novaDisciplina() 
	 * que irá invocar o método gravar() que está na classe DisciplinaDAO.	
	 */
	
	public void novaDisciplina(Disciplina disciplina){
		try {
			DisciplinaDAO diciplinaDAO = new DisciplinaDAO();
			System.out.println(diciplinaDAO.gravar(disciplina));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
		
	}

}
