package AMS;
import java.io.*;
import java.util.Scanner;

public class callerclass
{
	public   int count;
	public   final int[] Address_list = new int[100];
	public   final String[] flight_code_list = new String[100];
	public   Scanner s = new Scanner(System.in);

	public void create_index(String filepath) throws IOException, ArrayIndexOutOfBoundsException {
		count = -1;
		long pos;
		RandomAccessFile file = new RandomAccessFile(filepath, "r");
		pos = file.getFilePointer();
		String s;
		while ((s = file.readLine()) != null) {
			String[] result = s.split("\\|");
			count++;
			flight_code_list[count] = result[0];
			Address_list[count] = (int) pos;
			pos = file.getFilePointer();
		}
		file.close();
		sort_index();
	}
	

	public   void sort_index()throws IOException
	{
		for(int i=0;i<=count;i++)
		{
			for(int j=i+1;j<=count;j++)
			{
				if(flight_code_list[i].compareTo(flight_code_list[j])>0)
				{
					String temp = flight_code_list[i];
					flight_code_list[i] = flight_code_list[j];
					flight_code_list[j] = temp;
					int temp1 = Address_list[i];
					Address_list[i]=Address_list[j];
					Address_list[j]=temp1;
				}
			}
		}
	}
	
	public void insert(String flightcode,String source,String destination,String arrivaltime,String departuretime,String far,String filepath)throws IOException,FileNotFoundException
	{
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File(filepath),true));
		
		String b = flightcode+"|"+source+"|"+destination+"|"+arrivaltime+"|"+departuretime+"|"+far+"|";
		pw.println(b);
		pw.close();
		
	}

	public  String search(String key ,String filepath)throws IOException
	{
		int pos;
		String data="";
		pos = search_index(key);
		
		if(pos!=-1)
			 data =display_record(pos, filepath);
		else
			data="rf";
		return data;
	}
	
	public   int search_index(String key)
	{	
		int low = 0, high = count, mid = 0;
		while(low <= high)
		{
			mid = (low + high)/2;
			if(flight_code_list[mid].equals(key))
				return mid;
			
			if(flight_code_list[mid].compareTo(key)>0)
				high = mid - 1;
			
			if(flight_code_list[mid].compareTo(key)<0)
				low = mid + 1;
		}
		return -1;
	}

	public   String display_record(int pos, String filepath)throws IOException
	{
		RandomAccessFile file = new RandomAccessFile(filepath, "r");
		
		int address = Address_list[pos];
		
		
		file.seek(address);			
		String s = file.readLine();
		
		while(s!=null)
		{
			return s;
			
		}
		file.close();
		return "";
	}

	public   String remove(String key,String filepath)throws IOException
	{
		String dat="";
		
		int pos = search_index(key);
		//System.out.println("search sent and recived");
		if(pos != -1)
		{
			//System.out.println("to del fun");
			dat=delete_from_file(pos, filepath);
			//System.out.println("del data recived ");
		}
		else
			dat="rf";

		return dat;
	}
 
	public   String delete_from_file(int pos, String filepath)throws IOException
	{
		display_record(pos, filepath);
		//System.out.println("request to open");
		RandomAccessFile file = new RandomAccessFile(filepath, "rw");
		//System.out.println("opened sussecful");
			int address= Address_list[pos];
			String del_ch="*";
			file.seek(address);
			file.writeBytes(del_ch);
			System.out.println(" request to read");
			String data = file.readLine();
			//System.out.println("close request");
		file.close();
		//System.out.println("del data sent");
		return data;
	}

	public void book_flight(String name,String age,String gender,String contact,String filepath) throws FileNotFoundException {
		
			PrintWriter pw = new PrintWriter(new FileOutputStream ( new File (filepath),true));
			String b=name+"|"+age+"|"+gender+"|"+contact+"|";
			pw.println(b);
			pw.close();

	}
		public  String[][] view()throws Exception {
			FileReader fr=new FileReader("C:/Users/prem/Desktop/myprojects/fs/FS AMS/flight.txt");
	        BufferedReader br= new BufferedReader(fr);
	        String line;
	        String[][] data = new String[100][100];
	        int i=0;
	  
	        while((line=br.readLine())!=null){
	            String[] result = line.split("\\|");
	            if (!result[0].startsWith("*")) {
	            	data[i][0]=result[0];
	            	data[i][1]=result[1];
	            	data[i][2]=result[2];
	            	data[i][3]=result[3];
	            	data[i][4]=result[4];
	            	data[i][5]=result[5];
	            	i++;
	            }
	        }
	        br.close();
	        fr.close();
	        main.rec=i;
	        return data;
		}

		public String[][] view_booking() throws IOException {
			FileReader fr=new FileReader("C:/Users/prem/Desktop/myprojects/fs/FS AMS/bookings.txt");
	        BufferedReader br= new BufferedReader(fr);
	        String line;
	        String[][] dat = new String[100][100];
	        int i=0;
	  
	        while((line=br.readLine())!=null){
	            String[] result = line.split("\\|");
	            if (!result[0].startsWith("*")) {
	            	dat[i][0]=result[0];
	            	dat[i][1]=result[1];
	            	dat[i][2]=result[2];
	            	dat[i][3]=result[3];
	            	i++;
	            }
	        }
	        br.close();
	        fr.close();
	        main.rec_b=i;
	        return dat;
			
		}
		
		
	}
	


