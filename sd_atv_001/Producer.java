package sd_atv_001;

public class Producer extends Thread {
    
    Programa a;
    int contador;
    
    public Producer(Programa x) {
        a = x;
        contador = 0;
    }

    @Override
    public void run() {
        while (true) {
            a.vazio.down();
            a.sinaleira.down();
            
            contador++;
            a.buffer.add(contador);
            
            a.sinaleira.up();            
            a.cheio.up();

            System.err.println("Produtor: produzindo o item " + contador);
        }
    }
}
