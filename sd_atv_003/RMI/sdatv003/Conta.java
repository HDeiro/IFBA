package sdatv003;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Conta extends Remote {
    
    double sacar(double valor) throws RemoteException;
    double depositar(double valor) throws RemoteException;
    double transferir(double valor, Conta conta) throws RemoteException;
    String getDescricao() throws RemoteException;
}