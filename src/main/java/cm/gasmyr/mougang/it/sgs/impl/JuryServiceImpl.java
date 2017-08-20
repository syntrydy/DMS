package cm.gasmyr.mougang.it.sgs.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.Jury;
import cm.gasmyr.mougang.it.sgs.impl.service.JuryService;
import cm.gasmyr.mougang.it.sgs.repository.JuryRepo;

@Service
public class JuryServiceImpl implements JuryService {
	JuryRepo juryRepo;

	@Autowired
	public JuryServiceImpl(JuryRepo juryRepo) {
		this.juryRepo = juryRepo;
	}

	@Override
	public void add(Jury jury) {
		if (jury.getName() != null) {
			juryRepo.save(jury);
		}

	}

	@Override
	public void delete(Jury jury) {
		if (jury.getId() != null) {
			juryRepo.delete(jury);
		}

	}

	@Override
	public void delete(Long id) {
		juryRepo.delete(id);
	}

	@Override
	public void update(Jury jury) {
		if (jury.getId() != null) {
			Jury optionToUpdate = juryRepo.getOne(jury.getId());
			optionToUpdate.updateInternal(jury);
			juryRepo.save(optionToUpdate);
		}

	}

	@Override
	public Jury getById(Long id) {
		return juryRepo.findOne(id);
	}

	@Override
	public List<Jury> getAll() {
		return juryRepo.findAll();
	}

	@Override
	public Page<Jury> findAll(Pageable pageable) {
		return juryRepo.findAll(pageable);
	}

	@Override
	public void update(Long b) {

	}

	@Override
	public List<Jury> searchByTest(String text) {
		return juryRepo.findJury(text);
	}

}
