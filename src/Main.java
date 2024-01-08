import com.engeto.restaurant.*;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) throws DishException {
        CookBook cookBook = FileManager.loadPlants(Settings.getDefaultFileName());

        TestingData.loadTestingData(cookBook);
//        cookBook.removeDish(4);

//        cookBook.editDish(4,new Dish("Kofola 1 l", BigDecimal.valueOf(60), 2));
        Order tableOrder1 = new Order(1, 1, 1, LocalTime.now(), false);
        Order tableOrder2 = new Order(1, 3, 2, LocalTime.now(), false);
        Order tableOrder3 = new Order(2, 3, 31, LocalTime.now(), true);

        System.out.println(Order.getOrders());
        System.out.println(Order.getTableOrders(1));


//       CookBook.saveToFile("seznamjidel.txt", cookBook);
        cookBook.printDishes();


    }

}