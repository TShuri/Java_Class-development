public class menu {
    public static void firstCall(){
        System.out.println("<<Введите список чисел через пробел");
        System.out.println("<<Введите auto для автоматической генерации списка чисел");
        System.out.print(">>");
    }
    public static void printMenu(){
        System.out.println("<<Новый список чисел(new list)");
        System.out.println("<<Выполнение задания(a, b, c ,d)");
        System.out.println("<<Тест конструктора клонирования(clone test)");
        System.out.println("<<Выход(exit)");
        System.out.print("Введите команду>>");
    }
    public static void menuForA(){
        System.out.println("<<<Введите условие проверки (>0) / (<10)");
        System.out.print(">>>");

    }
}
