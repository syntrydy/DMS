package cm.gasmyr.mougang.it.sgs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cm.gasmyr.mougang.it.sgs.core.Department;

@Repository
public interface DepartmentRepo
extends JpaRepository<Department, Long>{

	@Query("Select d from Department d where d.name like %:text%")
	List<Department> findDepartement(@Param("text") String text);
}
