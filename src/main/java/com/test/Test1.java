package com.test;

import java.util.*;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {

        List<Integer> list= Arrays.asList(1,null,3,4,5,6,7,8,9);
        list.stream().filter(x->x!=null).filter(x->x %2==0).map(x->x*2).forEach(System.out::println);


        List<String> ls7=Arrays.asList("aa","vv","bb","aa",null);
        ls7.stream().filter(x->Collections.frequency(ls7,x)==1).forEach(System.out::println);
         Optional<String> ol= ls7.stream().filter(x-> Collections.frequency(ls7,x) ==1).findFirst();
        System.out.println(ol);

        String str="I m shaikh Raees";
        str=str.toLowerCase().replaceAll("\\s","");

        List<Character> lc=str.chars().mapToObj(c->(char)c).toList();
        lc.stream().filter(x->Collections.frequency(lc,x)==1).forEach(System.out::println);
        System.out.println(lc);
        System.out.println("-----------");
        Map<String,Integer> ms=new HashMap<>();
        ms.put("A",1);
        ms.put("B",2);
        ms.put("C",3);

        ms.entrySet().stream()
                .forEach(System.out::println);

        Employee emp=new Employee(1,"Raees",50000,"Kurla", "IT");

        List<Employee> lemp= Arrays.asList(new Employee(1,"Raees",50000,"Kurla", "IT"),
                new Employee(2,"R1",60000,"Sion", "Sales"),
                new Employee(3,"R3",70000,"Matunga", "IT")

        );

        lemp.stream().forEach(System.out::println);
        System.out.println("----------------");
        Map<String,List<Employee>> memp=lemp.stream().filter(x->x.getSalary()>10000).collect(Collectors.groupingBy(Employee::getName));
                memp.entrySet().forEach(System.out::println);
        System.out.println("----------------");
        Map<String,List<Employee>> memp1=lemp.stream().filter(x->x.getSalary()>10000).collect(Collectors.groupingBy(Employee::getName));
        memp1.forEach((k,v) -> System.out.println(k +" -> "+ v));







    }
}
