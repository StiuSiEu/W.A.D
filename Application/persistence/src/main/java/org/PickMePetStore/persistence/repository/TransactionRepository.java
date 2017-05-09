package org.PickMePetStore.persistence.repository;

import java.util.List;

import org.PickMePetStore.persistence.model.TransactionModel;
import org.PickMePetStore.persistence.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionModel, Integer>{
	
	//@Query("SELECT t FROM Transaction t where t.user = :user and t.approval = :approval")
	//List<TransactionModel> findByUserIdAndApproval(@Param("user") UserModel user, @Param("approval") String approval);
	List<TransactionModel> findByUserAndApproval(UserModel user, String approval);
}
