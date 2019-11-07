import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SeguridadTest{
	//Variables para testeo
	SistemaSeguridad centroMando;
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
	
}
