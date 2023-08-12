package org.example.live_coding_17_07_2023;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Mercenary> mercenaries = new ArrayList<>();

        mercenaries.add(new Mercenary("Artem", 33, SpecializationEnum.COMMANDOR, 1000));
        mercenaries.add(new Mercenary("Kate", 30, SpecializationEnum.SNIPER, 324));
        mercenaries.add(new Mercenary("Denis", 12, SpecializationEnum.ARTILLERIST, 12345));
        mercenaries.add(new Mercenary("Egor", 10, SpecializationEnum.ARTILLERIST, 6574));
        mercenaries.add(new Mercenary("Olga", 59, SpecializationEnum.ARTILLERIST, 778798));
        mercenaries.add(new Mercenary("Ilya", 1, SpecializationEnum.DRIVER, 10));

        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Kate", 99));
        persons.add(new Person("Egor", 98));
        persons.add(new Person("Ilya", 97));
        persons.add(new Person("Ivan", 96));
        persons.add(new Person("Victor", 95));


        System.out.println(mercenaries.stream().filter(mercenary -> mercenary.getAge() > 20).count());
        System.out.println(mercenaries
                .stream()
                .filter(m -> m.getSpecialization().equals(SpecializationEnum.ARTILLERIST))
                .map(merc -> merc.getSalary())
                .reduce((sal1, sal2) -> sal1 + sal2).get());

        List<Person> personList = mercenaries
                .parallelStream()
                .map(merc -> new Person(merc.getName(), merc.getAge()))
                .collect(Collectors.toList());
        System.out.println(personList);

        Mercenary older = mercenaries.stream().max((m1, m2) -> m1.getAge() - m2.getAge()).get();
        System.out.println(older);

        mercenaries
                .stream()
                .filter(m -> m.getSpecialization().equals(SpecializationEnum.ARTILLERIST))
                .map(merc -> merc.getSalary())
                .forEach(cont -> System.out.println(cont));

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("-------------------------------------ЗАДАНИЕ 1-------------------------------------------");
        System.out.println("Всех наемников в алфавитном порядке, у которых специализация не командир, убавить им зп на 1000 и вывести на консоль");
        System.out.println(" ");

        List<Mercenary> mercsNaturalNonCommanderWaithSalaryMinus1000 = mercenaries
                .stream()
                .filter(merc -> !merc.getSpecialization().equals(SpecializationEnum.COMMANDOR))
                .sorted(Comparator.comparing(Mercenary::getName))
                .map(merc -> new Mercenary(merc.getName(), merc.getAge(), merc.getSpecialization(), merc.getSalary() - 1000))
                .collect(Collectors.toList());
        System.out.println(mercsNaturalNonCommanderWaithSalaryMinus1000);

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("-------------------------------------ЗАДАНИЕ 2-------------------------------------------");
        System.out.println("Вывести на экран пары Наемник-Человек, где ключом будет общее имя");
        System.out.println(" ");

        List<Mercenary> mercsWithEqualNameAsPers = mercenaries
                .stream()
                .filter(pers -> persons.stream().anyMatch(merc -> merc.getName().equals(pers.getName())))
                .collect(Collectors.toList());

        List<Person> persWithEqualNameAsMercs = persons
                .stream()
                .filter(merc -> mercenaries.stream().anyMatch(pers -> pers.getName().equals(merc.getName())))
                .collect(Collectors.toList());

        HashMap<Mercenary, Person> mapEqualNamesMercAndPers = new HashMap<>();
        for (int i = 0; i < mercsWithEqualNameAsPers.size(); i++) {
            mapEqualNamesMercAndPers.put(mercsWithEqualNameAsPers.get(i), persWithEqualNameAsMercs.get(i));
        }
        System.out.println(mapEqualNamesMercAndPers);

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("-------------------------------------ЗАДАНИЕ 3-------------------------------------------");
        System.out.println("Сгруппировать наемников по величине зп и вывести на экран отдельно (от 1 до 1000, от 1000 до 10000, от 17000)");
        System.out.println(" ");

        List<Mercenary> mercsSalaryFrom1to1k = mercenaries
                .stream()
                .filter(merc -> merc.getSalary() >= 1 && merc.getSalary() <= 1000)
                .collect(Collectors.toList());

        HashMap<String, List<Mercenary>> mapFrom1to1k = new HashMap<>();
        mapFrom1to1k.put("Mercenaries with salary from 1 to 1 000\n", mercsSalaryFrom1to1k);
        System.out.println(mapFrom1to1k);
        System.out.println(" ");

        List<Mercenary> mercsSalaryFrom1kTo10k = mercenaries
                .stream()
                .filter(merc -> merc.getSalary() > 1000 && merc.getSalary() <= 10000)
                .collect(Collectors.toList());

        HashMap<String, List<Mercenary>> mapFrom1kTo10k = new HashMap<>();
        mapFrom1kTo10k.put("Mercenaries with salary from 1 000 to 10 000\n", mercsSalaryFrom1kTo10k);
        System.out.println(mapFrom1kTo10k);
        System.out.println(" ");

        List<Mercenary> mercsSalaryFrom17k = mercenaries
                .stream()
                .filter(merc -> merc.getSalary() >= 17000)
                .collect(Collectors.toList());

        HashMap<String, List<Mercenary>> mapFrom17k = new HashMap<>();
        mapFrom17k.put("Mercenaries with salary from 17 000\n", mercsSalaryFrom17k);
        System.out.println(mapFrom17k);
        System.out.println(" ");
    }
}
