import java.util.ArrayList;

public interface ActividadListener{
	
	ArrayList<String> logs = new ArrayList<String>();

	void update(String tipo, int id);  // El evento acá es entrada o salida
	String print();
}