package modelo;

public class Persona {
	private int id;
	private String nombre;
	private byte edad;
	private long identificacion;
	private String correo;
	private long telefono;
	
	public Persona() {
		
	}

	public Persona(int id, String nombre, byte edad, long identificacion, String correo, long telefono) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.identificacion = identificacion;
		this.correo = correo;
		this.telefono = telefono;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte getEdad() {
		return edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}

	public long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(long identificacion) {
		this.identificacion = identificacion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", identificacion=" + identificacion
				+ ", correo=" + correo + ", telefono=" + telefono + "]";
	}
}
