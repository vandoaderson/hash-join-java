import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;

public class CsvReader {

 

	private String arquivoCSV;
	ArrayList<String> header = new ArrayList<String>();
	HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	
	public CsvReader(String arquivoCSV){
		this.arquivoCSV = arquivoCSV;
	}
	public void run() {

	    BufferedReader br = null;
	    String linha = "";
	    String csvDivisor = "\\|";
	    int tam,count = 0;
	    try {

	        br = new BufferedReader(new FileReader(arquivoCSV));
	        while ((linha = br.readLine()) != null) {

	            String[] dados = linha.split(csvDivisor);
	            tam = dados.length;
	            while(tam >= 1 && count <= 10) {
	            	if(count == 0) {
	            		header.add(dados[dados.length-tam]);
	            		tam--;
	            	}else {
	            		map.putIfAbsent(header.get(dados.length-tam),new ArrayList<String>());
	            		map.get(header.get(dados.length-tam)).add(dados[dados.length-tam]);
	                tam--;
	            	 }
	            }
	            //System.out.println();
	            count++;
	        }
	        System.out.println(header);
	        System.out.println(map);
	        
	        

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	  }

}