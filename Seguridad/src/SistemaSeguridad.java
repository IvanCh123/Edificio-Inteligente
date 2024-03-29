
public class SistemaSeguridad {
	
	private static SistemaSeguridad sistema;
	private CamarasComposite sistemaCamaras;
	private ActividadManager manager;
	private InternetProxy proxy;
	
	private SistemaSeguridad() {
		sistemaCamaras = new CamarasComposite();
		manager = new ActividadManager();
		proxy = new InternetProxy();
	}
	
	public static SistemaSeguridad getInstancia() {
		if(SistemaSeguridad.sistema == null) {
			SistemaSeguridad.sistema = new SistemaSeguridad();
		}
		return SistemaSeguridad.sistema;
	}
	
	public void agregarCamara(Camara camara) {
		this.sistemaCamaras.agregar(camara);
	}
	
	public void agregarConjuntoCamaras(Camara[] camaras) {
		CamarasComposite nuevoConjunto = new CamarasComposite();
		for(int i = 0; i < camaras.length; ++i) {
			nuevoConjunto.agregar(camaras[i]);
		}
		sistemaCamaras.agregar(nuevoConjunto);
	}
	
	public Camara buscarInquilino(int id) {
		Camara camara = sistemaCamaras.buscarVisualizado(id);
		return camara;
	}
	
	public void registrarEntrada(int id) {
		this.manager.notificar("Acceso", "Entrada", id);
	}
	
	public void registrarSalida(int id) {
		this.manager.notificar("Acceso", "Salida", id);
	}
	
	public void agregarAcceso(ActividadListener observer) {
		this.manager.suscribir("Acceso", observer);
	}
	
	public void agregarRestriccion(String restriccion) {
		this.proxy.agregarRestriccion(restriccion);
	}
	
	public String acceder(int idRegistro, String pagina) {
		return this.proxy.acceder(idRegistro, pagina);
	}

}
