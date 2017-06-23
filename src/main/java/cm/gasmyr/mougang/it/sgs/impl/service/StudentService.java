package cm.gasmyr.mougang.it.sgs.impl.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.Student;

@Service
public interface StudentService {
	public void add(Student student);

	public void delete(Student student);

	public void delete(Long id);

	public void update(Student student);

	public Student getById(Long id);

	List<Student> getAll();

	public Page<Student> findAll(Pageable pageable);

	public void update(Long b);

	List<Student> searchByTest(String text);

}
