# Лабораторная работа № 2. Коллекции и компараторы в Java

**Автор:** Луцкий Максим Сергеевич

**Группа:** КБ-251

## Цель работы

Научиться работать с коллекциями Java: применять методы `Collections`, перебирать элементы через `Iterator`, задавать порядок с помощью `Comparable` и `Comparator`, использовать множества и подсчитывать данные в `HashMap`.

## Структура проекта
src/

├── Task1_CollectionsMethods.java   — Задание №1 (методы Collections)

├── PrimesGenerator.java            — Задание №2 (генератор простых чисел)

├── PrimesGeneratorTest.java        — Задание №2 (тестовый класс)

├── Human.java                      — Задание №3 (класс Human + Comparable)

├── HumanComparatorByLastName.java  — Задание №3 (компаратор по фамилии)

├── Task3_SetsAndComparators.java   — Задание №3 (демонстрация Set-ов)

├── Task4_WordFrequency.java        — Задание №4 (частота слов)

└── Task5_SwapKeysValues.java       — Задание №5 (обмен ключей и значений)

## Как запустить

```bash
javac -encoding UTF-8 -d out src/*.java

Ex 1. java -cp out Task1_CollectionsMethods
Ex 2. java -cp out PrimesGeneratorTest
Ex 3. java -cp out Task3_SetsAndComparators
Ex 4. java -cp out Task4_WordFrequency
Ex 5. java -cp out Task5_SwapKeysValues