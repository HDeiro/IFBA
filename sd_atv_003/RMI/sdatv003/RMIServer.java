package sdatv003;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {
    
    public static void main(String[] args) {
        try {
            // Criando serviço na porta 1099
            LocateRegistry.createRegistry(1099);
            
            Conta conta = new ContaImpl() {
                @Override
                public void listener(String method) {
                    System.out.println("Executando ContaImpl@"+method+" em server-side");
                }
            };
            
            //Exportando objeto a ser enviado
            Conta stub = (Conta) UnicastRemoteObject.exportObject(conta, 0);
            
            //Declarando método no objeto
            Naming.rebind("conta", stub);
            
            System.out.println("Servidor de Contas está pronto para ser utilizado.");
        } catch(MalformedURLException | RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
