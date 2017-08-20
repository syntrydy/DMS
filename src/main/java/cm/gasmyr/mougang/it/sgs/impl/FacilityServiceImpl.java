package cm.gasmyr.mougang.it.sgs.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.Facility;
import cm.gasmyr.mougang.it.sgs.impl.service.FacilityService;
import cm.gasmyr.mougang.it.sgs.repository.FacilityRepo;

@Service
public class FacilityServiceImpl implements FacilityService {

	FacilityRepo facilityRepo;

	@Autowired
	public FacilityServiceImpl(FacilityRepo facilityRepo) {
		this.facilityRepo = facilityRepo;
	}

	@Override
	public void add(Facility facility) {
		if (facility.getName() != null) {
			facilityRepo.save(facility);
		}
	}

	@Override
	public void delete(Facility facility) {
		if (facility != null) {
			facilityRepo.delete(facility);
		}

	}

	@Override
	public void delete(Long id) {
		facilityRepo.delete(id);
	}

	@Override
	public void update(Facility facility) {
		if (facility.getName() != null) {
			Facility facilityToUpdate = facilityRepo.getOne(facility.getId());
			facilityToUpdate.updateInternal(facility);
			facilityRepo.save(facilityToUpdate);
		}

	}

	@Override
	public Facility getById(Long id) {
		return facilityRepo.getOne(id);
	}

	@Override
	public List<Facility> getAll() {
		return facilityRepo.findAll();
	}

	@Override
	public Page<Facility> findAll(Pageable pageable) {
		return facilityRepo.findAll(pageable);
	}

	@Override
	public void update(Long b) {
	}

	@Override
	public List<Facility> searchByTest(String text) {
		return facilityRepo.findFacility(text);
	}

}
