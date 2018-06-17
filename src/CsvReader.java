import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedMap;

public class CsvReader {

 

	private String arquivoCSV;
	ArrayList<String> colunas = new ArrayList<String>();
	HashMap<Integer, ArrayList<String>> bucket = new HashMap<Integer, ArrayList<String>>();
	
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
	            while(tam > 0) {
	            	if(count == 0) {
	            		colunas.add(dados[dados.length-tam]);
	            		tam--;
	            	}else {
	            		bucket.putIfAbsent(Integer.parseInt(dados[0]),new ArrayList<String>());
	            		bucket.get(Integer.parseInt(dados[0])).add(dados[dados.length-tam]);
	            		//map.putIfAbsent(header.get(dados.length-tam),new ArrayList<String>());
	            		//map.get(header.get(dados.length-tam)).add(dados[dados.length-tam]);
	                tam--;
	            	 }
	            }
	            //System.out.println();
	            count++;
	        }
	        System.out.println(colunas);
	        /*for (Iterator it = bucket.keySet().iterator(); it.hasNext();) {
	            Object key = it.next();
	            System.out.println(bucket.get(key));
	          }
	        */

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