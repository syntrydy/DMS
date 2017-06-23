package cm.gasmyr.mougang.it.sgs.impl.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.Level;

@Service
public interface LevelService {

	public void add(Level level);

	public void delete(Level field);

	public void delete(Long id);

	public void update(Level level);

	public Level getById(Long id);

	List<Level> getAll();

	public Page<Level> findAll(Pageable pageable);

	public void update(Long b);

	List<Level> searchByTest(String text);

}
