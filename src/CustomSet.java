import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class CustomSet implements Cloneable, Serializable {
    List<Integer> numbers;
    //List<Integer> numbers = new ArrayList<Integer>(); // Список чисел
   public CustomSet(String strNumbers) { // Конструктор класса при ручном вводе последовательности
       this.numbers = new ArrayList<Integer>();
       for (var x: strNumbers.split(" ")) {
           this.numbers.add(Integer.parseInt(x));
       }
   }
   public CustomSet() { // Конструктор класса при автоматической генерации
       this.numbers = new ArrayList<Integer>();
       for (int i = 0; i < 10; i++) {
           numbers.add((int) (Math.random() * 10) + 1);
       }
       printSet();
   }
   public CustomSet clone() throws CloneNotSupportedException{ // Переопределенный метод clone
       CustomSet newSet = (CustomSet)super.clone();
       newSet.numbers = new ArrayList<Integer>(this.getNumbers());
       return newSet;
   }

   public CustomSet(CustomSet other) { // Конструктор клонирования

       this.numbers = new ArrayList<Integer>(other.getNumbers());
   }
   public List getNumbers() { // Возвращение списка чисел
       return numbers;
    }
   public void printSet() { // Функция вывода множества
       for (int x : this.numbers) {
           System.out.print(x + " ");
       }
       System.out.println();
   }
}

