package cm.gasmyr.mougang.it.sgs.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.Teacher;
import cm.gasmyr.mougang.it.sgs.impl.service.TeacherService;
import cm.gasmyr.mougang.it.sgs.repository.TeacherRepo;

@Service
public class TeacherServiceImpl implements TeacherService {

	TeacherRepo teacherRepo;

	@Autowired
	public TeacherServiceImpl(TeacherRepo teacherRepo) {
		this.teacherRepo = teacherRepo;
	}

	@Override
	public void add(Teacher teacher) {
		teacherRepo.save(teacher);
	}

	@Override
	public void delete(Teacher teacher) {
		teacherRepo.delete(teacher);
	}

	@Override
	public void delete(Long id) {
		teacherRepo.delete(id);
	}

	@Override
	public void update(Teacher teacher) {
		Teacher optionToUpdate = teacherRepo.getOne(teacher.getId());
		optionToUpdate.updateInternal(teacher,teacher.getAddress(),teacher.getTitle());
		teacherRepo.save(optionToUpdate);
	}

	@Override
	public Teacher getById(Long id) {
		return teacherRepo.getOne(id);
	}

	@Override
	public List<Teacher> getAll() {
		return teacherRepo.findAll();
	}

	@Override
	public Page<Teacher> findAll(Pageable pageable) {
		return teacherRepo.findAll(pageable);
	}

	@Override
	public void update(Long b) {
	}

	@Override
	public List<Teacher> searchByTest(String text) {
		return teacherRepo.findTeacher(text);
	}

}
