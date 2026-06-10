package $07_JacksonSerialization;

import java.io.File;


import tools.jackson.databind.ObjectMapper;

public class Project {//pojo class plain old java object
     private String projectName;
     private String createdBy;
     private int teamSize;
     private String status;
     
     private Project() {}

	 public Project(String projectName, String createdBy, int teamSize, String status) {
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

class RunJacksonSerialization{
     public static void main(String[] args) {
		 Project pobj = new Project("Orange", "REd", 20, "Created");
		 
         ObjectMapper objM = new ObjectMapper();
         objM.writeValue(new File("./jacksonSerialization.json"), pobj);
         
         System.out.println("====end====");
     }	
}