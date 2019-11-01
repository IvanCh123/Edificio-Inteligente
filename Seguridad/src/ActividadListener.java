import java.util.ArrayList;

public interface ActividadListener{
	
	ArrayList<String> logs = new ArrayList<String>();

	void update(String evento, int id);
	
}