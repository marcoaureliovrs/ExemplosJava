package excecao;

import java.sql.SQLException;

public class Excecao extends Exception{		
	public static String tratarExcecao(Exception e){
		
		if (e instanceof NumberFormatException){			
			return "Numero Invalido";		}
		
		else if(e instanceof SQLException){			
		
			if (e.getMessage().indexOf("invalid username/password")>0){					
			
				return "Usuario ou senha invalidos!";		
				
			}else{			
				return "Erro ao conectar no banco";		
		    }		
		}else{			
			return "Erro desconhecido";		
		}	
 }
}
