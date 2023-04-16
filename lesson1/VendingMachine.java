package lesson1.homeWork;

import java.util.List;

public class VendingMachine {
    private final List<Product> products;
    public VendingMachine(List<Product> products){
        this.products = products;
    }

    public CocaCola getCocaCola(String name, double volume){
        for (Product product : products) {
            if (product instanceof CocaCola){
                CocaCola bottle = ((CocaCola) product);
                if (bottle.name.equals(name) && bottle.getVolume() == volume)
                    return bottle;
            }
        }
        return null;
    }
    public Beer getBeer(String name, double volume){
        for (Product product : products) {
            if (product instanceof Beer){
                Beer bottle = ((Beer) product);
                if (bottle.name.equals(name) && bottle.getVolume() == volume)
                    return bottle;
            }
        }
        return null;
    }
}
