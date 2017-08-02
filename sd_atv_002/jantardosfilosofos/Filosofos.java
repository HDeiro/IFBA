package jantardosfilosofos;

/**
 *
 * @author Aluno
 */

public class Filosofos extends Thread {
    
    private int cadeira;
    private Mesa mesa;
    private final int delay = 1000;
    
    public Filosofos(int cadeira, Mesa mesa) {
        this.cadeira = cadeira;
        this.mesa = mesa;
    }
    
    @Override
    public void run() {
        while (true) {
            pensar();
            mesa.pegarGarfo(cadeira);
            comer();
            mesa.largarGarfos(cadeira);
            mesa.mostraEstados();
        }
    }
    
    public void pensar() {
        try {
            Thread.sleep((int) (delay * Math.random()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void comer() {
        try {
            Thread.sleep((int) (delay * Math.random()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}