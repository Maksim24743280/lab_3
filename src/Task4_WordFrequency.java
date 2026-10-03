import java.util.*;

/**
 * Задание №4. Частота слов (2 балла)
 * Подсчёт частоты встречаемости слов в тексте с помощью HashMap.
 * Слова, отличающиеся только регистром, считаются одинаковыми.
 */
public class Task4_WordFrequency {

    public static void main(String[] args) {
        // Заданная строка с текстом на английском языке
        String text = "Java is a programming language. Java is widely used. "
                + "Programming in Java is fun. Language learning takes time. "
                + "JAVA is case insensitive in this task.";

        System.out.println("Исходный текст:");
        System.out.println(text);
        System.out.println();

        // ========== Разбиваем текст на слова ==========
        // Заменяем все знаки препинания на пробелы и приводим к нижнему регистру
        String cleaned = text.toLowerCase()              // Приводим весь текст к нижнему регистру
                .replaceAll("[^a-zA-Z\\s]", " ");        // Убираем всё, кроме букв и пробелов

        // Разбиваем строку по пробелам (один или несколько)
        String[] words = cleaned.split("\\s+");

        // ========== Подсчитываем частоту с помощью HashMap ==========
        Map<String, Integer> frequency = new HashMap<>(); // Ключ — слово, значение — количество

        for (String word : words) {
            if (word.isEmpty()) continue; // Пропускаем пустые строки (на всякий случай)

            // Увеличиваем счётчик: если слова ещё нет — ставим 1, иначе +1
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        // ========== Выводим все различные слова и их частоту ==========
        System.out.println("Различные слова и частота их встречаемости:");
        System.out.println("(слова с разным регистром считаются одинаковыми)");
        System.out.println();

        // Для красивого вывода можно отсортировать по ключу
        List<String> sortedWords = new ArrayList<>(frequency.keySet());
        Collections.sort(sortedWords); // Сортируем слова по алфавиту

        for (String word : sortedWords) {
            System.out.println("  \"" + word + "\" → " + frequency.get(word) + " раз(а)");
        }

        System.out.println();
        System.out.println("Всего уникальных слов: " + frequency.size());
    }
}