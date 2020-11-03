package com.rsh.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsh.models.ShoppingList;
import com.rsh.repository.ShoppingListRepository;

@Service 
public class ShoppingListService {
	
	@Autowired
	private ShoppingListRepository repository; 

	private List<ShoppingList> shoppingLists;
	
	public ShoppingListService() {
		
		this.shoppingLists = new ArrayList<ShoppingList>(); 
		
		this.shoppingLists.add(new ShoppingList(1,"MVideo")); 
		this.shoppingLists.add(new ShoppingList(2,"Eldorado"));
		this.shoppingLists.add(new ShoppingList(3,"DNS")); 
		
	} 
	
	public void deleteShoppingList(int shoppingListId) {
		
		ShoppingList shoppingList = this.repository.findById(shoppingListId).get();
		this.repository.delete(shoppingList);

	}
	
	public void updateShoppingList(ShoppingList shoppingList) {
		
		ShoppingList persistedShoppingList = getShoppingListById(shoppingList.getShoppingListId());
		persistedShoppingList.setTitle(shoppingList.getTitle());
		this.repository.save(persistedShoppingList);
	}
	
	public void addShoppingList(ShoppingList shoppingList) {
		this.repository.save(shoppingList);
	}
	
	public ShoppingList getShoppingListById(int shoppingListId) {
		
		return this.repository.findById(shoppingListId).get();	
	}

	public List<ShoppingList> getAllShoppingLists() {
		
		List<ShoppingList> shoppingLists = new ArrayList<>(); 
		this.repository.findAll()
		.forEach(shoppingLists::add);
		
		return shoppingLists; 
		
		//return this.shoppingLists; 
	}
	
//	public void deleteShoppingList(int shoppingListId) {
//		
//		ShoppingList shoppingList = getShoppingListById(shoppingListId); 
//		this.shoppingLists.remove(shoppingList);
//	}
//	
//	public void addShoppingList(ShoppingList shoppingList) {
//		this.shoppingLists.add(shoppingList);
//	}
//	
//	public ShoppingList getShoppingListById(int shoppingListId) {
//		return this.shoppingLists.stream().filter(x -> x.getShoppingListId() == shoppingListId).findFirst().get();	
//	}
//
//	public List<ShoppingList> getAllShoppingLists() {
//		return this.shoppingLists; 
//	}
	
}

