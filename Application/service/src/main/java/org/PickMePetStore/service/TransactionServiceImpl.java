package org.PickMePetStore.service;

import java.util.List;

import org.PickMePetStore.persistence.model.PetModel;
import org.PickMePetStore.persistence.model.TransactionModel;
import org.PickMePetStore.persistence.model.UserModel;
import org.PickMePetStore.persistence.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private UserService userService;
	
	@Autowired
	private PetService petService;

	public TransactionModel create(TransactionModel transaction) {
		return transactionRepository.save(transaction);
	}

	public TransactionModel getById(int cartId) {
		return transactionRepository.findOne(cartId);
	}

	public void update(TransactionModel cart) {
		transactionRepository.save(cart);
	}

	public void delete(int cartId) {
		transactionRepository.delete(cartId);
	}

	public TransactionModel getActiveTransaction() {
		int userId = userService.getUserId();
		UserModel user = userService.findById(userId);
		List<TransactionModel> courses = transactionRepository.findByUserAndApproval(user, Cart.STATUS_UNFINISHED);
		return courses.get(0);
	}

	public List<TransactionModel> getPurchesedTransactions() {
		int userId = userService.getUserId();
		UserModel user = userService.findById(userId);
		return transactionRepository.findByUserAndApproval(user, Cart.STATUS_FINISHED);
	}

	public void addPetToTransaction(int petId){
		TransactionModel transaction = getActiveTransaction();
		if (transaction == null) {
			int userId = userService.getUserId();
			UserModel user = userService.findById(userId);
			transaction = create(new TransactionModel(user));
		}
		PetModel pet = petService.findPetById(petId);
		if (pet == null) {
			throw new IllegalArgumentException("pet is null");
		}
		transaction.addTransactionItem(pet);
		update(transaction);
	}

	@Override
	public void removePetFromTransaction(int petId) {
		TransactionModel transaction = getActiveTransaction();
		PetModel pet = petService.findPetById(petId);
		if (pet == null) {
			throw new IllegalArgumentException("pet is null");
		}
		transaction.removeTransactionItem(pet);
		update(transaction);
		
	}

	@Override
	public void clearAllPets() {
		TransactionModel transaction = getActiveTransaction();
		transaction.getPets().clear();
		transaction.setGrandTotal(0);
		update(transaction);
		
	}

	@Override
	public void checkout() {
		TransactionModel transaction = getActiveTransaction();
		transaction.setApproval("FINISHED");
		update(transaction);
		int userId = userService.getUserId();
		create(new TransactionModel(userService.findById(userId)));
	}
	
}
