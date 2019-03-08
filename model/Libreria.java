
public class Libreria {

	private final static int CANTIDAD_MAXIMA_LIBROS = 500;

	private String nombre;

	private String direccion;

	private String nit;

	private Libro[] libros;

	public Libreria(String nom, String dir, String elNit) {

		nombre = nom;
		direccion = dir;
		nit = elNit;
		libros = new Libro[CANTIDAD_MAXIMA_LIBROS];

	}


	// agregar libro

	public boolean agregarLibro (int dia, int mes, int anho, boolean esNacional,
			int cantidadPaginas, String isbn, String nombre,
			String nombreAutor, boolean editadoUltimoAnho){
		
		boolean seAgrego = false;
		
		Libro nuevoLibro = new Libro(dia, mes, anho, esNacional, cantidadPaginas, isbn, nombre, nombreAutor, editadoUltimoAnho);
		
		for (int i = 0; i < libros.length && !seAgrego; i++) {	
			if (libros[i]==null) {
				libros[i]= nuevoLibro;
				seAgrego = true;
			}
			
		}


		return seAgrego;
	}
	
	//dar libro
	
	public Libro darLibro(int pos){
		Libro librito = null;
		
		if (pos>=0 && pos <CANTIDAD_MAXIMA_LIBROS) {
			
			librito= libros[pos];
		}
		
		return librito;
	}
	
	// esta libro
	
	public boolean estaLibro (String nombre){
		boolean esta = false;
		int indice =0;
		while (indice<CANTIDAD_MAXIMA_LIBROS && !esta) {
			Libro temporal = libros[indice];
			
			if (temporal != null && temporal.darNombre().equals(nombre)) {
				esta= true;
			}
			
			indice++;
		}
		return esta;
	}
	
	
	public int contarNacionales(){
		
		int total = 0;
		
		for(int i=0; i<CANTIDAD_MAXIMA_LIBROS; ++i){
			
			if(libros[i]!= null && libros[i].esNacional()){
				total++;
			}
		}
		
		
		return total;
	}
	
	
	
	public Libro masViejo (){
		
		Libro viejo = null;
		
		int i = 0;
		
		for(;i<libros.length&& viejo==null;i++){
			if(libros[i]!=null){
				 viejo = libros[i];
			}
			
		}
	
		for (; i<libros.length; ++i){
			
			Libro actual = libros[i];
			
			if(actual !=null){	
				if(actual.darAnho() < viejo.darAnho()){
					viejo = actual;
				} else if(actual.darAnho() == viejo.darAnho()
					&& actual.darMes() < viejo.darMes()){
					viejo = actual;
				}else if(actual.darAnho() == viejo.darAnho()
					&& actual.darMes() == viejo.darMes()
					&& actual.darDia()< viejo.darDia()){
					viejo = actual;
				}			
			}
		}
		
		return viejo;
	}
	
	

	/**
	 * @return the nombre
	 */
	public String darNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to modificar
	 */
	public void modificarNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the direccion
	 */
	public String darDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to modificar
	 */
	public void modificarDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the nit
	 */
	public String darNit() {
		return nit;
	}

	/**
	 * @param nit the nit to modificar
	 */
	public void modificarNit(String nit) {
		this.nit = nit;
	}

	/**
	 * @return the libros
	 */
	public Libro[] darLibros() {
		return libros;
	}

	/**
	 * @param libros the libros to modificar
	 */
	public void modificarLibros(Libro[] libros) {
		this.libros = libros;
	}







}
