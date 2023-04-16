package lesson1.homeWork;

public class CocaCola extends Product{
    private double volume;

    public double getVolume() {
        return volume;
    }

    public CocaCola(String name, double price, double volume){
        super("Coca-Cola", name, price);
        this.volume = volume;
    }

    @Override
    public String displayInfo() {
        return String.format("Бренд: %s\nНазвание: %s\nЦена: %s руб.коп.\nОбъём: %s л.", brand, name, price, volume);
    }
}
