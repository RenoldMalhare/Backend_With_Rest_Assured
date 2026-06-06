package $02_MethodChaining;

import static $02_MethodChaining.Chain3.*;

import org.testng.annotations.Test;
public class Run {
    @Test
    public void chainTest() {
    	Chain ch = new Chain();
    	String data =ch.a().b().c().d();
    	System.out.println(data);
    	
    	String da = a().b().c().d();
    	System.out.println(da);
    	
    }
}
