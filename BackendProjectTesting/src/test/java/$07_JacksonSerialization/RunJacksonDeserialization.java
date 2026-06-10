package $07_JacksonSerialization;

import java.io.File;

import tools.jackson.databind.ObjectMapper;

public class RunJacksonDeserialization {
    public static void main(String[] args) {
		ObjectMapper objM = new ObjectMapper();
		
		Project pObj = objM.readValue(new File("./jacksonSerialization.json"), Project.class);
		
		System.out.println(pObj.getCreatedBy());
		System.out.println(pObj.getProjectName());
		System.out.println(pObj.getStatus());
		System.out.println(pObj.getTeamSize());
	}
}
