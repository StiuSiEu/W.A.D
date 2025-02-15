package org.PickMePetStore.persistence.repository;

import org.PickMePetStore.persistence.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer>{
	
	UserModel findByUsername(String username);
}
