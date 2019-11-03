import static org.junit.Assert.*;
import org.junit.Test;

public class DomoticaTest{
	
	@Test
	public void buscarInquilinoTest(){
		int inquilinoId = 1;
		SistemaSeguridad centroMando = SistemaSeguridad.getInstancia();
		Camara camara = new CamaraPasillos();
		centroMando.agregarCamara(camara);
		camara.setTorre(1);
		camara.setPiso(3);
		camara.setDireccion(1);
		camara.agregarVisualizado(inquilinoId);
		Camara camaraTest = centroMando.buscarInquilino(inquilinoId);
		String resultado = camaraTest.getEstado();
		String respuesta = camara.getEstado();
		assertEquals(resultado, respuesta);
	}
}
