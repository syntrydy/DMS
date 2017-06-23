package cm.gasmyr.mougang.it.sgs.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.Student;
import cm.gasmyr.mougang.it.sgs.impl.service.StudentService;
import cm.gasmyr.mougang.it.sgs.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	StudentRepo studentRepo;

	@Autowired
	public StudentServiceImpl(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Override
	public void add(Student student) {
		studentRepo.save(student);
	}

	@Override
	public void delete(Student student) {
		studentRepo.delete(student);
	}

	@Override
	public void delete(Long id) {
		studentRepo.delete(id);
	}

	@Override
	public void update(Student student) {
		Student optionToUpdate = studentRepo.getOne(student.getId());
		optionToUpdate.updateInternal(student, student.getCni());
		studentRepo.save(optionToUpdate);
	}

	@Override
	public Student getById(Long id) {
		return studentRepo.getOne(id);
	}

	@Override
	public List<Student> getAll() {
		return studentRepo.findAll();
	}

	@Override
	public Page<Student> findAll(Pageable pageable) {
		return studentRepo.findAll(pageable);
	}

	@Override
	public void update(Long b) {
	}

	@Override
	public List<Student> searchByTest(String text) {
		return studentRepo.findStudent(text);
	}

}
