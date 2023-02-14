import java.security.PublicKey;
import java.util.*;

public class Logic {
    static private Scanner _input = new Scanner(System.in);
    static private String condition;
    static private int numb;
    static private List<Integer> utility = new ArrayList<Integer>();

    public static void compare(List<Integer> _numbers) { // Функция сравнения (Задание a)
        System.out.print("<<<Введите условие проверки (>0) / (<10)\n" +
                         ">>>");
        condition = _input.nextLine();
        numb = Integer.parseInt(condition.substring(1)); // Извлечение числа из условия
        for (int x : _numbers){ // Проход по списку чисел
            if ( ( (condition.startsWith(">") ) && (x > numb) ) || ( (condition.startsWith("<") ) && (x < numb) ) ) {
                utility.add(x); // Если элемент списка удовлетворяет условию, то добавляется в доп список
            }
        }
        if (utility.size() == 0) {
            System.out.println("<<<Нет чисел удовлетворяющих условию>>>");
        } else {
            for (var x : utility) { // Вывод списка чисел удовлетворяющих условию
                System.out.print(x + " ");
            }
            System.out.println(); // Переход на следующую строку консоли
        }
        utility.clear();
    }
    public static void equals(List<Integer> _numbers) {
        System.out.print("<<<Введите условие проверки (=1) / (<>1)\n" +
                           ">>>");
        condition = _input.nextLine();
        boolean equal = true; // Переменная-флаг для определения условия сравнения
        if (condition.startsWith("=")) { // При условии равно
            numb = Integer.parseInt(condition.substring(1));
        } else { // При условии неравно
            numb = Integer.parseInt(condition.substring(2));
            equal = false;
        }
        for (int x : _numbers) {
            if ( ( (equal == true) && (x == numb) ) || ( (equal == false) && (x != numb) ) ) {
                System.out.println("<<<В массиве есть такое число>>>");
                return;
            }
        }
        System.out.println("<<<В массиве нет такого числа>>>");
    }
    public static void removeDuplicates(List<Integer> _numbers) {
        for (int x : _numbers) { // Цикл добавления чисел из массива в список
            if (utility.contains(x) == false) { // Если числа нет в списке, то добавляем его
                utility.add(x);
                System.out.print(x + " "); // Вывод списка чисел удовлетворяющих условию
            }
        }
        System.out.println();
        utility.clear();
    }
    public static void order(List<Integer> _numbers) {
        utility.addAll(_numbers); // Добавляем все элементы из нашего списка в вспомогательный
        Collections.sort(utility); // Сортируем по возрастанию вспомогательный список
        if (utility.equals(_numbers)) { // Если списки равны
            System.out.println("<<<Список упорядочен по возрастанию>>>");
            utility.clear();
            return;
        }
        Collections.reverse(utility);
        if (utility.equals(_numbers)) { // Если списки равны
            System.out.println("<<<Список упорядочен по убыванию>>>");
            utility.clear();
            return;
        }
        System.out.println("<<<Список не упорядочен>>>");
        utility.clear();
    }
}
