import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        List<String> names = new ArrayList<>();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (names) {
                    names.add("Производитель Toyota выпустил " + i +" авто");
//                    names.notify();

                }
//                try {
//                    Thread.sleep(300);
//                } catch (InterruptedException e) {
//                    return;
//                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (names) {
                    System.out.println("Покупатель " + i + " зашёл в салон");
                    if (!names.isEmpty()) {
                        System.out.println("Покупатель " + names.remove(0) + " уехал на новеньком авто");


//                        try {
//                            names.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    }
                    else {
                        System.out.println("Машин нет");
                    }
                }
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    return;
//                }
            }
        }).start();
    }
}