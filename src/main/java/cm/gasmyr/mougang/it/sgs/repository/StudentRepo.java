package cm.gasmyr.mougang.it.sgs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cm.gasmyr.mougang.it.sgs.core.Student;


@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{
	@Query("Select l from Student l where l.fname like %:text%")
	List<Student> findStudent(@Param("text") String text);

}
