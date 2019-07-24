package ru.eltex.app.lab1;

public interface ICrudAction {
    /**
     * create - заполнение объекта случайными значениями и инкремент счётчика
     * read – вывод данных на экран.
     * update – ввод данных с клавиатуры.
     * delete – принудительное зануление данных в объекте и декремент счетчика.
     */

    void create(); //заполнение объекта случайными значениями и инкремент счётчика
    void read(); //вывод данных на экран
    void update(); //ввод данных с клавиатуры
    void delete(); //принудительное зануление данных в объекте и декремент счетчика
}