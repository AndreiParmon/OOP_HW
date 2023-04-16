package lesson1.homeWork;

public class Product {
    protected String brand;
    protected String name;
    protected double price;

    public Product(String brand, String name, double price){
        if (brand.length() < 1)
            throw new RuntimeException("Некоректная запись");
        else
            this.brand = brand;

        if (name.length() < 1)
            throw new RuntimeException("Некоректная запись");
        else
            this.name = name;

        if (price <= 0)
            throw new RuntimeException("Некоректная сумма товара.");
        this.price = price;
    }

    /**
     * Получить информацию по продукту
     * @return Информация по продукту
     */
    public String displayInfo() {
        return String.format("%s - %s - %s", brand, name, price);
    }
}
