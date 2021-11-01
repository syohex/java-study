package gson01;

// test missing property handling of Gson
public class App {
    public static void main(String[] args) {
        String json1 = "{\"name\": \"Taro\", \"age\": 99}";
        String json2 = "{\"name\": \"Taro\"}";
        String json3 = "{\"age\": 99}";

        Sample s1 = Sample.fromJson(json1);
        Sample s2 = Sample.fromJson(json2);
        Sample s3 = Sample.fromJson(json3);

        System.out.println("#### s1 ####");
        s1.print(); // name=Taro, age=99
        System.out.println("#### s2 ####");
        s2.print(); // name=Taro, age=0
        System.out.println("#### s3 ####");
        s3.print(); // name=null, age=99

        String str1 = s1.toJson();
        String str2 = s2.toJson();
        String str3 = s3.toJson();

        System.out.println("#### str1 ####");
        System.out.println(str1); // {"name":"Taro","age":99}
        System.out.println("#### str2 ####");
        System.out.println(str2); // {"name":"Taro","age":0}
        System.out.println("#### str3 ####");
        System.out.println(str3); // {"age":99}
    }
}
