package filehandling.in;

import java.io.Serializable;

public class Data  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5981068057757815548L;
	String name;
	int age;
	boolean gender;
	
	public Data(String name, int age, boolean gender) 
	{
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}
	

}
