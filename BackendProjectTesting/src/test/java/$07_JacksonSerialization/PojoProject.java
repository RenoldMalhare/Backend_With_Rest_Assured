package $07_JacksonSerialization;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import tools.jackson.databind.ObjectMapper;

public class PojoProject {
     String projectName;
     String projectStatus;
     List<String> teammembers;
     ProjectManager pmObj;
     
	 public PojoProject(String projectName, String projectStatus, List<String> teammembers, ProjectManager pmObj) {
		super();
		this.projectName = projectName;
		this.projectStatus = projectStatus;
		this.teammembers = teammembers;
		this.pmObj = pmObj;
	 }

	 public String getProjectName() {
		 return projectName;
	 }

	 public void setProjectName(String projectName) {
		 this.projectName = projectName;
	 }

	 public String getProjectStatus() {
		 return projectStatus;
	 }

	 public void setProjectStatus(String projectStatus) {
		 this.projectStatus = projectStatus;
	 }

	 public List<String> getTeammembers() {
		 return teammembers;
	 }

	 public void setTeammembers(List<String> teammembers) {
		 this.teammembers = teammembers;
	 }

	 public ProjectManager getPmObj() {
		 return pmObj;
	 }

	 public void setPmObj(ProjectManager pmObj) {
		 this.pmObj = pmObj;
	 }
     
     
}
class ProjectManager{
	String name;
	String id;
	public ProjectManager(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}

class RunPojoCreate{
	public static void main(String[] args) {
		List<String> lst = new ArrayList<String>();
	    lst.add("Red");
	    lst.add("dev");
	    lst.add("mic");
	    
	    
		PojoProject pObj = new PojoProject("RedProject", "Created", lst, new ProjectManager("Red","pm02"));	
		
//		System.out.println(pObj.projectName);
		
		ObjectMapper obj = new ObjectMapper();
		obj.writeValue(new File("./src/test/resources/pojoClassJson.json"), pObj);
	}
}







