import java.util.*;

/**
 * Задание №1. Методы Collections (1 балл)
 * Работа со статическими методами класса Collections.
 */
public class Task1_CollectionsMethods {

    public static void main(String[] args) {
        // N — количество случайных чисел (можно менять)
        final int N = 20;

        // ========== 1. Создаём массив из N случайных чисел от 0 до 100 ==========
        Integer[] array = new Integer[N];          // Создаём массив Integer размера N
        Random random = new Random();              // Генератор случайных чисел
        for (int i = 0; i < N; i++) {              // Проходим по всем элементам массива
            array[i] = random.nextInt(101);        // Записываем случайное число от 0 до 100 включительно
        }
        System.out.println("1. Исходный массив: " + Arrays.toString(array));

        // ========== 2. На основе массива создаём список List ==========
        List<Integer> list = new ArrayList<>(Arrays.asList(array)); // Преобразуем массив в ArrayList
        System.out.println("2. Список на основе массива: " + list);

        // ========== 3. Сортируем список по возрастанию ==========
        Collections.sort(list);                    // Сортировка по возрастанию (natural order)
        System.out.println("3. После сортировки по возрастанию: " + list);

        // ========== 4. Сортируем список в обратном порядке ==========
        Collections.sort(list, Collections.reverseOrder()); // Сортировка по убыванию
        System.out.println("4. После сортировки по убыванию: " + list);

        // ========== 5. Перемешиваем список ==========
        Collections.shuffle(list);                 // Случайное перемешивание элементов
        System.out.println("5. После перемешивания: " + list);

        // ========== 6. Циклический сдвиг на 1 элемент ==========
        // rotate сдвигает элементы вправо на указанное количество позиций
        Collections.rotate(list, 1);               // Сдвиг вправо на 1 позицию
        System.out.println("6. После циклического сдвига на 1: " + list);

        // ========== 7. Оставляем в списке только уникальные элементы ==========
        // Создаём LinkedHashSet — он сохраняет порядок и убирает дубликаты
        Set<Integer> uniqueSet = new LinkedHashSet<>(list);
        List<Integer> uniqueList = new ArrayList<>(uniqueSet); // Преобразуем обратно в список
        System.out.println("7. Только уникальные элементы: " + uniqueList);

        // ========== 8. Оставляем в списке только дублирующиеся элементы ==========
        // Считаем частоту каждого числа
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer num : list) {                 // Проходим по исходному (после shuffle) списку
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1); // Увеличиваем счётчик
        }
        // Собираем только те числа, которые встречаются больше 1 раза
        List<Integer> duplicates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > 1) {            // Если число встречается более одного раза
                duplicates.add(entry.getKey());    // Добавляем его в список дубликатов
            }
        }
        System.out.println("8. Только дублирующиеся элементы: " + duplicates);

        // ========== 9. Из списка получаем массив ==========
        Integer[] resultArray = uniqueList.toArray(new Integer[0]); // Преобразуем список в массив
        System.out.println("9. Массив из списка уникальных: " + Arrays.toString(resultArray));

        // ========== 10. Подсчитываем количество вхождений каждого числа ==========
        System.out.println("10. Количество вхождений каждого числа (по исходному списку после shuffle):");
        // frequencyMap уже посчитан выше на шаге 8
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("   Число " + entry.getKey() + " встречается " + entry.getValue() + " раз(а)");
        }
    }
}