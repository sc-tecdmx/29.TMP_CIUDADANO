package mx.gob.tecdmx.directorio_ciudadano.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jel_ciudadano", schema = "public")
public class Ciudadano {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "n_id_ciudadano", unique = true, nullable = false)
	int  id;
	
	@Column(name = "n_id_usuario")
	Integer idUsuario;
	
	@Column(name = "s_curp")
	String  curp;
	
	@Column(name = "s_rfc")
	String  rfc;
	
	@Column(name = "nombre")
	String  nombre;
	
	@Column(name = "apellido1")
	String  apellido1;
	
	@Column(name = "apellido2")
	String  apellido2;
	
	@Column(name = "email")
	String  email;
	
	@Column(name = "fh_nac")
	Date  fhNac;
	
	@Column(name = "sexo")
	String  sexo;
	
	@Column(name = "telefono")
	String  telefono;
	
	@Column(name = "calle_numero")
	String  calleNumero;
	
	@Column(name = "colonia")
	String  colonia;
	
	@Column(name = "cp")
	String  cp;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_entidad_federativa", referencedColumnName="n_id_entidad_federativa")
	EntidadFederativa  entidadFederativa;
	
	@Column(name = "ciudad")
	String  ciudad;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_tipo_identificacion", referencedColumnName="n_id_tipo_identificacion")
	TipoIdentificacion  tipoIdentificacion;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="n_id_tipo_solicitud", referencedColumnName="n_id_tipo_solicitud")
	TipoSolicitud  tipoSolicitud;
	
	@Column(name = "institucion")
	String institucion;
	
	@Column(name = "aceptacion_terminos_uso")
	boolean  aceptacionTerminosUso;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public EntidadFederativa getEntidadFederativa() {
		return entidadFederativa;
	}

	public void setEntidadFederativa(EntidadFederativa entidadFederativa) {
		this.entidadFederativa = entidadFederativa;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public TipoSolicitud getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
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


}