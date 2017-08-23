package DesignPatterns;

public class Main {
	public static void main(String[] args) {
		Pojo pojo = new Pojo.PojoBuilder().setA1("Parth").setA2("Mukeshkumar").setA3("Pandya").build();
		System.out.println(pojo.toString());	
	}
}