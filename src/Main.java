import com.engeto.restaurant.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        CookBook cookBook = new CookBook();
        Order orderFromFile = new Order();
        RestaurantManager restaurantManager = new RestaurantManager();

        System.out.println("\n------Testovací aplikace 1. projekt: Restaurace");

        //Načtení seznamu jídel z disku - soubor se automaticky vytvoří
        FileManager.loadCookBook(Settings.getCookBookFileName());

        //Přidání pokrmů do seznamu dle zadání
        TestingData.addCookBookData(cookBook);

        //Vypsání seznamu pokrmů
        cookBook.printDishes();

        //Seznam pokrmů se uloží do souboru
        FileManager.saveCookBook(Settings.getCookBookFileName());


        //Přidání objednávek dle zadání
        // objednávky jsou pro otestování ověření platby založeny před zvolenými minutami (viz Settings)
        TestingData.addOrdersData(orderFromFile);

        //Vypsání celkové konzumace za dnešní den pro zadané stoly
        orderFromFile.printTableOrders(15, LocalDate.now());
        orderFromFile.printTableOrders(2, LocalDate.now());

        //Vypsání počtu rozpracovaných objednávek
        restaurantManager.unfulfilledOrders(orderFromFile, LocalDate.now());

        //Vypsání seřazených objednávek pro dnešní den dle času
        restaurantManager.sortOrdersByOrderTime(orderFromFile,LocalDate.now());

        //Průměrná doba zpracování jedné objednávky
        restaurantManager.averageOrderTime(orderFromFile,LocalDate.now());

        //Vypsání dnes objednaných jídel
        restaurantManager.orderedDishList(orderFromFile, LocalDate.now());

        //Uložení seznamu objednávek do souboru se názvem dle data a času uložení
        FileManager.saveOrders(Settings.getDateOrderFilename() + "_objednavky.txt");

        //Načtení seznamu objednávek
        FileManager.loadOrders(Settings.getDateOrderFilename() + "_objednavky.txt");

        //Opětovné uložení seznamu objednávek do jiného souboru pro ověření
        FileManager.saveOrders("seznamobjednavek.txt");
    }


}

