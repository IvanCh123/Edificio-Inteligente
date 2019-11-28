import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParqueoTest {
	
	TorreParqueo torre;
	Vehiculo suv;
	Vehiculo moto;
	Vehiculo compacto;

	@Before
	public void inicializarVariables() {
		VehiculosFactory suvFactory = new SUVFactory();
		VehiculosFactory motoFactory = new MotocicletaFactory();
		VehiculosFactory compactoFactory = new CompactoFactory();
		this.torre = new TorreParqueo(100, 3, 5);
		this.suv = suvFactory.crear();
		this.compacto  = compactoFactory.crear();
		this.moto = motoFactory.crear();
	}
	
	@Test
	public void testSacarVehiculo() {
		String tiqueteCompacto = this.torre.parquear(compacto);
		String tiqueteMotoc = this.torre.parquear(moto);
		String tiqueteSUV = this.torre.parquear(suv);
		Vehiculo vehiculo1 = this.torre.retirarVehiculo("0-0");
		Vehiculo vehiculo2 = this.torre.retirarVehiculo("0-1");
		Vehiculo vehiculo3 = this.torre.retirarVehiculo("0-2");
		assertEquals(vehiculo1, compacto);
		assertEquals(vehiculo2, moto);
		assertEquals(vehiculo3, suv);
	}
	
	@Test
	public void testParquear() {
		String tiqueteCompacto = this.torre.parquear(compacto);
		String tiqueteMotoc = this.torre.parquear(moto);
		String tiqueteSUV = this.torre.parquear(suv);
		assertEquals(tiqueteCompacto, "0-0");
		assertEquals(tiqueteMotoc, "0-1");
		assertEquals(tiqueteSUV, "0-2");
	}

}
