package cm.gasmyr.mougang.it.sgs.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.University;
import cm.gasmyr.mougang.it.sgs.impl.service.UniversityService;
import cm.gasmyr.mougang.it.sgs.repository.UniversityRepo;

@Service
public class UniversityServiceImpl implements UniversityService {

	UniversityRepo universityRepo;

	@Autowired
	public UniversityServiceImpl(UniversityRepo universityRepo) {
		this.universityRepo = universityRepo;
	}

	@Override
	public void add(University university) {
		if(university.getName()!=null){
			universityRepo.save(university);
		}
		
	}

	@Override
	public void delete(University university) {
		if(university.getId()!=null){
			universityRepo.delete(university);
		}
		
	}

	@Override
	public void delete(Long id) {
		if(id!=null){
			universityRepo.delete(id);
		}
		
	}

	@Override
	public void update(University university) {
		if(university.getId()!=null){
			University taskToUpdate = universityRepo.getOne(university.getId());
			taskToUpdate.updateInternal(university);
			universityRepo.save(taskToUpdate);
		}
		
	}

	@Override
	public University getById(Long id) {
		return universityRepo.getOne(id);
	}

	@Override
	public List<University> getAll() {
		return universityRepo.findAll();
	}

	@Override
	public Page<University> findAll(Pageable pageable) {
		return universityRepo.findAll(pageable);
	}

	@Override
	public void update(Long id) {

	}

	@Override
	public List<University> searchByTest(String text) {
		List<University> universities = new ArrayList<>();
		universities.addAll(universityRepo.findUniversity(text));
		return universities;
	}

}
