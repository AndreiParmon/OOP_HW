//Чтобы можно было хранить еду, создадим класс Тарелка с полем food (еда измеряется в целых числах и не важно,
//что это за единицы измерения). При создании тарелки мы можем указать начальное значение food. В процессе работы
//с помощью метода info() можно вывести в консоль информацию о тарелке.

package lesson2.homeWork;

public class Plate {
    private int food;
    public Plate(int food){
        if(food < 10){
            throw new RuntimeException("Количество еды должно быть больше, чем кот может скушать!");
        }
        else {
            this.food = food;
        }
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }


    public void info(){
        System.out.println("plate: " + food);
    }
}
