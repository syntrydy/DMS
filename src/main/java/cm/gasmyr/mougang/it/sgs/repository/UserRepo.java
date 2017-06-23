package cm.gasmyr.mougang.it.sgs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cm.gasmyr.mougang.it.sgs.core.User;

public interface UserRepo extends JpaRepository<User, Long> {
	@Query("Select u from User u where u.lname like %:text%")
	List<User> findUser(@Param("text") String text);
}
