package cm.gasmyr.mougang.it.sgs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cm.gasmyr.mougang.it.sgs.core.Field;

@Repository
public interface FieldRepo extends JpaRepository<Field, Long>{

	@Query("Select f from Field f where f.name like %:text%")
	List<Field> findField(@Param("text") String text);
}

