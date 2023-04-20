//Допустим, в программе есть класс Кот. У кота есть кличка и аппетит (сколько единиц еды он потребляет
// за приём пищи). Эти поля мы заполняем с помощью конструктора. Также есть метод eat(), который заставляет
//кота покушать.

package lesson2.homeWork;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat(String name, int appetite){
        this.name = name;
        if (appetite < 10){
            throw new RuntimeException("Кот не может покушать, пока в тарелке еды меньше, чем он может скушать!");
        }
        else {
            this.appetite = appetite;
        }
    }
    public void eat(Plate plate){
        System.out.println("Кот кушает!");
        if (plate.getFood() >= appetite){

            plate.setFood(plate.getFood() - appetite);
            System.out.printf("%s удалось покушать\n", getName());
            satiety = true;
        }
        else {
            System.out.printf("%s не покушал(\n", getName());
        }
    }
}
