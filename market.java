import java.util.LinkedList;
import java.util.Queue;

public class Market implements QueueBehaviour, MarketBehaviour {
    private Queue<Человек> очередь;
    private Queue<Заказ> заказы;

    public Market() {
        очередь = new LinkedList<>();
        заказы = new LinkedList<>();
    }

    @Override
    public void takeInQueue(Человек человек) {
        очередь.add(человек);
        System.out.println(человек.getName() + " добавлен в очередь.");
    }

    @Override
    public void releaseFromQueue() {
        Человек человек = очередь.poll();
        if (человек != null) {
            System.out.println(человек.getName() + " убран из очереди.");
        }
    }

    @Override
    public void acceptOrder(Человек человек, Заказ заказ) {
        if (очередь.contains(человек)) {
            заказы.add(заказ);
            System.out.println("Заказ принят от " + человек.getName() + ": " + заказ.getDetails());
        } else {
            System.out.println("Человек не в очереди: " + человек.getName());
        }
    }

    @Override
    public void handOverOrder(Человек человек) {
        Заказ заказ = заказы.poll();
        if (заказ != null) {
            System.out.println("Заказ выдан " + человек.getName() + ": " + заказ.getDetails());
        }
    }

    public void update() {
        releaseFromQueue();
        if (!очередь.isEmpty()) {
            Человек человек = очередь.peek();
            handOverOrder(человек);
        }
    }
}

