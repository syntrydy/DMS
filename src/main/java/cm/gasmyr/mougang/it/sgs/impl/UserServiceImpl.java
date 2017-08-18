package cm.gasmyr.mougang.it.sgs.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.User;
import cm.gasmyr.mougang.it.sgs.impl.service.UserService;
import cm.gasmyr.mougang.it.sgs.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	UserRepo userRepo;

	@Autowired
	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public void add(User user) {
		userRepo.save(user);
	}

	@Override
	public void delete(User user) {
		userRepo.delete(user);
	}

	@Override
	public void delete(Long id) {
		userRepo.delete(id);
	}

	@Override
	public void update(User user) {
		User userToUpdate = userRepo.getOne(user.getId());
		userToUpdate.updateInternal(user);
		userRepo.save(userToUpdate);
	}

	@Override
	public User getById(Long id) {
		return userRepo.getOne(id);
	}

	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return userRepo.findAll(pageable);
	}

	@Override
	public void update(Long b) {

	}

	@Override
	public List<User> searchByTest(String text) {
		return userRepo.findUser(text);
	}

	@Override
	public List<User> searchByUserName(String username) {
		return userRepo.findUserWith(username);
	}

}
