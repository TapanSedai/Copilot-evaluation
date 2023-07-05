package copilotcalculator.tests;

public class Assertions {

    public static void assertEquals(int a, int b) {
        if (a != b) {
            throw new AssertionError("Expected " + a + " but got " + b);
        }
    }

    public static void assertEquals(String a, String b) {
        if (!a.equals(b)) {
            throw new AssertionError("Expected " + a + " but got " + b);
        }
    }

    public static void assertEquals(boolean a, boolean b) {
        if (a != b) {
            throw new AssertionError("Expected " + a + " but got " + b);
        }
    }

    public static void assertEquals(double a, double b) {
        if (a != b) {
            throw new AssertionError("Expected " + a + " but got " + b);
        }
    }

    public static void assertEquals(float a, float b) {
        if (a != b) {
            throw new AssertionError("Expected " + a + " but got " + b);
        }
    }

    public static void assertEquals(long a, long b) {
        if (a != b) {
            throw new AssertionError("Expected " + a + " but got " + b);
        }
    }

    public static void assertEquals(short a, short b) {
        if (a != b) {
            throw new AssertionError("Expected " + a + " but got " + b);
        }
    }

    public static void assertEquals(byte a, byte b) {
        if (a != b) {
            throw new AssertionError("Expected " + a + " but got " + b);
        }
    }

    public static void assertNull(Object a) {
        if (a != null) {
            throw new AssertionError("Expected null but got " + a);
        }
    }

    public static void assertNotNull(Object a) {
        if (a == null) {
            throw new AssertionError("Expected not null but got " + a);
        }
    }

    public static void assertTrue(boolean a) {
        if (!a) {
            throw new AssertionError("Expected true but got false");
        }
    }

    public static void assertFalse(boolean a) {
        if (a) {
            throw new AssertionError("Expected false but got true");
        }
    }

}
