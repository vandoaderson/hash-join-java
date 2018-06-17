import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class HashJoinHeader {
	CsvReader cs1 = new CsvReader("regionH.csv");
	CsvReader cs2 = new CsvReader("nationH.csv");
	
	ArrayList<String> nomeColunas1 = new ArrayList<String>();
	ArrayList<String> nomeColunas2 = new ArrayList<String>();
	HashMap<Integer, ArrayList<String>> bucket1 = new HashMap<Integer, ArrayList<String>>();
	HashMap<Integer, ArrayList<String>> bucket2 = new HashMap<Integer, ArrayList<String>>();
	HashMap<Integer, ArrayList<String>> resultado = new HashMap<Integer, ArrayList<String>>();
	
	public void HashJoinFunction() {
		this.nomeColunas1 = cs1.colunas;
		this.nomeColunas2 = cs2.colunas;
		nomeColunas1.addAll(nomeColunas2);
		this.bucket1 = cs1.bucket;
		this.bucket2 = cs2.bucket;
		
		
		int count = 1;
		
		for (Iterator it1 = bucket1.keySet().iterator(); it1.hasNext();) {
			Object key1 = it1.next();
			for (Iterator it2 = bucket2.keySet().iterator(); it2.hasNext();) {
				Object key2 = it2.next();
				if (key1.equals(Integer.parseInt(bucket2.get(key2).get(2)))) {
					resultado.putIfAbsent(count,new ArrayList<String>());
					resultado.get(count).addAll(bucket1.get(key1));
					resultado.get(count).addAll(bucket2.get(key2));
					count++;
				}
          }
		}
		/*
		for(int i = 1;i < bucket1.size();i++){		
			for(int j = 1;j < bucket2.size();j++) {
				resultado.putIfAbsent(count,new ArrayList<String>());
				resultado.get(count).addAll(bucket1.get(i));
				resultado.get(count).addAll(bucket2.get(j));
				count ++;
			}
			
    		
		}*/
		System.out.println(nomeColunas1);
		for (Iterator it3 = resultado.keySet().iterator(); it3.hasNext();) {
	            Object key3 = it3.next();
	            System.out.println(resultado.get(key3));
	          }
		
		//System.out.println(resultado);					
	}
	public void show() {
		 for (Iterator it3 = resultado.keySet().iterator(); it3.hasNext();) {
	            Object key3 = it3.next();
	            System.out.println(resultado.get(key3));
	          }
	}
	
	
}
