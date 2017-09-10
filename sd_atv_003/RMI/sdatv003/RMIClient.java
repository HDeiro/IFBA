package sdatv003;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {
    
    static String SERVER_IP = "127.0.0.1";
    
    public static void main(String[] args) {
        try {
            Conta conta_rmi = (Conta) Naming.lookup("//" + SERVER_IP + "/conta");
            
            //Executando métodos remotos
            System.out.println("Depositando");
            double valor_depositado = conta_rmi.depositar(300);
            System.out.println("Foi depositado o valor de " + valor_depositado);
            
            System.out.println("Sacando");
            double valor_sacado = conta_rmi.sacar(200);
            System.out.println("Houve um saque. Seu saldo agora é " + valor_sacado);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            ex.printStackTrace();
        }
        
    }
}
