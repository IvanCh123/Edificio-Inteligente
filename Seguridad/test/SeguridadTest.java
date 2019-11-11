import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SeguridadTest{
	//Variables para testeo
	SistemaSeguridad centroMando;
	InternetProxy servicio;
	Camara camara;
	int inquilinoId;

	@Before
	public void inicializarVariables() {
		this.centroMando = SistemaSeguridad.getInstancia();
		this.camara = new CamaraPasillos(1);
		this.centroMando.agregarCamara(camara);
		this.inquilinoId = 1;
		camara.setEstado(new int[] {1,3,2}); // Torre 1, Piso 3, Direccion derecha
		camara.agregarVisualizado(inquilinoId);
		/*PROXY*/
	
		
		this.servicio = new InternetProxy();
		this.servicio.agregarRestriccion("robarbancos.com");
		this.servicio.agregarRestriccion("hackearnasa.com");
		this.servicio.agregarRestriccion("instaurarelcomunismo.com");
	}
	
	@Test
	public void buscarInquilinoTest() {
		Camara camaraTest = centroMando.buscarInquilino(inquilinoId);
		String resultado = camaraTest.getEstado();
		String respuesta = camara.getEstado();
		assertEquals(resultado, respuesta);
	} 
	
	@Test
	public void registroAccesosTest() {
		ActividadListener logger = new Logger();
		this.centroMando.agregarAcceso(logger);
		String log = "Entrada de inquilino: 1"
				+ "\nEntrada de inquilino: 2"
				+ "\nSalida de inquilino: 2"
				+ "\nEntrada de inquilino: 2"
				+ "\nSalida de inquilino: 1\n";
		centroMando.registrarEntrada(1);
		centroMando.registrarEntrada(2);
		centroMando.registrarSalida(2);
		centroMando.registrarEntrada(2);
		centroMando.registrarSalida(1);
		assertEquals(log, logger.print());
	}
	
	@Test
	public void accederPaginaRestringida() {
		String esperado = "La página que está intentando acceder no está permitida";
		String resultado = this.servicio.acceder(0, "robarbancos.com");
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void limiteAccesos() {
		String esperado = "Usted ha exedido el límite de páginas que puede acceder";
		String resultado = "";
		for(int i = 0; i <= 100; i++) {
			resultado = this.servicio.acceder(1, "0");
		}
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void estadoCamarasTest() {
		String estado = "Camara:\n\tTorre: 1\n\tPiso: 3\n\tDireccion: Derecha";
		assertEquals(estado, camara.getEstado());

	}
	
}
