package DesignPatterns.Creational;

public class Pojo {

	private final String a1;
	private final String a2;
	private final String a3;
	private final String a4;
	private final String a5;
	private final String a6;
	
	
	
	private Pojo(String a1, String a2, String a3, String a4, String a5, String a6) {
		super();
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
		this.a4 = a4;
		this.a5 = a5;
		this.a6 = a6;
	}
	
	public String getA1() {
		return a1;
	}
	public String getA2() {
		return a2;
	}
	public String getA3() {
		return a3;
	}
	public String getA4() {
		return a4;
	}
	public String getA5() {
		return a5;
	}
	public String getA6() {
		return a6;
	}
	
	@Override
	public String toString()
	{
		return "a1= "+a1+" a2= "+a2+" a3= "+a3+" a4= "+a4+" a5= "+a5+" a6= "+a6;
	}
	
	public static class PojoBuilder
	{
		private String a1;
		private String a2;
		private String a3;
		private String a4;
		private String a5;
		private String a6;
		
		public PojoBuilder setA1(String a1) {
			this.a1 = a1;
			return this;
		}
		
		public PojoBuilder setA2(String a2) {
			this.a2 = a2;
			return this;
		}
		
		public PojoBuilder setA3(String a3) {
			this.a3 = a3;
			return this;
		}
		
		public PojoBuilder setA4(String a4) {
			this.a4 = a4;
			return this;
		}
		
		public PojoBuilder setA5(String a5) {
			this.a5 = a5;
			return this;
		}
		
		public PojoBuilder setA6(String a6) {
			this.a6 = a6;
			return this;
		}
		public Pojo build()
		{
			return new Pojo(this.a1,this.a2,this.a3,this.a4,this.a5, this.a6);
		}
	}
}
