import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class ServidorImpl extends UnicastRemoteObject implements ServidorChat {
    private Vector<Cliente> conectados;
    private Vector<String> mensagens;

    public ServidorImpl() throws RemoteException {
        conectados = new Vector<>();
        mensagens = new Vector<>();
    }

    public String conectar(Cliente c) throws RemoteException {
        conectados.addElement(c);
        // Envie mensagens antigas para o novo cliente conectado
        for (String mensagem : mensagens) {
            c.exibir(mensagem);
        }
        return "Usuário Conectado";
    }

    public void desconectar(Cliente c) throws RemoteException {
        conectados.remove(c);
    }

    public void enviar(String mensagem) throws RemoteException {
        // Armazena a mensagem
        mensagens.add(mensagem);
        // Envia a mensagem para todos os clientes conectados
        for (Cliente cliente : conectados) {
            cliente.exibir(mensagem);
        }
    }
}
