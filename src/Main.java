import com.engeto.restaurant.*;

public class Main {
    public static void main(String[] args) {
        CookBook cookBook = new CookBook();
        Order order = new Order();
        Order order2 = new Order();

        cookBook = FileManager.loadCookBook(Settings.getDefaultFileName());
        TestingData.addCookBookData(cookBook);

        cookBook.printDishes();

//        System.out.println(Order.getOrders());
//        System.out.println(Order.getTableOrders(1));
//        Order order = new Order();
//        order.printTableOrders(1);
//        System.out.println(Order.printTableOrders(12));


//      CookBook.saveToFile("seznamjidel.txt", cookBook);


        TestingData.addOrdersData(order);
        order.printTableOrders(1);
        order.printTableOrders(2);

//Order.resetOrderNumber();



//        TestingData.addOrdersData2(order2);
//        order2.printTableOrders(1);
//        order2.printTableOrders(2);
//////        System.out.println(order.getOrders());


    }


//        cookBook.editDish(4,new Dish("Kofola 1 l", BigDecimal.valueOf(60), 2));

}

