package workJava;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:MM:SS");
		Date date = new Date(); 
		System.out.println(date.toString()); //seems the best :D
		System.out.println(dateFormat.format(date)); //not so good :(
	}

}
