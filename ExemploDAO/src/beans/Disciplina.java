package beans;

public class Disciplina {
	private int codDisciplina;
	private String nomeDisciplina;
	private int qtdCargaHoraria;
	
	public Curso curso = new Curso();

	public int getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(int codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public int getQtdCargaHoraria() {
		return qtdCargaHoraria;
	}

	public void setQtdCargaHoraria(int qtdCargaHoraria) {
		this.qtdCargaHoraria = qtdCargaHoraria;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}
