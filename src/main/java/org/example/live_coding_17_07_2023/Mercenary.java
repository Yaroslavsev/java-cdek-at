package org.example.live_coding_17_07_2023;

import java.util.Objects;

public class Mercenary {
    private String name;
    private int age;
    private SpecializationEnum specialization;
    private double salary;

    public Mercenary(String name, int age, SpecializationEnum specialization, double salary) {
        this.name = name;
        this.age = age;
        this.specialization = specialization;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mercenary mercenary = (Mercenary) o;
        return name.equals(mercenary.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Mercenary{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", specialization=" + specialization +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SpecializationEnum getSpecialization() {
        return specialization;
    }

    public void setSpecialization(SpecializationEnum specialization) {
        this.specialization = specialization;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}