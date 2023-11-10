import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        double number = 0;
        int sumOne = 0;
        int sumTwo = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/ilaykiyashko/Учеба/file"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                number++;
                int characterCount = line.length();
                int wordCount = line.split("\\s*").length;
                sumOne += characterCount;
                sumTwo += wordCount;

                System.out.println("Строка " + number + ":");
                System.out.println("Количество символов: " + characterCount);
                System.out.println("Количество слов: " + wordCount);
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Файл отсутствует");
        }

        System.out.println("Количество строк: " + number);
        System.out.println("Количество символов: " + sumOne);
        System.out.println("Количество слов: " + sumTwo);
        System.out.println("\u001B[1mО\n\n---------------------------------------------------\n\n\u001B[0m");
        String numberSum;
        int sum = 0;
        number = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/ilaykiyashko/Учеба/file"))) {
            String line;
            String boldText = "\u001B[1mОценка меньше 3-х баллов: \u001B[0m";
            System.out.println(boldText + "\n");
            while ((line = bufferedReader.readLine()) != null) {
                number++;
                numberSum = line.replaceAll("\\D", "");
                sum = sum + Integer.parseInt(numberSum);
                if (Integer.parseInt(numberSum) < 3) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("\u001B[1mУПС! файл отсутствует\u001B[0m");
        }
        System.out.println("\u001B[1mСредняя оценка всех участников: \u001B[0m" + sum / number);


    }
}



