package workSelenium;

public class StringBufferWork {

	public static void main(String[] args){
		StringBuffer hh = new StringBuffer("Hey");
		System.out.println(hh.length());
		hh.insert(3, "X");
		System.out.println(hh.capacity());
		//hh.append(" Hello");
		hh.append(" Tree");
		System.out.println(hh);
	}
}
