package mx.gob.tecdmx.directorio_ciudadano.api.ciudadano;

import java.util.Date;

public class CiudadanoPayload {
	int idUsuario;
	String nombre;
	String apellido1;
	String apellido2;
	Date fhNac;
	String sexo;
	String telefono;
	String calleNumero;
	String colonia;
	String cp;
	int entidadFederativa;
	String ciudad;
	String email;
	String contrasenia;
	int tipoSolicitud;
	String institucion;
	boolean aceptacionTerminosUso;
	
	//Este campo no se pide en la patalla de registro de usuario pero lo dejo porque si se pedirá en otros lados
	String curp;
	String rfc;
	String tipoIdentificacion;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public Date getFhNac() {
		return fhNac;
	}
	public void setFhNac(Date fhNac) {
		this.fhNac = fhNac;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCalleNumero() {
		return calleNumero;
	}
	public void setCalleNumero(String calleNumero) {
		this.calleNumero = calleNumero;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public int getEntidadFederativa() {
		return entidadFederativa;
	}
	public void setEntidadFederativa(int entidadFederativa) {
		this.entidadFederativa = entidadFederativa;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public int getTipoSolicitud() {
		return tipoSolicitud;
	}
	public void setTipoSolicitud(int tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}
	public String getInstitucion() {
		return institucion;
	}
	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}
	public boolean isAceptacionTerminosUso() {
		return aceptacionTerminosUso;
	}
	public void setAceptacionTerminosUso(boolean aceptacionTerminosUso) {
		this.aceptacionTerminosUso = aceptacionTerminosUso;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}
