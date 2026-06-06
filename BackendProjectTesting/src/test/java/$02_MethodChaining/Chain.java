package $02_MethodChaining;

public class Chain {
    public Chain a() {
    	System.out.print("Executed method a");
    	return new Chain();
    }
    public Chain b() {
    	System.out.print("Executed method a");
    	return new Chain();
    }
    public Chain2 c() {
    	System.out.print("Executed method a");
    	return new Chain2();
    }
}
