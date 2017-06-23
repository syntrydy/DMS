package cm.gasmyr.mougang.it.sgs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cm.gasmyr.mougang.it.sgs.core.Facility;

@Repository
public interface FacilityRepo extends JpaRepository<Facility, Long>{
	@Query("Select f from Facility f where f.name like %:text%")
	List<Facility> findFacility(@Param("text") String text);
}
