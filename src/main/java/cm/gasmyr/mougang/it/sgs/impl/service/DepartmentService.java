package cm.gasmyr.mougang.it.sgs.impl.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.Department;

@Service
public interface DepartmentService {

	public void add(Department department);

	public void delete(Department department);

	public void delete(Long id);

	public void update(Department department);

	public Department getById(Long id);

	List<Department> getAll();

	public Page<Department> findAll(Pageable pageable);

	public void update(Long b);

	List<Department> searchByTest(String text);

}
