import java.util.*;

/**
 * Задание №5. Обмен ключей и значений (3 балла)
 * Метод получает Map<K, V> и возвращает новую Map, где ключи и значения поменяны местами.
 *
 * Важно: если исходная Map содержит дублирующиеся значения,
 * в новой Map останется только одно из них (последнее),
 * потому что ключи в Map должны быть уникальными.
 */
public class Task5_SwapKeysValues {

    /**
     * Меняет местами ключи и значения в Map.
     * @param original исходная Map
     * @param <K>      тип ключей исходной Map
     * @param <V>      тип значений исходной Map
     * @return новая Map, в которой ключи и значения поменяны
     */
    public static <K, V> Map<V, K> swapKeysAndValues(Map<K, V> original) {
        // Создаём новую HashMap для результата
        Map<V, K> swapped = new HashMap<>();

        // Проходим по всем парам исходной Map
        for (Map.Entry<K, V> entry : original.entrySet()) {
            K key = entry.getKey();     // Берём старый ключ
            V value = entry.getValue(); // Берём старое значение

            // Кладём в новую Map: значение становится ключом, ключ — значением
            swapped.put(value, key);
        }

        return swapped; // Возвращаем новую Map
    }

    public static void main(String[] args) {
        // ========== Демонстрация работы метода ==========
        Map<String, Integer> original = new HashMap<>();
        original.put("Яблоко", 1);
        original.put("Банан", 2);
        original.put("Апельсин", 3);
        original.put("Груша", 4);

        System.out.println("Исходная Map (ключ → значение):");
        for (Map.Entry<String, Integer> entry : original.entrySet()) {
            System.out.println("  " + entry.getKey() + " → " + entry.getValue());
        }

        // Вызываем метод обмена
        Map<Integer, String> swapped = swapKeysAndValues(original);

        System.out.println("\nMap после обмена ключей и значений:");
        for (Map.Entry<Integer, String> entry : swapped.entrySet()) {
            System.out.println("  " + entry.getKey() + " → " + entry.getValue());
        }

        // ========== Пример с дублирующимися значениями ==========
        System.out.println("\n--- Пример, когда в исходной Map есть одинаковые значения ---");
        Map<String, String> mapWithDuplicates = new HashMap<>();
        mapWithDuplicates.put("A", "X");
        mapWithDuplicates.put("B", "Y");
        mapWithDuplicates.put("C", "X"); // Значение "X" уже есть

        System.out.println("Исходная Map:");
        for (Map.Entry<String, String> e : mapWithDuplicates.entrySet()) {
            System.out.println("  " + e.getKey() + " → " + e.getValue());
        }

        Map<String, String> swappedDup = swapKeysAndValues(mapWithDuplicates);
        System.out.println("После обмена (значение \"X\" осталось только от одного ключа):");
        for (Map.Entry<String, String> e : swappedDup.entrySet()) {
            System.out.println("  " + e.getKey() + " → " + e.getValue());
        }
    }
}