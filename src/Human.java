/**
 * Задание №3. Класс Human (человек).
 * Содержит поля: имя, фамилия, возраст.
 * Реализует интерфейс Comparable для сравнения по возрасту (natural order).
 */
public class Human implements Comparable<Human> {

    private String name;     // Имя
    private String lastName; // Фамилия
    private int age;         // Возраст

    /**
     * Конструктор класса Human.
     * @param name     имя
     * @param lastName фамилия
     * @param age      возраст
     */
    public Human(String name, String lastName, int age) {
        this.name = name;         // Присваиваем имя
        this.lastName = lastName; // Присваиваем фамилию
        this.age = age;           // Присваиваем возраст
    }

    // ========== Геттеры ==========
    public String getName() {
        return name; // Возвращаем имя
    }

    public String getLastName() {
        return lastName; // Возвращаем фамилию
    }

    public int getAge() {
        return age; // Возвращаем возраст
    }

    /**
     * Реализация Comparable.
     * Сравниваем людей по возрасту (по возрастанию).
     * Если возраст одинаковый — сравниваем по фамилии, затем по имени.
     */
    @Override
    public int compareTo(Human other) {
        // Сначала сравниваем по возрасту
        int ageCompare = Integer.compare(this.age, other.age);
        if (ageCompare != 0) {
            return ageCompare; // Если возраст разный — возвращаем результат сравнения
        }
        // Если возраст одинаковый — сравниваем по фамилии
        int lastNameCompare = this.lastName.compareTo(other.lastName);
        if (lastNameCompare != 0) {
            return lastNameCompare;
        }
        // Если и фамилия одинаковая — сравниваем по имени
        return this.name.compareTo(other.name);
    }

    /**
     * equals — нужен для корректной работы HashSet и LinkedHashSet.
     * Два объекта Human равны, если совпадают имя, фамилия и возраст.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;                    // Один и тот же объект
        if (obj == null || getClass() != obj.getClass()) return false; // Разные классы
        Human human = (Human) obj;
        return age == human.age                          // Возраст совпадает
                && name.equals(human.name)               // Имя совпадает
                && lastName.equals(human.lastName);      // Фамилия совпадает
    }

    /**
     * hashCode — обязателен при переопределении equals.
     * Используется в HashSet / HashMap.
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();                    // Хеш имени
        result = 31 * result + lastName.hashCode();      // Добавляем хеш фамилии
        result = 31 * result + age;                      // Добавляем возраст
        return result;
    }

    /**
     * Удобный вывод объекта в консоль.
     */
    @Override
    public String toString() {
        return name + " " + lastName + " (" + age + " лет)";
    }
}