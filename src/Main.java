import com.engeto.restaurant.*;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        CookBook cookBook = new CookBook();
        Order order = new Order();

        cookBook = FileManager.loadCookBook(Settings.getDefaultFileName());
//        TestingData.addCookBookData(cookBook);

        cookBook.printDishes();

//        System.out.println(Order.getOrders());
//        System.out.println(Order.getTableOrders(1));
//        Order order = new Order();
//        order.printTableOrders(1);
//        System.out.println(Order.printTableOrders(12));


//      CookBook.saveToFile("seznamjidel.txt", cookBook);


        TestingData.addOrdersData(order);


        order.printTableOrders(1);


    }


//        cookBook.editDish(4,new Dish("Kofola 1 l", BigDecimal.valueOf(60), 2));

}

