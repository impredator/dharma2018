package com.dharma.java8.exercise;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class StreamMain {

    private static List<Student> register() {
        Student s1 = new Student(1L, "FeiZhen", Student.Gender.MALE, 100, LocalDate.of(2000, Month.JUNE, 12), Student.Department.EE);
        Student s2 = new Student(2L, "LiuYuHao", Student.Gender.MALE, 90, LocalDate.of(1999, Month.JANUARY, 25), Student.Department.CN);
        Student s3 = new Student(3L, "WangRu", Student.Gender.FEMALE, 130, LocalDate.of(1983, Month.JUNE, 13), Student.Department.AM);
        Student s4 = new Student(4L, "WenJiaChen", Student.Gender.MALE, 20, LocalDate.of(1999, Month.APRIL, 1), Student.Department.CN);
        Student s5 = new Student(5L, "FanChuang", Student.Gender.MALE, 10, LocalDate.of(1995, Month.DECEMBER, 12), Student.Department.CN);
        Student s6 = new Student(6L, "JiaBin", Student.Gender.MALE, 40, LocalDate.of(1995, Month.NOVEMBER, 22), Student.Department.CS);
        Student s7 = new Student(7L, "DongDaHai", Student.Gender.MALE, 70, LocalDate.of(1996, Month.JULY, 1), Student.Department.CN);
        Student s8 = new Student(8L, "LuoMing", Student.Gender.MALE, 80, LocalDate.of(1996, Month.JUNE, 25), Student.Department.CL);
        Student s9 = new Student(9L, "YangMin", Student.Gender.FEMALE, 76, LocalDate.of(1997, Month.SEPTEMBER, 19), Student.Department.CN);
        Student s10 = new Student(10L, "ZhangGuoHua", Student.Gender.MALE, 100, LocalDate.of(1998, Month.SEPTEMBER, 1), Student.Department.CN);
        Student s11 = new Student(11L, "GuZhuangZhuang", Student.Gender.MALE, 100, LocalDate.of(1995, Month.OCTOBER, 19), Student.Department.EL);

        return Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11);
    }

    private static void log(String prefix, Object content) {
        System.out.println(prefix + content);
    }

    public static void main(String[] args) {
        List<Student> students = register();
        System.out.println(students);

        //Total number of students
        long studentCount = students.stream()
//                .count()
                .mapToLong(s -> 1L)
                .sum();
        log("Total of students is: ", studentCount);

        //Total credits
        long totalCredits = students.stream()
                .mapToLong(Student::getCredit)
//                .sum();
                .reduce(0, Long::sum);
        log("Total credits is: ", totalCredits);

        //Students number by gender
        Map<Student.Gender, Long> groupCountByGender = students
                .stream()
                .collect(Collectors.groupingBy(
                        Student::getGender, Collectors.counting()));
        log("Student total by gender is: ", groupCountByGender);

        Optional<Student> maxCredit = students.stream()
                .max((s1, s2) -> s2.getCredit() - s1.getCredit());
        if (maxCredit.isPresent()) {
            log("Max credit is: ", maxCredit.get().getName());
        } else {
            log("Can not find max credit", "!");
        }

        Integer parallelSumCredit = students.parallelStream()
                .reduce(0,
                        (Integer partialSum, Student s) -> {
                            Integer middle = partialSum + s.getCredit();
                            System.out.println(Thread.currentThread().getName() + " " + s.getName() + " " + middle);
                            return middle;
                        },
                        (a, b) -> {
                            System.out.println(Thread.currentThread().getName() + " " + a + " " + b);
                            return a + b;
                        });

        log("The parallel sum credit is: ", parallelSumCredit);

        Integer sumCredit = students.stream()
                .reduce(0,
                        (Integer partialSum, Student s) -> {
                            Integer middle = partialSum + (Integer)s.getCredit();
                            System.out.println(Thread.currentThread().getName() + " " + s.getName() + " " + middle);
                            return middle;
                        },
                        (a, b) -> {
                            System.out.println(Thread.currentThread().getName() + "---" + a + "+" + b);
                            return null;
                        });

        log("The sum credit is: ", sumCredit);

        boolean allMale = students.stream().allMatch(Student::isMale);
        log("If all male student? ", allMale);

        boolean anyFemale = students.stream().anyMatch(Student::isFemale);
        log("If any female student? ", anyFemale);

        LongSummaryStatistics creditStats = students.stream()
                .map(Student::getCredit)
                .collect(LongSummaryStatistics::new,
                         LongSummaryStatistics::accept,
                         LongSummaryStatistics::combine);
        log("Stats: ", creditStats);

        LongSummaryStatistics creditStats2 = students.stream()
                .collect(Collectors.summarizingLong(Student::getCredit));
        log("Stats: ", creditStats2);

        Double creditAvg = students.stream()
                .collect(Collectors.averagingDouble(Student::getCredit));
        log("Credit average: ", creditAvg);

        Map<Long, String> idNameMap = students.stream()
                .collect(Collectors.toMap(Student::getId, Student::getName));
        log("<Id, Name>: ", idNameMap);

        String names = students.stream()
                .map(Student::getName)
                .collect(Collectors.joining(", ", "Dharma 2018: ", " !Good job"));
        log("", names);

        Optional<Student> hasFemale = students.stream()
                .filter(Student::isFemale)
                .findAny();
        if(hasFemale.isPresent()) {
            log("Yes, we have female students: ", hasFemale.get().getName());
        } else {
            log("No, we have only male students", "");
        }
    }
}
