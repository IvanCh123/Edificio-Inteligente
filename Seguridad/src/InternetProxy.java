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
				if(!this.paginasRestringidas.contains(pagina)) {
					return servicio.acceder(idRegistro, pagina);
				}else {
					System.out.print("La página " +pagina+" no está permitida. \n");
					return ("La página que está intentando acceder no está permitida");
				}
			}else {
				System.out.print("Usted ha exedido el límite de páginas que puede acceder. \n");
				return ("Usted ha exedido el límite de páginas que puede acceder");
			}
		
	}
	
	public void agregarRestriccion(String restriccion) {
		this.paginasRestringidas.add(restriccion);
	}

}
