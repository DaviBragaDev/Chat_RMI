import java.rmi.Naming;
import java.util.Scanner;

public class ClientePrincipal {
    public static void main(String[] args) {
        try {
            // Conecta-se ao servidor
            ServidorChat servidor = (ServidorChat) Naming.lookup("rmi://localhost:53974/Servidor");

            // Cria o cliente
            Cliente cliente = new ClienteImpl();

            // Conecta o cliente ao servidor
            servidor.conectar(cliente);

            // Cria um scanner para ler as mensagens do usuário
            Scanner scanner = new Scanner(System.in);

            // Loop para enviar mensagens
            while (true) {
                // Obtém a mensagem do usuário
                System.out.print("Digite a mensagem: ");
                String mensagem = scanner.nextLine();

                // Envia a mensagem para o servidor
                servidor.enviar(mensagem);
            }
        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.getMessage());
        }
    }
}
