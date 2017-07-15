package sd_atv_001;

public class Consumer extends Thread {
    
    Programa a;

    public Consumer(Programa x) {
        a = x;
    }

    public void run() {
        try {
            while (true) {
                while (a.itemCount == 0)
                    sleep(100);
                       
                int item;
                a.sinaleira.down();
                item = (Integer) a.buffer.get(0);
                a.buffer.remove(0);
                a.itemCount--;
                System.out.println("consumer: consuming item "+item+" of "+a.buffer.size());
                for (int i =0;i<10000;i++);
            }
        } catch(InterruptedException e) {
            e.printStackTrace(); 
        }
    }
}