/**
 *  a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
 *  b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
 *  поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 *  c. Для хранения фруктов внутри коробки можно использовать ArrayList;
 *  d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
 *  вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
 *  e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
 *  подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
 *  Можно сравнивать коробки с яблоками и апельсинами;
 *  f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
 *  Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
 *  Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
 *  g. Не забываем про метод добавления фрукта в коробку.
 */

package lesson4.homeWork;

import java.util.ArrayList;
import java.util.List;

public class Sample {
    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<Apple>();
        Box<Orange> orangeBox = new Box<Orange>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        System.out.printf("Вес коробки с яблоками: %sf\n", appleBox.getTotalWeight());
        System.out.printf("Вес коробки с апельсинами: %sf\n", orangeBox.getTotalWeight());

        System.out.println(appleBox.compare(orangeBox));


    }
}

abstract class Fruit{
    private final float weight;

    public float getWeight() {
        return weight;
    }
    public Fruit(float weight) {
        this.weight = weight;
    }
}

class Apple extends Fruit{
    public Apple() {
        super(1.0f);
    }

}

class Orange extends Fruit{
    public Orange(){
        super(1.5f);
    }
}

class Box<T extends Fruit>{
    private List<T> fruitList;
    private double totalWeight;
    public Box(){
        this.fruitList = new ArrayList<>();
    }

    public void addFruit(T fruit){
        fruitList.add(fruit);
        totalWeight += fruit.getWeight();
    }

    public double getTotalWeight(){
        return totalWeight;
    }

    boolean compare(Box box){
        return this.getTotalWeight() == box.getTotalWeight();
    }

}
