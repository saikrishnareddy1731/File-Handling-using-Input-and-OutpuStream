package filehandling.in;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class Entry {

	public static void main(String[] args) {
		//writeFile();
		//readFile();
		//printWriter();// this is used to write on the text files.........where we can view the data in the text file.
		 storeObjects();
		// encrypt(); working fine
		// decrypt(); working fine
		 
		 
//		FileInputStream fis=null;
//		ObjectOutputStream fos=null;
//		fis=new FileInputStream()
		
		
		loadObject();
		
		
		
      

	}
	
	private static void storeObjects() 
	{
		Scanner scanner=null;
		FileOutputStream fos=null;
		ObjectOutputStream oss=null;
		
		try {
			
			scanner=new Scanner(System.in);
			System.out.println("Enter the name: ");
			String  name=scanner.next();
			System.out.println("Enter the age: ");
			int age=scanner.nextInt();
			System.out.println("Enter the gender: ");
			boolean gender =scanner.hasNextBoolean();
			Data objData=new Data(name , age ,gender);
			fos=new FileOutputStream("E:\\lpu.\\Text4.txt");// handled by FILENOTFOUNDEXCEPTION
			oss=new ObjectOutputStream(fos);//handled by IOEXCEPTION
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			
				try {
					if(oss!=null)
						oss.close();
					if(fos!=null)
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	
	
	
	private static void loadObject() {
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try {
			fis=new FileInputStream("E:\\lpu.\\Text4.txt");
			ois=new ObjectInputStream(fis);
		   
		    	try {
		    		
		    		 while(true)
		 		      {
					   Object data;
					
						data = ois.readObject();
					
					   Data objData=(Data)data;
					   System.out.println(objData.getName());
					   System.out.println(objData.getAge());
					   System.out.println(objData.isGender());
		 		       }
				   }
		    	
		    	catch (EOFException e)
		    	{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		finally
		{
			
				try {
					if(ois!=null)
						ois.close();
					if(fis!=null)
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	private static void decrypt() 
	{
		File objFile=new File("E:\\lpu.\\Encrypt.txt");
		 FileInputStream fis=null;
		 FileOutputStream fos=null;
	try {
			fis=new FileInputStream(objFile);            //handled by Filenotfoundexception
			fos=new FileOutputStream("E:\\lpu.\\decrypt.txt");
			byte []encryptData=new byte[(int)objFile.length()];//to find data (text) length in a file we use .length(); 
			byte []plainData=new byte[encryptData.length];      //to find data (text) length  we use .length;
			fis.read(encryptData);                         //handled by ioexception 
			for(int i=0;i< encryptData.length;i++)
			{
				plainData[i]=(byte)(encryptData[i]-9);
				
				
			}
			fos.write(plainData);
				
		} 
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	finally
	{
		
			try {
				if(fos!=null)
					fos.close();
				if(fis!=null)
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}


	private static void encrypt() {
		File objFile=new File("E:\\lpu.\\Text3.txt");
		 FileInputStream fis=null;
		 FileOutputStream fos=null;
	try {
			fis=new FileInputStream(objFile);            //handled by Filenotfoundexception
			fos=new FileOutputStream("E:\\lpu.\\Encrypt.txt");
			byte []plainData=new byte[(int)objFile.length()];//to find data (text) length in a file we use .length(); 
			byte []encryptData=new byte[plainData.length];      //to find data (text) length  we use .length;
			fis.read(plainData);                         //handled by ioexception 
			for(int i=0;i< plainData.length;i++)
			{
				encryptData[i]=(byte)(plainData[i]+9);
				
				
			}
			fos.write(encryptData);
				
		} 
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	finally
	{
		
			try {
				if(fos!=null)
					fos.close();
				if(fis!=null)
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}

	

	private static void printWriter() {
		FileOutputStream  fos=null;
		PrintWriter out=null;
		try {
			fos=new FileOutputStream("E:\\lpu.\\Text3.txt");
			out=new PrintWriter(fos);
			
			out.println("public class " +"Abc");
			out.println("{");
			out.println("private int data;");
			out.println("}");
		   } 
		    catch (FileNotFoundException e) 
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		finally
		{
			
				try {
					if(out!=null)
			             out.close();
					    if(fos!=null)
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    
		}
	}

	private static void readFile() {
		FileInputStream fis=null;
		DataInputStream dis=null;
		
		
		try {
			File objFile=new File("E:\\lpu.\\Text1.txt");

				
			fis=new FileInputStream("E:\\lpu.\\Text1.txt");
			dis=new DataInputStream(fis);
			String str=dis.readUTF();
			int age=dis.readInt();
			boolean gender=dis.readBoolean();
			float salary=dis.readFloat();
			System.out.println(str);
			System.out.println(age);
			System.out.println(gender);
			System.out.println(salary);
			
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		finally
		{
			try{	
			if(dis!=null)
				dis.close();
			if(fis!=null)
				fis.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	private static void writeFile() {
		File objFile=new File("E:\\lpu.\\Text1.txt");
//		if(!objFile.exists())
//		{            ====> to create by out self
//			try {
//				objFile.createNewFile();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("Creating directory file");
//		}
		
		
		
//***********by using fileoutputStream it will create file automatically********************
		FileOutputStream  fos=null;
		DataOutputStream dos=null;
		try {
			fos= new FileOutputStream(objFile);
			dos=new DataOutputStream(fos);
			dos.writeUTF("string");
			dos.writeInt(22);
			dos.writeBoolean(true);
			dos.writeFloat(22.56f);
			System.out.println("file writen");
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				if(dos!=null)
					 dos.close();
				 if(fos!=null)
					 fos.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		 
			 
		}
	}

}
