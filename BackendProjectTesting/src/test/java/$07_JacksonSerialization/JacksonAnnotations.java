package $07_JacksonSerialization;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import tools.jackson.databind.ObjectMapper;

@JsonPropertyOrder(value = { "createdBy", "projectName", "status", "teamSize" })

@JsonIgnoreProperties(value = { "teamSize" }, allowSetters = true)

public class JacksonAnnotations {   //pojo class plain old java object
	     private String projectName;
	     @JsonProperty(value = "created By")
	     private String createdBy;
	     private int teamSize;
	     private String status;
	     
	     private JacksonAnnotations() {}

		 public JacksonAnnotations(String projectName, String createdBy, int teamSize, String status) {
			super();
			this.projectName = projectName;
			this.createdBy = createdBy;
			this.teamSize = teamSize;
			this.status = status;
		 }

		 public String getProjectName() {
			 return projectName;
		 }

		 public void setProjectName(String projectName) {
			 this.projectName = projectName;
		 }

		 public String getCreatedBy() {
			 return createdBy;
		 }

		 public void setCreatedBy(String createdBy) {
			 this.createdBy = createdBy;
		 }

		 public int getTeamSize() {
			 return teamSize;
		 }

		 public void setTeamSize(int teamSize) {
			 this.teamSize = teamSize;
		 }

		 public String getStatus() {
			 return status;
		 }

		 public void setStatus(String status) {
			 this.status = status;
		 };     
	}

    class RunJacksonSerial{
	     public static void main(String[] args) {
			 JacksonAnnotations pobj = new JacksonAnnotations("Orange", "REd", 20, "Created");

	    	 ObjectMapper objM = new ObjectMapper();
	         objM.writeValue(new File("./jacksonAnnotationSerial.json"), pobj);
	        
	         System.out.println("====End====");
	     }	
}
