package cm.gasmyr.mougang.it.sgs.impl.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.Option;
@Service
public interface OptionService {

	public void add(Option option);

	public void delete(Option option);

	public void delete(Long id);

	public void update(Option option);

	public Option getById(Long id);

	List<Option> getAll();

	public Page<Option> findAll(Pageable pageable);

	public void update(Long b);

	List<Option> searchByTest(String text);
}
