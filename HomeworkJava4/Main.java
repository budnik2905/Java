//1.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы.
// Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"
//2.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас и пол в отдельных списках.
//3.Отсортировать по возрасту используя дополнительный список индексов.
//4.Отсортировать по полу используя дополнительный список индексов.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "file.txt";
        List<String> lines = new ArrayList<>();
        List<String> surnames = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<String> patronymics = new ArrayList<>();
        List<Integer> ages = new ArrayList<>();
        List<Character> genders = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
                String[] parts = line.split(" ");
                if (parts.length == 4) {
                    surnames.add(parts[0]);
                    names.add(parts[1]);
                    patronymics.add(parts[2]);
                    ages.add(Integer.parseInt(parts[3]));
                    genders.add(getGender(parts[2]));
                } else {
                    System.out.println("Invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Сортировка по возрасту
        List<Integer> ageIndexes = new ArrayList<>();
        for (int i = 0; i < ages.size(); i++) {
            ageIndexes.add(i);
        }
        Collections.sort(ageIndexes, Comparator.comparingInt(ages::get));
        System.out.println("Sorted by age:");
        for (int i : ageIndexes) {
            System.out.println(formatPerson(surnames.get(i), names.get(i), patronymics.get(i), ages.get(i), genders.get(i)));
        }

        // Сортировка по полу
        List<Integer> genderIndexes = new ArrayList<>();
        for (int i = 0; i < genders.size(); i++) {
            genderIndexes.add(i);
        }
        Collections.sort(genderIndexes, Comparator.comparing(genders::get));
        System.out.println("Sorted by gender:");
        for (int i : genderIndexes) {
            System.out.println(formatPerson(surnames.get(i), names.get(i), patronymics.get(i), ages.get(i), genders.get(i)));
        }
    }

    private static char getGender(String patronymic) {
        if (patronymic.endsWith("в")) {
            return 'М';
        } else if (patronymic.endsWith("ва")) {
            return 'Ж';
        } else {
            return '-';
        }
    }

    private static String formatPerson(String surname, String name, String patronymic, int age, char gender) {
        return String.format("%s %s.%s. %d %c", surname, name.charAt(0), patronymic.charAt(0), age, gender);
    }
}