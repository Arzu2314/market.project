
public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        Человек человек1 = new Человек("Иван");
        Человек человек2 = new Человек("Мария");
        Заказ заказ1 = new Заказ("Кофе");
        Заказ заказ2 = new Заказ("Чай");

        market.takeInQueue(человек1);
        market.takeInQueue(человек2);

        market.acceptOrder(человек1, заказ1);
        market.acceptOrder(человек2, заказ2);

        market.update(); // Убирает Ивана из очереди и выдаёт ему заказ
        market.update(); // Убирает Марию из очереди и выдаёт ей заказ
    }
}
