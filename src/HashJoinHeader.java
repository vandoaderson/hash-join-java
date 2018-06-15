import java.util.ArrayList;
import java.util.HashMap;

public class HashJoinHeader {
	CsvReader cs1 = new CsvReader("part.csv");
	CsvReader cs2 = new CsvReader("partsupp.csv");
	
	ArrayList<String> header1 = new ArrayList<String>();
	ArrayList<String> header2 = new ArrayList<String>();
	HashMap<String, ArrayList<String>> map1 = new HashMap<String, ArrayList<String>>();
	HashMap<String, ArrayList<String>> map2 = new HashMap<String, ArrayList<String>>();
	
	public void cartesiano() {
		this.header1 = cs1.header;
		this.header2 = cs2.header;
		header1.addAll(header2);
		this.map1 = cs1.map;
		this.map2 = cs2.map;
		System.out.println(header1);
		
		for(int i = 0; i<header1.size(); i++) {
			System.out.println(map1.get(header1.get(i)));
		}
	}
	
}
