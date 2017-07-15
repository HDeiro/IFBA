package sd_atv_001;

import java.util.ArrayList;

public class Programa {
    
    int itemCount;
    int compartilhada;
    ArrayList buffer;
    Semaphore sinaleira;
    
    Programa () {
        itemCount = 0;
        buffer = new ArrayList(); 
        sinaleira = new Semaphore();
    }
    
    public static void main(String[] args) {
        Programa t = new Programa();
        t.run();
    } 
        
    public void run() {
        Consumer c = new Consumer(this);
        Producer p = new Producer(this);
            
        Consumer c1 = new Consumer(this);
        Producer p1 = new Producer(this);
           
            
        p.start();            
        c.start();
        p1.start();
        c1.start();
    }
}