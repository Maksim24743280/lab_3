import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Задание №2. Тестовый класс для PrimesGenerator.
 * Выводит первые N простых чисел в прямом и обратном порядке
 * с использованием интерфейса Iterator.
 */
public class PrimesGeneratorTest {

    public static void main(String[] args) {
        final int N = 10; // Количество простых чисел для генерации

        // Создаём генератор простых чисел
        PrimesGenerator generator = new PrimesGenerator(N);

        // ========== Вывод в прямом порядке через Iterator ==========
        System.out.println("Первые " + N + " простых чисел в прямом порядке:");
        List<Integer> primes = new ArrayList<>(); // Сохраняем числа, чтобы потом вывести в обратном порядке

        Iterator<Integer> iterator = generator.iterator(); // Получаем итератор
        while (iterator.hasNext()) {                       // Пока есть следующее число
            Integer prime = iterator.next();               // Берём следующее простое число
            System.out.print(prime + " ");                 // Выводим его
            primes.add(prime);                             // Сохраняем в список
        }
        System.out.println(); // Переход на новую строку

        // ========== Вывод в обратном порядке ==========
        System.out.println("Первые " + N + " простых чисел в обратном порядке:");
        Collections.reverse(primes); // Разворачиваем список
        for (Integer prime : primes) {
            System.out.print(prime + " "); // Выводим числа в обратном порядке
        }
        System.out.println();
    }
}