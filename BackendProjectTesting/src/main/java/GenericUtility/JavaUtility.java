package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
     public int getRandomNum() {
    	 Random random = new Random();
    	 int ran = random.nextInt(5000);
    	 return ran;
     }
     
     public String getSystemDate() {
    	 String date =new SimpleDateFormat("dd-MM-yy").format(new Date());
    	 
    	 return date;
     }
}
