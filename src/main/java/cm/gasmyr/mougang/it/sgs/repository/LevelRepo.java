package cm.gasmyr.mougang.it.sgs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cm.gasmyr.mougang.it.sgs.core.Level;
@Repository
public interface LevelRepo extends JpaRepository<Level, Long> {
	@Query("Select l from Level l where l.name like %:text%")
	List<Level> findLevel(@Param("text") String text);

}
