package com.javarush.task.task08.task0824;

import java.util.ArrayList;

/*
Собираем семейство
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Выведи все объекты Human на экран (Подсказка: используй метод toString() класса Human).
Требования:
1. Программа должна выводить текст на экран.
2. Класс Human должен содержать четыре поля.
3. Класс Human должен содержать один метод.
4. Класс Solution должен содержать один метод.
5. Программа должна создавать объекты и заполнять их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей и выводить все объекты Human на экран.
*/
public class Solution {
    public static void main(String[] args) {
        ArrayList<Human> children = new ArrayList<>();
        Human boy = new Human("Ваня", true, 12, children);
        Human girl1 = new Human("Катя", false, 18, children);
        Human girl2 = new Human("Света", false, 16, children);
        System.out.println(boy);
        System.out.println(girl1);
        System.out.println(girl2);
        children.add(0,boy);
        children.add(1,girl1);
        children.add(2,girl2);
        Human mother = new Human("Анна", false, 38, children);
        Human father = new Human("Петр", true, 42, children);
        System.out.println(mother);
        System.out.println(father);
        children.remove(2);
        children.remove(1);
        children.remove(0);
        children.add(0,father);
        Human grandmother1 = new Human("Тамара", false, 85, children);
        Human grandfather1 = new Human("Василий", true, 85, children);
        System.out.println(grandmother1);
        System.out.println(grandfather1);
        children.remove(0);
        children.add(0,mother);
        Human grandmother2 = new Human("Татьяна", false, 75, children);
        Human grandfather2 = new Human("Игорь", true, 75, children);
        System.out.println(grandmother2);
        System.out.println(grandfather2);
    }
    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.children=children;
        }
        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;
            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;
                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
