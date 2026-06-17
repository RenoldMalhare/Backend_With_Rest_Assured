package $17_MockingSolutionStubs;

import org.mockito.Mockito;

public class $01_CreatingMockingSolution {
    public static void main(String[] args) {
    	PANCard obj = PANCard.getMockObject();
    	System.out.println(obj.isvalid("ABCDE1234A"));
    	System.out.println(obj.isvalid("ABCDE1234B"));
    	System.out.println(obj.isvalid("ABCDE1234c"));
    	System.out.println(obj.isvalid("ABCDE1234L"));

    }
}

class PANCard{
	 public String isvalid(String panCard) {
		 if(panCard.matches("[A-Z] {5}[0-9]{4}[A-Z]")==true) {
			 return "valid pan";

		 }else {
			 return "is invalid pan";
		 }
	 }
	 
	 public static PANCard getMockObject() {
		 PANCard mocObj = Mockito.mock(PANCard.class);
		 
		 Mockito.when(mocObj.isvalid("ABCDE1234A")).thenReturn("valid pan card");
		 Mockito.when(mocObj.isvalid("ABCDE1234B")).thenReturn("valid pan card");
		 Mockito.when(mocObj.isvalid("ABCDE1234c")).thenReturn("invalid pan card");
		 
		 return mocObj;
	 }
}