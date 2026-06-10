package $06_Serialization_And_Deserialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class NFSGame implements Serializable{
	String name;
	int level;
	long score;
	int life;
	
    public NFSGame(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
}

class RunSerialization {
    public static void main(String[] args) throws IOException {
		NFSGame userObj = new NFSGame("red", 10, 50000, 100);
		FileOutputStream fOut = new FileOutputStream("./serial.txt");
		
		ObjectOutputStream objOut = new ObjectOutputStream(fOut);
		
		objOut.writeObject(userObj);
		System.out.println("+++End+++");
	}
}

