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
		//camara.setTorre(1);
		//camara.setPiso(3);
		camara.agregarVisualizado(inquilinoId);
	}
	
	@Test
	public void buscarInquilinoTest(){
		Camara camaraTest = centroMando.buscarInquilino(inquilinoId);
		String resultado = camaraTest.getEstado();
		String respuesta = camara.getEstado();
		assertEquals(resultado, respuesta);
	}
}
