package sd_atv_001;

public class Producer extends Thread {
    
    Programa a;
    int contador;
    
    public Producer(Programa x) {
        a = x;
        contador = 0;
    }

    public void run() {
        try {
            while (true) {
                while (a.itemCount == 10)
                    sleep(100);
                    
                contador ++;
                a.buffer.add(contador);
                a.itemCount++;
                
                System.out.println("Produtor: produzindo o item " + contador);
                for (int i =0;i<10000;i++);
                    
                a.sinaleira.up();
            }
        } catch(InterruptedException e) {
            e.printStackTrace(); 
        }
    }
}
