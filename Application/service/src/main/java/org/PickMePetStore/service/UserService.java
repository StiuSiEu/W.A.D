package org.PickMePetStore.service;

import java.util.Set;

import org.PickMePetStore.persistence.model.PetModel;
import org.PickMePetStore.persistence.model.UserModel;



public interface UserService {

	public void createUser(UserModel user);

	public boolean verify(String userToken);

	public int getUserId();

	public UserModel findById(int id);

	public String getUsername();

	public Set<PetModel> getOwnedCourses();

}
