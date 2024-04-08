import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServidorChat extends Remote {
    String conectar(Cliente c) throws RemoteException;
    void enviar(String mensagem) throws RemoteException;
    void desconectar(Cliente c) throws RemoteException;
}
