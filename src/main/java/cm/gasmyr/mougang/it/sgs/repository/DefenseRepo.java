package cm.gasmyr.mougang.it.sgs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cm.gasmyr.mougang.it.sgs.core.Defense;


@Repository
public interface DefenseRepo extends JpaRepository<Defense, Long>{
	
	@Query("Select l from Defense l where l.date like %:text%")
	List<Defense> findDefense(@Param("text") String text);

}
