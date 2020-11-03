package com.rsh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rsh.models.ShoppingList;

@Repository
public interface ShoppingListRepository extends CrudRepository<ShoppingList,Integer> {

	// getAllShoppingLists 
	// getShoppingList(int shoppingListId) 
	// updateShoppingList(ShoppingList shoppingList) 
}
