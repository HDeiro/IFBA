package jantardosfilosofos;

/**
 *
 * @author Aluno
 */
public class Main {
    public static void main(String[] args) {
        Mesa mesa = new Mesa();
        
        Thread filosofo0 = new Filosofos(0, mesa);
        filosofo0.start();

        Thread filosofo1 = new Filosofos(1, mesa);
        filosofo1.start();

        Thread filosofo2 = new Filosofos(2, mesa);
        filosofo2.start();

        Thread filosofo3 = new Filosofos(3, mesa);
        filosofo3.start();

        Thread filosofo4 = new Filosofos(4, mesa);        
        filosofo4.start();
    }
}