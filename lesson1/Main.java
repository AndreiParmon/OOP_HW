package lesson1.homeWork;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new CocaCola("Coca-Cola", 5.2, 2));
        products.add(new CocaCola("Coca-Cola Ванила", 3.5, 1.5));
        products.add(new CocaCola("Coca-Cola Лайм", 2.5, 0.5));
        products.add(new Beer("Koronet", 3.5, 0.5, 4.7));
        products.add(new Beer("Вечер в Брюгге", 3.0, 0.5, 4.4));

        VendingMachine vendingMachine = new VendingMachine(products);

        CocaCola cocaColaRes = vendingMachine.getCocaCola("Coca-Cola Ванила", 1.5);
        if (cocaColaRes != null){
            System.out.println("Вы купили: ");
            System.out.println(cocaColaRes.displayInfo());
        }
        else {
            System.out.println("Такого товара нет в автомате.");
        }

        System.out.println("---------------");

        Beer beerRes = vendingMachine.getBeer("Koronet", 0.5);
        if (beerRes != null){
            System.out.println("Вы купили: ");
            System.out.println(beerRes.displayInfo());
        }
        else {
            System.out.println("Такого товара нет в автомате.");
        }
    }
}
