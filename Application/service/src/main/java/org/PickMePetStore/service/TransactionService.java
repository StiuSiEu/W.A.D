package org.PickMePetStore.service;

import java.util.List;

import org.PickMePetStore.persistence.model.TransactionModel;


public interface TransactionService {

	TransactionModel create(TransactionModel transaction);

	TransactionModel getById(int cartId);

	void update(TransactionModel cart);

	void delete(int cartId);

	TransactionModel getActiveTransaction();

	List<TransactionModel> getPurchesedTransactions();

	void addPetToTransaction(int petId);
	
	void removePetFromTransaction(int petId);
	
	void clearAllPets();

	void checkout();
}
