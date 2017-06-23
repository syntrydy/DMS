package cm.gasmyr.mougang.it.sgs.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import cm.gasmyr.mougang.it.sgs.core.Level;
import cm.gasmyr.mougang.it.sgs.impl.service.LevelService;
import cm.gasmyr.mougang.it.sgs.repository.LevelRepo;

@Repository
public class LevelServiceImpl implements LevelService {

	LevelRepo levelRepo;

	@Autowired
	public LevelServiceImpl(LevelRepo levelRepo) {
		this.levelRepo = levelRepo;
	}

	@Override
	public void add(Level level) {
		levelRepo.save(level);
	}

	@Override
	public void delete(Level level) {
		levelRepo.delete(level);
	}

	@Override
	public void delete(Long id) {
		levelRepo.delete(id);
	}

	@Override
	public void update(Level level) {
		Level levelToUpdate = levelRepo.getOne(level.getId());
		levelToUpdate.updateInternal(level);
		levelRepo.save(levelToUpdate);
	}

	@Override
	public Level getById(Long id) {
		return levelRepo.getOne(id);
	}

	@Override
	public List<Level> getAll() {
		return levelRepo.findAll();
	}

	@Override
	public Page<Level> findAll(Pageable pageable) {
		return levelRepo.findAll(pageable);
	}

	@Override
	public void update(Long b) {

	}

	@Override
	public List<Level> searchByTest(String text) {
		return levelRepo.findLevel(text);
	}

}
