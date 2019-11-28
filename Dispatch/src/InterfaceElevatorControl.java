
public interface InterfaceElevatorControl {

    public boolean actualizarEstado(ElevatorStatus estado, int id);

    public boolean pedido(int desdePiso);

    public void step();
}
