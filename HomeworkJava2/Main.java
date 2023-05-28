//Дана строка sql-запроса "select * from students where ".
//Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String query = "select * from students where ";
        JSONObject params = new JSONObject("{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}");
        StringBuilder whereClause = new StringBuilder();
        for (String key : params.keySet()) {
            String value = params.optString(key);
            if (value != null && !"null".equals(value)) {
                whereClause.append(key).append(" = '").append(value).append("' AND ");
            }
        }
        if (whereClause.length() > 0) {
            whereClause.delete(whereClause.length()-5, whereClause.length());
            query += whereClause.toString();
            System.out.println(query);
        } else {
            System.out.println("select * from students");
        }

        int[] arr = { 3, 5, 1, 4, 2 };
        System.out.println("Initial array: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j-1] > arr[j]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println("After iteration " + (i+1) + ": " + Arrays.toString(arr));
        }
    }
}
//создаем JSONObject из JSON-строки, перебираем ключи объекта params и формируем часть WHERE запроса в StringBuilder,
// исключая параметры, у которых значение равно null.
// После окончания перебора мы проверяем, что длина whereClause больше нуля, и если да,
// то убираем последний оператор "AND" в whereClause, добавляем к нему "select * from students where " и выводим результат.
// Если все параметры имеют значение null, мы выводим просто "select * from students".
//Затем мы создаем массив arr и сортируем его методом пузырька, выводя результат после каждой итерации сортировки.