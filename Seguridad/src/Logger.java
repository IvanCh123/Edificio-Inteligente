
public class Logger implements ActividadListener {
	
	@Override
	public void update(String tipo, int id) {
		ActividadListener.logs.add(tipo + " de inquilino: " + id + "\n");
	}
	
	@Override
	public String print() {
		String log = "";
		for(int i = 0; i < ActividadListener.logs.size(); ++i) {
			log += ActividadListener.logs.get(i);
		}
		return log;
	}

}
