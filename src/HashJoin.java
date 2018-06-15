import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashJoin {
	String tabela1, tabela2;
    String line = "";
    String[] tabelapart = new String[0];
    
    HashJoin(String tabela1,String tabela2) {
    	this.tabela1 = tabela1;
    	this.tabela2 = tabela2;
    }
    Map<String,Nation> table = new LinkedHashMap<String,Nation>();				//ALTERAR PARA EXEMPLOS
    void run() {
    String desejado = "7";														//ALTERAR PARA EXEMPLOS

    //Criar hashtable
    try (BufferedReader br = new BufferedReader(new FileReader(tabela1))) {

        while ((line = br.readLine()) != null) {
            tabelapart = line.split("\\|");
            System.out.println(Arrays.toString(tabelapart));
            Nation r= new Nation(tabelapart[0],tabelapart[1],tabelapart[2],tabelapart[3]); 	//ALTERAR PARA EXEMPLOS
            table.put(tabelapart[0],r);  
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    
    try (BufferedReader br = new BufferedReader(new FileReader(tabela2))) {	

        while ((line = br.readLine()) != null) {
            tabelapart = line.split("\\|");
            if(tabelapart[3].equals(desejado)) {
            /*											//PARA REGION
                for(Map.Entry<String, Region> entry:table.entrySet()){    	//ALTERAR PARA EXEMPLOS
                	String key=entry.getKey();  
                    Region reg=entry.getValue();							//ALTERAR PARA EXEMPLOS
                    if(entry.getKey().equals(tabelapart[2])) {				//ALTERAR PARA EXEMPLOS
                    	System.out.println(key+" Details:");  
                    	System.out.println(reg.id+" "+reg.name+" "+reg.comment);   //ALTERAR PARA EXEMPLOS
                    	System.out.println(Arrays.toString(tabelapart));
                    	break;
                    }
                    
                }   
              */  
                for(Map.Entry<String, Nation> entry:table.entrySet()){    	//ALTERAR PARA EXEMPLOS
                	String key=entry.getKey();  
                    Nation nat=entry.getValue();							//ALTERAR PARA EXEMPLOS
                    if(entry.getKey().equals(tabelapart[3])) {				//ALTERAR PARA EXEMPLOS
                    	System.out.println("Tabela1:");  
                    	System.out.println(nat.id+", "+nat.name+", "+nat.regionkey+", "+nat.comment);   //ALTERAR PARA EXEMPLOS
                    	System.out.println("Tabela2:");
                    	System.out.println(Arrays.toString(tabelapart));
                    	System.out.println("");
                    	break;
                  	}
                    
                } 
            }
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    
    /* Print da hashtable
    for(Map.Entry<String, Nation> entry:table.entrySet()){    
        String key=entry.getKey();  			//ALTERAR PARA EXEMPLOS
        Nation reg=entry.getValue();  			//ALTERAR PARA EXEMPLOS
        System.out.println(key+" Details:");  
        System.out.println(reg.id+" "+reg.name+" "+reg.comment);   
    }    */
}
}

