import com.engeto.restaurant.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CookBook cookBook = new CookBook();

        try {
            cookBook = FileManager.loadCookBook(Settings.getDefaultFileName());
        } catch (IOException e) {
            {
                System.err.println("Chyba při ukládání souboru. " + e.getLocalizedMessage());
            }
        } catch (DishException e) {
            throw new RuntimeException(e);
        }
        TestingData.addCookBookData(cookBook);

        try {
            CookBook.saveCookBookToFile("seznamjidel.txt", cookBook);
        } catch (DishException e) {
            {
                System.err.println("Chyba při ukládání souboru. " + e.getLocalizedMessage());
            }
        }




        System.out.println("Seznam pokrmů:");
        cookBook.printDishes();
        System.out.println("Ojednavky ze souboru:");

        Order orderFromFile = new Order();
//        FileManager.loadOrders(Settings.getDefaultSaveFileName());

//        Order orderFromFile2=FileManager.loadOrders("seznamobjednavek2.txt");
//        TestingData.addOrdersData(orderFromFile2);
                TestingData.addOrdersData(orderFromFile);


        orderFromFile.printTableOrders(15, LocalDate.now());
        orderFromFile.printTableOrders(2,LocalDate.now());

//        orderFromFile.printTablePrice(15);
        RestaurantManager restaurantManager = new RestaurantManager();
        restaurantManager.unfulfilledOrders(orderFromFile,LocalDate.now());



//        try {
//            Order.saveOrderToFile(Settings.getDateOrderFilename()+"_objednavky", orderFromFile);
//        } catch (OrderException e) {
//            System.err.println("Chyba při ukládání souboru. " + e.getLocalizedMessage());
//        }
//
//        Order.resetOrderNumber();


    }


//        cookBook.editDish(4,new Dish("Kofola 1 l", BigDecimal.valueOf(60), 2));

}

