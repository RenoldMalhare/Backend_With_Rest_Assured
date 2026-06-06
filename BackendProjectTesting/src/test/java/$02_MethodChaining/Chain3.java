package $02_MethodChaining;

public class Chain3 {
    public static Chain3 a() {
    	System.out.println("Executed method a form chain3");
    	return new Chain3();
    }
    public static Chain3 b() {
    	System.out.println("Executed method a form chain3");
    	return new Chain3();
    }
    public static Chain2 c() {
    	System.out.println("Executed method a form chain3");
    	return new Chain2();
    }
}
