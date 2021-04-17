package com.javarush.task.task21.task2109;

import java.util.Objects;

/*
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        protected int i;
        protected int j;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof A)) return false;
            A a = (A) o;
            return getI() == a.getI() &&
                    getJ() == a.getJ();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getI(), getJ());
        }

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }
        public Object clone() throws CloneNotSupportedException {
            return this.clone();
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A{
        protected String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof B)) return false;
            if (!super.equals(o)) return false;
            B b = (B) o;
            return Objects.equals(getName(), b.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), getName());
        }

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }
        public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B implements Cloneable{
        public C(int i, int j, String name) {
            super(i, j, name);
        }
        public Object clone(){
            return new C(super.i,super.j,super.name);
        }
    }

    public static void main(String[] args) {

    }
}
