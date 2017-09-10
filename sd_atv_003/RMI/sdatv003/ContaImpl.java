package sdatv003; 

import java.io.Serializable;
import java.rmi.RemoteException;

public abstract class ContaImpl implements Conta, Serializable  {
    
    private String descricao;
    private double saldo;
    
    @Override
    public double sacar(double valor) throws RemoteException {
        listener("Sacando " + valor + " da conta " + descricao);
        return valor <= this.saldo ? (this.saldo -= valor) : 0;
    }

    @Override
    public double depositar(double valor) throws RemoteException {
        listener("Depositando " + valor + " da conta " + descricao);
        return valor > 0 ? (this.saldo += valor) : 0;
    }

    @Override
    public double transferir(double valor, Conta conta) throws RemoteException {
        listener("Transferindo " + valor + " da conta " + this.getDescricao() + " para a conta " + conta.getDescricao());
        
        if(valor > 0) {
            this.sacar(valor);
            conta.depositar(valor);
            return valor;
        }
        
        return 0;
    }
    
    @Override
    public String getDescricao() {
        return this.descricao;
    }
        
    public abstract void listener(String method);
}
