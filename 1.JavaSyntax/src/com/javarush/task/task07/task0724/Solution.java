package com.javarush.task.task07.task0724;
/* 
Семейная перепись
Создай класс Human с полями имя(String), пол(boolean), возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Добавить в класс Human поля: имя(String), пол(boolean), возраст(int), отец(Human), мать(Human).
3. Добавить в класс конструктор public Human(String name, boolean sex, int age).
4. Добавить в класс конструктор public Human(String name, boolean sex, int age, Human father, Human mother).
5. Создай 9 разных объектов типа Human (4 объекта без отца и матери и 5 объектов с ними)).
6. Выведи созданные объекты на экран.
*/
public class Solution {
    public static void main(String[] args) {
        for(int i=0; i<4; i++){
            Human gay = new Human("Vanya", true, 15);
            System.out.println(gay);
        }
        for(int i=0; i<5; i++){
            Human father = new Human("Petya");
            Human mother = new Human("Tamara");
            Human gay = new Human("Vasya", true, 15, father, mother);
            System.out.println(gay);
        }
    }
    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;
        public  Human(String name){
            this.name=name;
        }
        public  Human(String name, boolean sex, int age){
            this.name=name;
            this.sex=sex;
            this.age=age;
        }
        public  Human(String name, boolean sex, int age, Human father, Human mother){
            this.name=name;
            this.sex=sex;
            this.age=age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;
            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }
            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }
            return text;
        }
    }
}