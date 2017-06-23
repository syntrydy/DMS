package cm.gasmyr.mougang.it.sgs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cm.gasmyr.mougang.it.sgs.core.University;

@Repository
public interface UniversityRepo extends JpaRepository<University, Long> {

	@Query("Select t from University t where t.name like %:text%")
	List<University> findUniversity(@Param("text") String text);

}
