package secondAssgn;

import java.util.List;  
import java.io.File;  
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Unmarshaller;  
import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;  
  
@XmlRootElement  
class Employee {  
	private int id;  
	private String firstName;
	private String lastName;
	private Department department;  
	public Employee() {}  
	public Employee(int id, String firstName,String lastName) {  
	    super();  
	    this.id = id;  
	    this.firstName = firstName;  
	    this.lastName=lastName;
//	    this.department = department;
	    
	}  
	@XmlAttribute  
	public int getId() {  
	    return id;  
	}  
	public void setId(int id) {  
	    this.id = id;  
	}  
	@XmlAttribute
	public String getFirstname() {  
	    return firstName;  
	}  
	public void setFirstname(String firstName) {  
	    this.firstName = firstName;  
	}    
	@XmlAttribute
	public String getLastname() {  
	    return lastName;  
	}  
	public void setLastname(String lastName) {  
	    this.lastName = lastName;  
	}
//	@XmlAttribute
//	public Department getDepartment() {  
//	    return department;  
//	}  
//	public void setDepartment(Department department) {  
//	    this.department = department;  
//	}
	
}  

class Department {  
	private int id;  
	private String name;   
	public Department() {}  
	public Department(int id, String name) {  
	    super();  
	    this.id = id;  
	    this.name = name;  
	}  
	public int getId() {  
	    return id;  
	}  
	public void setId(int id) {  
	    this.id = id;  
	}  
	public String getName() {  
	    return name;  
	}  
	public void setName(String name) {  
	    this.name = name;  
	}  
  
}  
public class XMLtoJAVA {
	 public static void main(String[] args) {  
	     try {  
	   
	        File file = new File("employee.xml");  
	        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);  
	   
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	        Employee emp= (Employee) jaxbUnmarshaller.unmarshal(file);  
	          
	        System.out.println(emp.getId()+" "+emp.getFirstname()+" "+emp.getLastname());  
	        System.out.println("Department:");  
//	        Department dp=emp.getDepartment();   
//	        System.out.println(dp.getId()+" "+dp.getName());  
	   
	      } catch (JAXBException e) {  
	        e.printStackTrace();  
	      }  
	   
	    }  

}
