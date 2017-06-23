package cm.gasmyr.mougang.it.sgs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cm.gasmyr.mougang.it.sgs.core.Jury;

@Repository
public interface JuryRepo extends JpaRepository<Jury, Long>{
	@Query("Select l from Jury l where l.name like %:text%")
	List<Jury> findJury(@Param("text") String text);
}