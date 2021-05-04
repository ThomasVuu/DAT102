package no.hvl.dat102;

public class student {
	private int snr;
	private String navn;
	
	public student(int snr, String navn) {
		this.snr = snr;
		this.navn = navn;
	}
	
	public int hashcode() {
		return Integer.toString(snr).hashCode();
	}
	
	public static void main(String[] args) {
		student a = new student(10, "Ole");
		student b = new student(10, "Ole");
		
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println();
		System.out.println(a.hashcode());
		System.out.println(b.hashcode());
	}
}