
public class AireAcondicionadoFactory extends ActuadoresFactory{

	protected Actuador crearActuador()
	{
		return new AireAcondicionado();
	}
}
