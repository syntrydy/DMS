package cm.gasmyr.mougang.it.sgs.impl.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.Field;

@Service
public interface FieldService {

	public void add(Field field);

	public void delete(Field field);

	public void delete(Long id);

	public void update(Field field);

	public Field getById(Long id);

	List<Field> getAll();

	public Page<Field> findAll(Pageable pageable);

	public void update(Long b);

	List<Field> searchByTest(String text);

}
