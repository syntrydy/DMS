package cm.gasmyr.mougang.it.sgs.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.Defense;
import cm.gasmyr.mougang.it.sgs.impl.service.DefenseService;
import cm.gasmyr.mougang.it.sgs.repository.DefenseRepo;

@Service
public class DefenseServiceImpl implements DefenseService {

	DefenseRepo defenseRepo;

	@Autowired
	public DefenseServiceImpl(DefenseRepo defenseRepo) {
		this.defenseRepo = defenseRepo;
	}

	@Override
	public void add(Defense defense) {
		defenseRepo.save(defense);
	}

	@Override
	public void delete(Defense defense) {
		defenseRepo.delete(defense);
	}

	@Override
	public void delete(Long id) {
		defenseRepo.delete(id);
	}

	@Override
	public void update(Defense defense) {
		Defense defenseToUpdate = defenseRepo.getOne(defense.getId());
		defenseToUpdate.updateInternal(defense);
		defenseRepo.save(defenseToUpdate);
	}

	@Override
	public Defense getById(Long id) {
		return defenseRepo.getOne(id);
	}

	@Override
	public List<Defense> getAll() {
		return defenseRepo.findAll();
	}

	@Override
	public Page<Defense> findAll(Pageable pageable) {
		return defenseRepo.findAll(pageable);
	}

	@Override
	public void update(Long b) {
	}

	@Override
	public List<Defense> searchByTest(String text) {
		return defenseRepo.findDefense(text);
	}

}
