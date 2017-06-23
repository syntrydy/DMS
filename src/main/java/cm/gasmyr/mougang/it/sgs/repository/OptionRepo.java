package cm.gasmyr.mougang.it.sgs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cm.gasmyr.mougang.it.sgs.core.Option;


@Repository
public interface OptionRepo extends JpaRepository<Option, Long> {
	@Query("Select l from Option l where l.name like %:text%")
	List<Option> findOption(@Param("text") String text);
}
