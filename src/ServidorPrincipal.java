import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorPrincipal {
    public static void main(String[] args) {
        try {
            int porta = 53974; // Porta desejada
            LocateRegistry.createRegistry(porta); // Cria o registro RMI na porta desejada
            ServidorChat servidor = new ServidorImpl();
            Naming.rebind("rmi://localhost:" + porta + "/Servidor", servidor); // Vincula o servidor à porta desejada
            System.out.println("Servidor pronto");
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.getMessage());
        }
    }
}
