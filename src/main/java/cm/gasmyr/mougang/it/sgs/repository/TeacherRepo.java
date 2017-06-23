package cm.gasmyr.mougang.it.sgs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.Teacher;

@Service
public interface TeacherRepo extends JpaRepository<Teacher, Long> {
	@Query("Select l from Teacher l where l.fname like %:text%")
	List<Teacher> findTeacher(@Param("text") String text);
}