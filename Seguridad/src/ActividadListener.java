import java.util.ArrayList;

public interface ActividadListener{
	
	ArrayList<String> logs = new ArrayList<String>();
	
	void registrarEntrada();
	void registrarSalida();
	
}