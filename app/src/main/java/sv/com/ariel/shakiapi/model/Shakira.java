package sv.com.ariel.shakiapi.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Shakira {

	@SerializedName("albums")
	private List<Albums> albums;

	@SerializedName("name")
	private String name;

	@SerializedName("sucess")
	private String sucess;

	@SerializedName("birth")
	private String birth;

	@SerializedName("url")
	private List<String> url;

	@SerializedName("who")
	private String who;

	public void setAlbums(List<Albums> albums){
		this.albums = albums;
	}

	public List<Albums> getAlbums(){
		return albums;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSucess(String sucess){
		this.sucess = sucess;
	}

	public String getSucess(){
		return sucess;
	}

	public void setBirth(String birth){
		this.birth = birth;
	}

	public String getBirth(){
		return birth;
	}

	public void setUrl(List<String> url){
		this.url = url;
	}

	public List<String> getUrl(){
		return url;
	}

	public void setWho(String who){
		this.who = who;
	}

	public String getWho(){
		return who;
	}

	@Override
 	public String toString(){
		return  name ;
		}
}