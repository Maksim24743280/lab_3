import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Задание №2. Генератор простых чисел (2 балла)
 * Класс генерирует заданное количество (N) простых чисел.
 * Реализует Iterable, чтобы можно было перебирать числа через Iterator.
 */
public class PrimesGenerator implements Iterable<Integer> {

    private final int count; // Сколько простых чисел нужно сгенерировать

    /**
     * Конструктор принимает количество простых чисел, которое нужно сгенерировать.
     * @param count количество простых чисел (N)
     */
    public PrimesGenerator(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Количество простых чисел не может быть отрицательным");
        }
        this.count = count; // Сохраняем переданное значение N
    }

    /**
     * Возвращает итератор, который последовательно выдаёт простые числа.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new PrimesIterator(); // Создаём внутренний итератор
    }

    /**
     * Внутренний класс-итератор, который генерирует простые числа по одному.
     */
    private class PrimesIterator implements Iterator<Integer> {
        private int generated = 0; // Сколько простых чисел уже выдано
        private int current = 1;   // Текущее число, которое проверяем на простоту

        /**
         * Проверяет, есть ли ещё простые числа для выдачи.
         */
        @Override
        public boolean hasNext() {
            return generated < count; // Пока не достигли нужного количества
        }

        /**
         * Возвращает следующее простое число.
         */
        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Больше простых чисел нет");
            }
            // Ищем следующее простое число
            do {
                current++; // Переходим к следующему кандидату
            } while (!isPrime(current)); // Пока число не простое — продолжаем

            generated++; // Увеличиваем счётчик выданных чисел
            return current; // Возвращаем найденное простое число
        }

        /**
         * Проверка, является ли число простым.
         * @param n число для проверки
         * @return true, если число простое
         */
        private boolean isPrime(int n) {
            if (n < 2) return false;           // Числа меньше 2 не являются простыми
            if (n == 2) return true;           // 2 — самое маленькое простое число
            if (n % 2 == 0) return false;      // Чётные числа больше 2 не простые
            // Проверяем делители от 3 до sqrt(n) с шагом 2
            for (int i = 3; i * i <= n; i += 2) {
                if (n % i == 0) return false;  // Нашли делитель — число не простое
            }
            return true; // Делителей не найдено — число простое
        }
    }
}