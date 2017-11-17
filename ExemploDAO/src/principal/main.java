package principal;

import javax.swing.JOptionPane;

import beans.Curso;
import beans.Disciplina;
import bo.DisciplinaBO;
import dao.CursoDAO;
import excecao.Excecao;

public class main {

	public static void main(String[] args) throws Exception {
		
		/**			
		 *	Crie um teste para o método novaDisciplina().
		 */
		
		Disciplina disciplina = new Disciplina();
		DisciplinaBO disciplinaBO = new DisciplinaBO();
		
		disciplina.setNomeDisciplina(JOptionPane.showInputDialog
					("Nome Disciplina"));
		disciplina.setQtdCargaHoraria(Integer.parseInt(JOptionPane.showInputDialog
				("Quantidade de carga horária")));
		disciplina.curso.setNomeCurso(JOptionPane.showInputDialog
					("Nome do Curso"));
		disciplinaBO.novaDisciplina(disciplina);
		
		
	}
	
	
	

	


}
