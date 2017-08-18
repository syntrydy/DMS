package cm.gasmyr.mougang.it.sgs.impl.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.User;

@Service
public interface UserService {

	public void add(User user);

	public void delete(User user);

	public void delete(Long id);

	public void update(User user);

	public User getById(Long id);

	List<User> getAll();

	public Page<User> findAll(Pageable pageable);

	public void update(Long b);

	List<User> searchByTest(String text);
	
	List<User> searchByUserName(String text);
}
