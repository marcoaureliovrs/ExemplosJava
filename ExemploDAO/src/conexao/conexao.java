package conexao;

import java.sql.Connection;

import java.sql.DriverManager;

public class conexao{	
	public Connection connect() throws Exception {		
		return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","xxxxxx","xxxxx");
		
		/**
		 * TB_EXER_CURSO			TB_EXER_DISCIPLINA
		 * CD_CURSO				CD_DISCIPLINA
		 * NM_CURSO				NM_DISCIPLINA
		 * VL_CURSO				QT_CARGAHORARIA
		 * DS_TITULACAO			FK_CURSO
		 */

	}
}