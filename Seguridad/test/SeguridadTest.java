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
	public void buscarInquilinoTest(){
		Camara camaraTest = centroMando.buscarInquilino(inquilinoId);
		String resultado = camaraTest.getEstado();
		String respuesta = camara.getEstado();
		assertEquals(resultado, respuesta);
	}
}
