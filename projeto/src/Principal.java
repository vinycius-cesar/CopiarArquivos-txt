import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String args[]) throws IOException {
		 
	    	
		final DateFormat df = new SimpleDateFormat("ddMMyyyy");
		final Calendar cal = Calendar.getInstance();
		String dataAtual = (df.format(cal.getTime()));
		
	    	
			
		 File diretorio =     
			      new File("G:\\Planejamento\\01 -PLANEJAMENTO\\11 - Cauê Motta\\03 . Ações\\Incluir");    
		
			 File arquivo = null;    
			 File[] arquivos = null;    
			 FileReader fr = null;    
			 BufferedReader br = null;    
			      
			 String linha = "";    
			 File arquivoDestino =     
			     new File("G:\\Planejamento\\01 -PLANEJAMENTO\\11 - Cauê Motta\\03 . Ações\\Geral\\"+dataAtual+"_marcacao.txt");    
			 FileOutputStream fos = null;    
			 try {    
			     if (diretorio.isDirectory()) {    
			          fos = new FileOutputStream(arquivoDestino); 
			          arquivos = diretorio.listFiles();    
			         for (int i = 0; i < arquivos.length; i++) {    
			             arquivo = arquivos[i];    
			                   
			              fr = new FileReader(arquivo);    
			              br = new BufferedReader(fr);  
			   
			              while ((linha = br.readLine()) != null) {    
			                 fos.write(linha.getBytes());  
			                 fos.write("\n".getBytes()); 
			             }    
			        }    
			     }    
			     
			     if(fos == null) {
			    	 JOptionPane.showMessageDialog(null, "Diretorio não encotrado");
				    }
			     fos.flush();    
			     fos.close();  
			     
			    
			     
			    
			 } catch (FileNotFoundException fnex) { 
				 
			     fnex.printStackTrace();    
			 } catch (IOException ioex) {    
				
			     ioex.printStackTrace();    
			 } 
			
			 JOptionPane.showMessageDialog(null, "Concluido com sucesso");
	}

}