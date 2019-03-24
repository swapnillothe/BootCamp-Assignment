package threading;

class Hii implements Runnable {
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("HIII");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            ;
        }

    }
}


class Hello implements Runnable {
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("HELLLOOOO");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            ;
        }
    }
}

public class Threads {
    public static void main(String[] args) {
        Hii hii = new Hii();
        Hello hello = new Hello();
        Thread t1 = new Thread(hii);
        Thread t2 = new Thread(hello);
        t1.start();
        t2.start();
    }
}
