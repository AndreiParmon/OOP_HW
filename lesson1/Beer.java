package lesson1.homeWork;

public class Beer extends Product{
    private double volume; // объём
    private double strength; // крепость

    public double getVolume() {
        return volume;
    }

    public Beer(String name, double price, double volume, double strength){
        super("Лiдскае", name, price);
        this.volume = volume;
        this.strength = strength;
    }

    @Override
    public String displayInfo() {
        return String.format("Бренд: %s\nНазвание: %s\nЦена: %s руб.коп.\nОбъём: %s л.", brand, name, price, volume);
    }
}
