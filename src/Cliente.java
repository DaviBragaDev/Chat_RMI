import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Cliente extends Remote {
    void exibir(String mensagem) throws RemoteException;
}
