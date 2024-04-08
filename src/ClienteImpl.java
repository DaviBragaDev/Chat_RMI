import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClienteImpl extends UnicastRemoteObject implements Cliente {
    protected ClienteImpl() throws RemoteException {
        super();
    }

    public void exibir(String mensagem) throws RemoteException {
        System.out.println(mensagem);
    }
}
