package cm.gasmyr.mougang.it.sgs.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cm.gasmyr.mougang.it.sgs.core.Department;
import cm.gasmyr.mougang.it.sgs.impl.service.DepartmentService;
import cm.gasmyr.mougang.it.sgs.repository.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	DepartmentRepo departmentRepo;

	@Autowired
	public DepartmentServiceImpl(DepartmentRepo departmentRepo) {
		this.departmentRepo = departmentRepo;
	}

	@Override
	public void add(Department department) {
		if(department.getName()!=null && department.getOwner()!=null){
			departmentRepo.save(department);
		}
	}

	@Override
	public void delete(Department department) {
		departmentRepo.delete(department);
	}

	@Override
	public void delete(Long id) {
		departmentRepo.delete(id);
	}

	@Override
	public void update(Department department) {
		if(department.getName()!=null && department.getOwner()!=null){
			Department departmentToUpdate = departmentRepo.getOne(department.getId());
			departmentToUpdate.updateInternal(department);
			departmentRepo.save(departmentToUpdate);
		}
	}

	@Override
	public Department getById(Long id) {
		return departmentRepo.getOne(id);
	}

	@Override
	public List<Department> getAll() {
		return departmentRepo.findAll();
	}

	@Override
	public Page<Department> findAll(Pageable pageable) {
		return departmentRepo.findAll(pageable);
	}

	@Override
	public void update(Long b) {

	}

	@Override
	public List<Department> searchByTest(String text) {
		return departmentRepo.findDepartement(text);
	}

}
