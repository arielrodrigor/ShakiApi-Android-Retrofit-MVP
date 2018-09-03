package sv.ub.com.guia_3_paises.Model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class Pais implements Parcelable{

	@SerializedName("extencion")
	private String extencion;

	@SerializedName("poblacion")
	private String poblacion;

	@SerializedName("nombre")
	private String nombre;

	@SerializedName("uri")
	private String uri;

	protected Pais(Parcel in) {
		extencion = in.readString();
		poblacion = in.readString();
		nombre = in.readString();
		uri = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(extencion);
		dest.writeString(poblacion);
		dest.writeString(nombre);
		dest.writeString(uri);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<Pais> CREATOR = new Creator<Pais>() {
		@Override
		public Pais createFromParcel(Parcel in) {
			return new Pais(in);
		}

		@Override
		public Pais[] newArray(int size) {
			return new Pais[size];
		}
	};

	public void setExtencion(String extencion){
		this.extencion = extencion;
	}

	public String getExtencion(){
		return extencion;
	}

	public void setPoblacion(String poblacion){
		this.poblacion = poblacion;
	}

	public String getPoblacion(){
		return poblacion;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return nombre;
	}

	public void setUri(String uri){
		this.uri = uri;
	}

	public String getUri(){
		return uri;
	}

	@Override
 	public String toString(){
		return nombre;
}
}