package application;

import java.util.List;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
				
		DepartmentDAO departmentDAO = DAOFactory.createDepartmentDAO();
		
		System.out.println("=== TESTE 1: department findById ===");
		Department dep = departmentDAO.findById(1);
		System.out.println(dep);
		System.out.println();
		
		
		System.out.println("=== TESTE 2: department findAll ===");		
		List<Department> list = departmentDAO.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		System.out.println();
		
		System.out.println("=== TESTE 3: department insert ===");		
		Department newDepartment = new Department(null, "Music");
		departmentDAO.insert(newDepartment);
		System.out.println("Inserted! New id= " + newDepartment.getId());

		System.out.println("=== TESTE 4: department update ===");		
		newDepartment = departmentDAO.findById(8);
		newDepartment.setName("Tools");
		departmentDAO.update(newDepartment);
		System.out.println("Update Completed!");
		
		
		System.out.println("=== TESTE 5: department delete ===");	
		departmentDAO.deleteById(10);
		System.out.println("Delete Completed!");
		
		
	}

}
