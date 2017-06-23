package cm.gasmyr.mougang.it.sgs.impl.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.Facility;

@Service
public interface FacilityService {
	public void add(Facility facility);

	public void delete(Facility facility);

	public void delete(Long id);

	public void update(Facility facility);

	public Facility getById(Long id);

	List<Facility> getAll();

	public Page<Facility> findAll(Pageable pageable);

	public void update(Long b);

	List<Facility> searchByTest(String text);
}
