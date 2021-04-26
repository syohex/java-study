public class FieldInitialize {
    private String name = "Yamada Taro";
    private int age = 42;

    public static void main(String[] args) {
        FieldInitialize f = new FieldInitialize();
        System.out.printf("name = %s, age = %d\n", f.name, f.age);
    }
}
