import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class Laba7_corrected {
    public static void main(String[] args) throws SQLException, IOException {

        Helper helper = new Helper();
        helper.Connection("jdbc:mysql://localhost/test", "root", "root");
        Scanner in = new Scanner(System.in);
        String tablename = "laba7";
        String input = "";
        int x = 0;

        while(!"5".equals(input)) {

            System.out.println("""
            --------------------------------------------------
            1 - Вывод таблиц
            2 - Создание таблицы
            3 - Ввести одномерный массив
            4 - Сохранить в Exel
            5 - Выход
            --------------------------------------------------""");
            System.out.print("Введите операцию: ");

            input = in.next();

            try {
                x = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите корректное число: ");
            }

            if (x > 5)
                System.out.println("Неверный ввод числа!");

            switch (x) {
                case 1:
                    helper.show_table();
                    break;
                case 2:
                    helper.create_table();
                    break;
                case 3:
                    System.out.print("Введите длину массива:");
                    int size = in.nextInt();
                    Sort arr = new Sort();
                    arr.createarray(size);
                    System.out.println(Arrays.toString(arr.Array));

                    System.out.print("Вы хотите отсортировать массив?(1-Да)/(2-Нет): ");
                    int input1 = in.nextInt();
                    if (input1 == 1) {
                        System.out.print("По возрастанию(1) или убыванию(2)?: ");
                        int input2 = in.nextInt();
                        if (input2 == 1) {
                            arr.bubble_sort_up();
                        } else if (input2 == 2) {
                            arr.bubble_sort_down();
                        }
                        System.out.println(Arrays.toString(arr.Array));
                        helper.execute_Update("INSERT INTO " + tablename + " (Array,Sorted_Array) VALUES ('" + Arrays.toString(arr.Array.clone()) + "','" + Arrays.toString(arr.Array) + "')");
                    } else if (input1 == 2) {
                        helper.execute_Update("INSERT INTO " + tablename + " (Array) VALUES ('" + Arrays.toString(arr.Array) + "')");
                    }
                    break;
                case 4:
                    helper.to_excel(tablename, "laba7.xlsx");
                    break;
            }


        }

    }
}


