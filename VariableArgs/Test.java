public class Test {
    private static void print(String... strings) {
        int i = 0;
        for (String s : strings) {
             System.out.format("%d: %s\n", i, s);
             i++;
        }
    }
    public static void main(String[] args) {
        print("apple", "orange", "banana");

        String[] strs = new String[3];
        strs[0] = "Foo";
        strs[1] = "Bar";
        strs[2] = "Baz";
        print(strs);
    }
}
