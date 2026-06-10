package $06_Serialization_And_Deserialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RunDeSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream input = new FileInputStream("./serial.txt");
		
		ObjectInputStream objIn = new ObjectInputStream(input);
		NFSGame userObj = (NFSGame) objIn.readObject();
		
		System.out.println(userObj.name);
		System.out.println(userObj.level);
		System.out.println(userObj.score);
		System.out.println(userObj.life);
	}
}
