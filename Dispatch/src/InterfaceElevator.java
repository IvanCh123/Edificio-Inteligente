
public interface InterfaceElevator {

    public boolean actualizarEstado(ElevatorStatus elevatorStatus);
    
    public void addDestino(int destino);

    public boolean moverElevador();

    public ElevatorDirection getDireccion();

    public ElevatorStatus getEstado();
    
    public int getTotalPedidos();

    public int getDestinoSiguiente();

    public int getPisoActual();
    
    public int getID();
}
