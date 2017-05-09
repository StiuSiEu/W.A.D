package org.PickMePetStore.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.PickMePetStore.persistence.model.PetModel;
import org.PickMePetStore.persistence.model.RoleModel;
import org.PickMePetStore.persistence.model.TransactionModel;
import org.PickMePetStore.persistence.model.UserModel;
import org.PickMePetStore.persistence.model.UserTokenModel;
import org.PickMePetStore.persistence.repository.RoleRepository;
import org.PickMePetStore.persistence.repository.UserRepository;
import org.PickMePetStore.persistence.repository.UserTokenRepository;
import org.PickMePetStore.service.helper.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository userRoleRepository;

	@Autowired
	private UserTokenRepository userTokenRepository;

	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private TokenGenerator userTokenGenerator;

	public void createUser(UserModel user) {
		String token = userTokenGenerator.generateToken();
		
		RoleModel role = userRoleRepository.findByRole("ROLE_USER");
		user.setRole(role);

		UserTokenModel userToken = new UserTokenModel();
		userToken.setToken(token);
		userToken.setDate(new Date());
		userTokenRepository.save(userToken);

		userToken = userTokenRepository.findByToken(token);
		user.setUserToken(userToken);
		userRepository.save(user);
	}

	public boolean verify(String userToken) {
		UserTokenModel token = userTokenRepository.findByToken(userToken);
		boolean hasExpired = false;
		Date currentDate = new Date();
		long timeElapsed = currentDate.getTime() - token.getDate().getTime();
		if (timeElapsed > 5) {
			hasExpired = true;
		}
		return hasExpired;
	}

	public int getUserId() {
		String username = getUsername();
		return userRepository.findByUsername(username).getId();
	}

	public UserModel findById(int id) {
		return userRepository.findOne(id);
	}

	public Set<PetModel> getOwnedCourses() {
		Set<PetModel> pets = new HashSet<PetModel>();
		List<TransactionModel> transactions = transactionService.getPurchesedTransactions();
		for (TransactionModel transaction : transactions) {
			addPets(pets, transaction);
		}
		return pets;
	}

	private void addPets(Set<PetModel> pets, TransactionModel transaction) {
		for (PetModel pet : transaction.getPets()) {
			pets.add(pet);
		}
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

}
