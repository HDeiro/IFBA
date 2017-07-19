package sd_atv_001;

public class Consumer extends Thread {
    
    Programa a;

    public Consumer(Programa x) {
        a = x;
    }

    @Override
    public void run() {
        while (true) {
            a.cheio.down();
            a.sinaleira.down();
            
            int item;
            item = (Integer) a.buffer.get(0);
            a.buffer.remove(0);
            
            a.sinaleira.up();
            a.vazio.up();
            
            
            System.out.println("consumer: consuming item "+item+" of "+a.buffer.size());
        }
    }
}