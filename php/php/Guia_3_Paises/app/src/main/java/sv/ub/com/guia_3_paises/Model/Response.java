package sv.ub.com.guia_3_paises.Model;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("extencion")
	private String extencion;

	@SerializedName("poblacion")
	private String poblacion;

	@SerializedName("nombre")
	private String nombre;

	@SerializedName("uri")
	private String uri;

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
		return 
			"Response{" + 
			"extencion = '" + extencion + '\'' + 
			",poblacion = '" + poblacion + '\'' + 
			",nombre = '" + nombre + '\'' + 
			",uri = '" + uri + '\'' + 
			"}";
		}
}