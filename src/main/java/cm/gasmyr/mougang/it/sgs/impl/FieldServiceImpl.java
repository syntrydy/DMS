package cm.gasmyr.mougang.it.sgs.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.Field;
import cm.gasmyr.mougang.it.sgs.impl.service.FieldService;
import cm.gasmyr.mougang.it.sgs.repository.FieldRepo;

@Service
public class FieldServiceImpl implements FieldService {

	FieldRepo fieldRepo;

	@Autowired
	public FieldServiceImpl(FieldRepo fieldRepo) {
		this.fieldRepo = fieldRepo;
	}

	@Override
	public void add(Field field) {
		if (field.getDepartment() != null && field.getName() != null) {
			fieldRepo.save(field);
		}

	}

	@Override
	public void delete(Field field) {
		if (field.getDepartment() != null && field.getName() != null) {
			fieldRepo.delete(field);
		}

	}

	@Override
	public void delete(Long id) {
		fieldRepo.delete(id);
	}

	@Override
	public void update(Field field) {
		if (field.getDepartment() != null && field.getName() != null) {
			Field fieldToUpdate = fieldRepo.getOne(field.getId());
			fieldToUpdate.updateInternal(field);
			fieldRepo.save(fieldToUpdate);
		}

	}

	@Override
	public Field getById(Long id) {
		return fieldRepo.getOne(id);
	}

	@Override
	public List<Field> getAll() {
		return fieldRepo.findAll();
	}

	@Override
	public Page<Field> findAll(Pageable pageable) {
		return fieldRepo.findAll(pageable);
	}

	@Override
	public void update(Long b) {

	}

	@Override
	public List<Field> searchByTest(String text) {
		return fieldRepo.findField(text);
	}

}
