import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException
    {
        Scanner input = new Scanner(System.in);
        String key;
        CustomSet A;
        CustomSet B;

        menu.firstCall();
        key = input.nextLine();
        if (key.startsWith("auto")) {
            A = new CustomSet(); // Вызов конструктора по умолчанию
        } else {
            A = new CustomSet(key); // Вызов конструктора со входным значением
        }

        while (true) { // Цикл реализации консольного меню
            menu.printMenu();
            key = input.nextLine(); // Выбор команды пользователем
            switch (key) {
                case ("a"): {
                    Logic.compare(A.numbers); // Вызов метода выполнения задания A
                    break;
                }
                case ("b"): {
                    Logic.equals(A.numbers); // Вызов метода выполнения задания B
                    break;
                }
                case ("c"): {
                    Logic.removeDuplicates(A.numbers); // Вызов метода выполнения задания C
                    break;
                }
                case ("d"): {
                    Logic.order(A.numbers); // Вызов метода выполнения задания D
                    break;
                }
                case ("exit"): {
                    System.exit(0); // Выход из программы
                }
                case ("clone test"): {
                    System.out.print("Список чисел класса A: " + A.numbers + "\n");

                    //создаем 2 потока для сериализации объекта и сохранения его в файл
                    FileOutputStream outputStream = new FileOutputStream("C:\\Users\\andrx\\Desktop\\save.ser");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                    // сохраняем игру в файл
                    objectOutputStream.writeObject(A);

                    //закрываем поток и освобождаем ресурсы
                    objectOutputStream.close();

                    // открываем поток и выгружаем ресурсы
                    FileInputStream fileInputStream = new FileInputStream("C:\\Users\\andrx\\Desktop\\save.ser");
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                    B = (CustomSet) objectInputStream.readObject();
                    objectInputStream.close();

                    //B = A.clone(); // Применение переопределенного метода clone
                    //B = new CustomSet(A); // Применение конструктора глубокого клонирования класса A к классу B
                    System.out.print("Список чисел класса B: " + B.numbers + "\n");
                    System.out.println("Добавим в список класса А число 999 в начало ");
                    A.numbers.add(0, 999); // Добавления числа в список класса A
                    System.out.print("Список чисел класса A: " + A.numbers + "\n");
                    System.out.print("Список чисел класса B: " + B.numbers + "\n");
                    System.out.println("Адрес класса A: " + A.hashCode() + " Адрес списка класса A: " + A.numbers.hashCode());
                    System.out.println("Адрес класса B: " + B.hashCode() + " Адрес списка класса B: " + B.numbers.hashCode());
                    break;
                }
                default: {
                    System.out.println("<<Неверная команда!");
                }
            }
        }

    }
}