public class DefaultInterface {
	private static interface Foo {
		default int getValue() {
			return 42;
		}
	}

	private static class FooImpl implements Foo {
	}

	private static class FooImpl2 implements Foo {
		@Override
		public int getValue() {
			return 99;
		}
	}

	public static void main(String[] args) {
		Foo f1 = new FooImpl();
		Foo f2 = new FooImpl2();

		System.out.println("f1.getValue = " + f1.getValue());
		System.out.println("f2.getValue = " + f2.getValue());
	}
}
