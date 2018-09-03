package sv.com.ariel.shakiapi.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Albums {

	@SerializedName("Year")
	private int year;


	@SerializedName("name")
	private String name;

	@SerializedName("Songs")
	private List<String> songs;

	public void setYear(int year){
		this.year = year;
	}

	public int getYear(){
		return year;
	}

	public void setSongs(List<String> songs){
		this.songs = songs;
	}

	public List<String> getSongs(){
		return songs;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}


	@Override
 	public String toString(){
		return name;
		}
}