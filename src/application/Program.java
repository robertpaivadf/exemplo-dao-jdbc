package application;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		SellerDAO sellerDAO = DAOFactory.createSellerDAO();
		
		System.out.println("=== TESTE 1: seller findById ===");
		Seller seller = sellerDAO.findById(3);
		System.out.println(seller);
		System.out.println();
		
		System.out.println("=== TESTE 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDAO.findByDepartment(department);
		//System.out.println(Arrays.toString(list.toArray()));
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println();
		
		System.out.println("=== TESTE 3: seller findAll ===");		
		list = sellerDAO.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println();
		
		System.out.println("=== TESTE 4: seller insert ===");		
		Seller newSeller = new Seller(null, "Greg" , "greg@gmail.com", new Date(), 4000.0, department);
		sellerDAO.insert(newSeller);
		System.out.println("Inserted! New id= " + newSeller.getId());

		System.out.println("=== TESTE 5: seller update ===");		
		seller = sellerDAO.findById(1);
		seller.setName("Martha Waine");
		sellerDAO.update(seller);
		System.out.println("Update Completed!");

	}

}
