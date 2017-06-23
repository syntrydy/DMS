package cm.gasmyr.mougang.it.sgs.impl.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.Jury;

@Service
public interface JuryService {
	
	public void add(Jury jury);

	public void delete(Jury field);

	public void delete(Long id);

	public void update(Jury field);

	public Jury getById(Long id);

	List<Jury> getAll();

	public Page<Jury> findAll(Pageable pageable);

	public void update(Long b);

	List<Jury> searchByTest(String text);

}
