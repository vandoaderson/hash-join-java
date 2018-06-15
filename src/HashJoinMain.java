

public class HashJoinMain {

	public static void main(String[] args) {
		String tabela1 = "nation.csv2";
		String tabela2 = "supplier.csv";
	
		HashJoin hj = new HashJoin(tabela1, tabela2);
		
		HashJoinHeader Hjh1 = new HashJoinHeader();
		
		
		Hjh1.cs1.run();
		Hjh1.cs2.run();
		Hjh1.cartesiano();
		//hj.run();
}
}