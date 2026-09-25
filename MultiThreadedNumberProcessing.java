import java.util.Random;

class NumberGenerator extends Thread {
    public void run() {
        Random random = new Random();

        while (true) {
            int num = random.nextInt(10) +1;

            System.out.println("\nThread 1: Generated Number = " + num);

            if (num % 2 == 0) {
                new SquareThread(num).start();
            } else {
                new CubeThread(num).start();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class SquareThread extends Thread {
    int number;

    SquareThread(int number) {
        this.number = number;
    }

    public void run() {
        System.out.println("Thread 2: Square of " + number + " = " + (number * number));
    }
}

class CubeThread extends Thread {
    int number;

    CubeThread(int number) {
        this.number = number;
    }

    public void run() {
        System.out.println("Thread 3: Cube of " + number + " = " + (number * number * number));
    }
}

public class MultiThreadedNumberProcessing {
    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        generator.start();
    }
}
