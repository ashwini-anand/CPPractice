class A {
  {
    System.out.println(1);
  }
}

class B extends A {
  static {
    System.out.println(2);
  }
}

class C extends B {
  static {
    System.out.println(3);
  }
}

public class BlockTest {
  public static void main(String[] args) {
    C c = new C();
  }
}

