import java.util.ArrayList;
import java.util.HashMap;
public interface ProxyLibreria {
	public HashMap<Integer,ArrayList<String>> conectados();
	public ArrayList<String> sitioRestringidos();
	public void acceder(int sitioId);
}
