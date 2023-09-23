package AMS;
import java.util.*;
import java.io.*;
import java.lang.String;

public class main{
	
	public static callerclass ad = new callerclass();
	public static callerclass booking = new callerclass();
	public static Scanner scan=new Scanner(System.in);
	public static int rec =0;
	public static int rec_b=0;
	public static void create_au_index() throws Exception {
		ad.create_index("C:/Users/prem/Desktop/myprojects/fs/FS AMS/flight.txt");
		booking.create_index("C:/Users/prem/Desktop/myprojects/fs/FS AMS/flight.txt");
	}
}
