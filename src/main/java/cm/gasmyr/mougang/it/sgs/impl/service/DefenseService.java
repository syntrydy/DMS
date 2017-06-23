package cm.gasmyr.mougang.it.sgs.impl.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.Defense;

@Service
public interface DefenseService {

	public void add(Defense defense);

	public void delete(Defense student);

	public void delete(Long id);

	public void update(Defense student);

	public Defense getById(Long id);

	List<Defense> getAll();

	public Page<Defense> findAll(Pageable pageable);

	public void update(Long b);

	List<Defense> searchByTest(String text);
}
