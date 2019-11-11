import java.util.ArrayList;

public class InternetProxy implements InternetInterface{

	int limite = 100;
	ArrayList<String> paginasRestringidas;
	InternetManager servicio;
	
	public InternetProxy() {
		this.paginasRestringidas = new ArrayList<String>();
		this.servicio = new InternetManager();
	}
	
	@Override
	public String acceder(int idRegistro, String pagina) {
		servicio.verificar(idRegistro);
		
			if(this.servicio.registros.get(idRegistro).size()<limite) {
				System.out.print(this.servicio.registros.get(idRegistro).size());
				if(!this.paginasRestringidas.contains(pagina)) {
					return servicio.acceder(idRegistro, pagina);
				}else {
					return ("La página que está intentando acceder no está permitida");
				}
			}else {
				return ("Usted ha exedido el límite de páginas que puede acceder");
			}
		
	}
	
	public void agregarRestriccion(String restriccion) {
		this.paginasRestringidas.add(restriccion);
	}

}
