import com.engeto.restaurant.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        CookBook cookBook = new CookBook();
//        Order order = new Order();
//        Order order2 = new Order();

        cookBook = FileManager.loadCookBook(Settings.getDefaultFileName());
        TestingData.addCookBookData(cookBook);

        cookBook.printDishes();

        try {
            CookBook.saveCookBookToFile("seznamjidel.txt", cookBook);
        } catch (DishException e) {
            {
                System.err.println("Chyba při ukládání souboru. " + e.getLocalizedMessage());
            }
        }

        System.out.println("Ojednavky ze souboru");
        Order orderFromFile = FileManager.loadOrders(Settings.getDefaultSaveFileName());
//                TestingData.addOrdersData(orderFromFile);
//        System.out.println(orderFromFile.getOrders());

        orderFromFile.printTableOrders(15);

//        try {
//            Order.saveOrderToFile("objednavky.txt", orderFromFile);
//        }
//        catch (OrderException e){ System.err.println("Chyba při ukládání souboru. " + e.getLocalizedMessage());
//        }

//        Order.resetOrderNumber();


    }


//        cookBook.editDish(4,new Dish("Kofola 1 l", BigDecimal.valueOf(60), 2));

}

