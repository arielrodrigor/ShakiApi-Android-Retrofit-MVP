package sv.com.ariel.shakiapi.model;


import com.google.gson.annotations.SerializedName;

public class ShakiraMain {

	@SerializedName("Error")
	private boolean error;

	@SerializedName("Data")
	private Shakira shakira;

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setShakira(Shakira shakira){
		this.shakira = shakira;
	}

	public Shakira getShakira(){
		return shakira;
	}

	@Override
 	public String toString(){
		return 
			"ShakiraMain{" +
			"error = '" + error + '\'' + 
			",shakira = '" + shakira + '\'' +
			"}";
		}
}