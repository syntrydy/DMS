package cm.gasmyr.mougang.it.sgs.impl.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.Teacher;

@Service
public interface TeacherService {

	public void add(Teacher teacher);

	public void delete(Teacher teacher);

	public void delete(Long id);

	public void update(Teacher teacher);

	public Teacher getById(Long id);

	List<Teacher> getAll();

	public Page<Teacher> findAll(Pageable pageable);

	public void update(Long b);

	List<Teacher> searchByTest(String text);

}
