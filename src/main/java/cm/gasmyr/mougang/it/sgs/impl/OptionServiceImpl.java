package cm.gasmyr.mougang.it.sgs.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.Option;
import cm.gasmyr.mougang.it.sgs.impl.service.OptionService;
import cm.gasmyr.mougang.it.sgs.repository.OptionRepo;

@Service
public class OptionServiceImpl implements OptionService {

	OptionRepo optionRepo;

	@Autowired
	public OptionServiceImpl(OptionRepo optionRepo) {
		this.optionRepo = optionRepo;
	}

	@Override
	public void add(Option option) {
		if (option.getField() != null && option.getName() != null) {
			optionRepo.save(option);
		}

	}

	@Override
	public void delete(Option option) {
		if (option.getId() != null) {
			optionRepo.delete(option);
		}

	}

	@Override
	public void delete(Long id) {
		if (id != null) {
			optionRepo.delete(id);
		}
	}

	@Override
	public void update(Option option) {
		if (option.getId() != null) {
			Option optionToUpdate = optionRepo.getOne(option.getId());
			optionToUpdate.updateInternal(option);
			optionRepo.save(optionToUpdate);
		}

	}

	@Override
	public Option getById(Long id) {
		return optionRepo.getOne(id);
	}

	@Override
	public List<Option> getAll() {
		return optionRepo.findAll();
	}

	@Override
	public Page<Option> findAll(Pageable pageable) {
		return optionRepo.findAll(pageable);
	}

	@Override
	public void update(Long b) {
	}

	@Override
	public List<Option> searchByTest(String text) {
		return new ArrayList<>();
	}

}
