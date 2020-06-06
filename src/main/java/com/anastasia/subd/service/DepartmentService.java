package com.anastasia.subd.service;

import com.anastasia.subd.entity.Department;
import com.anastasia.subd.model.OffsetablePageRequest;
import com.anastasia.subd.model.PageableItems;
import com.anastasia.subd.repository.DepartmentRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements Crud<Department> {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void create(Department department) {
        this.departmentRepository.save(department);
    }

    @Override
    public List<Department> findAll() {
        return this.departmentRepository.findAll();
    }

    @Override
    public Department get(Integer id) {
        return departmentRepository.getOne(id);
    }

    @Override
    public Optional<Department> find(Integer id) {
        return departmentRepository.findById(id);
    }

    @Override
    public PageableItems<Department> findAll(int offset, int count) {
        Page<Department> page = departmentRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public void update(Department department) {
        if (department.getId() == null) {
            throw new RuntimeException("Department id is null");
        }
        departmentRepository.save(department);
    }

    @Override
    public void delete(Department department) {
        departmentRepository.delete(department);
    }

    public List<Department> getByFacultyId(Integer id) {
        return departmentRepository.getAllByFaculty_Id(id);
    }
}