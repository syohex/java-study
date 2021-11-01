package gson01;

import com.google.gson.Gson;

public class Sample {
    private String name;
    private int age;

    public Sample(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void print() {
        System.out.printf("name=%s, age=%d\n", name, age);
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static Sample fromJson(String str) {
        Gson gson = new Gson();
        return gson.fromJson(str, Sample.class);
    }
}
