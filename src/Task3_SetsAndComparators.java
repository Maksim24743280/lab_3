import java.util.*;

/**
 * Задание №3. Множества и сравнение объектов (3 балла)
 */
public class Task3_SetsAndComparators {

    public static void main(String[] args) {
        // ========== 1. Создаём список объектов Human ==========
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Иван", "Иванов", 25));
        humans.add(new Human("Пётр", "Петров", 30));
        humans.add(new Human("Анна", "Сидорова", 22));
        humans.add(new Human("Мария", "Иванова", 28));
        humans.add(new Human("Алексей", "Петров", 25)); // Одинаковый возраст с Иваном
        humans.add(new Human("Иван", "Иванов", 25));    // Полный дубликат Ивана Иванова

        System.out.println("1. Исходный список Human:");
        for (Human h : humans) {
            System.out.println("   " + h);
        }

        // ========== 2. Кладём список в HashSet и выводим ==========
        // HashSet не сохраняет порядок и убирает дубликаты (по equals/hashCode)
        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println("\n2. HashSet (порядок не гарантирован, дубликаты удалены):");
        for (Human h : hashSet) {
            System.out.println("   " + h);
        }

        // ========== 3. Кладём список в LinkedHashSet и выводим ==========
        // LinkedHashSet сохраняет порядок вставки и убирает дубликаты
        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("\n3. LinkedHashSet (порядок вставки сохранён, дубликаты удалены):");
        for (Human h : linkedHashSet) {
            System.out.println("   " + h);
        }

        // ========== 4. Кладём список в TreeSet и выводим ==========
        // TreeSet сортирует по Comparable (по возрасту) и убирает дубликаты
        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("\n4. TreeSet (отсортирован по Comparable — по возрасту):");
        for (Human h : treeSet) {
            System.out.println("   " + h);
        }

        // ========== 5. TreeSet с компаратором HumanComparatorByLastName ==========
        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(humans); // Заполняем множество
        System.out.println("\n5. TreeSet с HumanComparatorByLastName (сортировка только по фамилии):");
        for (Human h : treeSetByLastName) {
            System.out.println("   " + h);
        }

        // ========== 6. TreeSet с анонимным компаратором по возрасту ==========
        // Анонимный класс Comparator — сортирует только по возрасту
        Set<Human> treeSetByAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge()); // Сравнение только по возрасту
            }
        });
        treeSetByAge.addAll(humans);
        System.out.println("\n6. TreeSet с анонимным компаратором по возрасту:");
        for (Human h : treeSetByAge) {
            System.out.println("   " + h);
        }

        /*
         * ========== 7. Объяснение различий в выводах коллекций ==========
         *
         * HashSet:
         *   - Не гарантирует никакого порядка элементов.
         *   - Удаляет дубликаты на основе equals() и hashCode().
         *   - Самый быстрый из Set-ов по операциям добавления/поиска.
         *
         * LinkedHashSet:
         *   - Сохраняет порядок, в котором элементы были добавлены.
         *   - Также удаляет дубликаты по equals/hashCode.
         *   - Чуть медленнее HashSet из-за поддержки связанного списка.
         *
         * TreeSet (с Comparable):
         *   - Всегда хранит элементы в отсортированном виде (по compareTo).
         *   - В нашем случае сортировка идёт по возрасту (а при равенстве — по фамилии/имени).
         *   - Дубликаты определяются через compareTo == 0 (а не через equals!).
         *   - Поэтому два разных человека с одинаковым возрастом/фамилией/именем
         *     могут считаться дубликатами и один из них будет отброшен.
         *
         * TreeSet с HumanComparatorByLastName:
         *   - Сортирует только по фамилии.
         *   - Люди с одинаковой фамилией считаются "равными" (compare == 0),
         *     поэтому в множество попадёт только один из них.
         *
         * TreeSet с анонимным компаратором по возрасту:
         *   - Сортирует только по возрасту.
         *   - Люди одного возраста считаются равными → в TreeSet останется
         *     только один человек каждого возраста.
         */
    }
}