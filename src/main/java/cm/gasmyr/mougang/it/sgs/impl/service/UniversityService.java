package cm.gasmyr.mougang.it.sgs.impl.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.University;

@Service
public interface UniversityService {

	public void add(University university);

	public void delete(University university);

	public void delete(Long id);

	public void update(University university);

	public University getById(Long id);

	List<University> getAll();

	public Page<University> findAll(Pageable pageable);

	public void update(Long b);

	List<University> searchByTest(String text);

}
