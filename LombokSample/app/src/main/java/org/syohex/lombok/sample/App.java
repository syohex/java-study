package org.syohex.lombok.sample;

import lombok.Builder;
import lombok.Getter;

public class App {
    @Builder
    private static class Person {
        @Getter
        private String name;
        @Getter
        private int age;
    }

    public static void main(String[] args) {
        Person person = Person.builder().name("Yamada").age(42).build();
        System.out.printf("name=%s, age=%d\n", person.getName(), person.getAge());
    }
}
