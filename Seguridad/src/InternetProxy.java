import java.util.ArrayList;

public class InternetProxy implements InternetInterface{

	int limite = 100;
	ArrayList<String> paginasRestringidas;
	@Override
	public void acceder(int idRegistro, String pagina) {
		InternetManager servicio = new InternetManager();
		if(servicio.registros.get(idRegistro).size()>=limite) {
			if(!this.paginasRestringidas.contains(pagina)) {
				servicio.acceder(idRegistro, pagina);
			}else {
				System.out.print("La página que está intentando acceder no está permitida");
			}
		}else {
			System.out.print("Usted ha exedido el límite de páginas que puede acceder");
		}
	}
	
	public void agregarRestriccion(String restriccion) {
		this.paginasRestringidas.add(restriccion);
	}
}
