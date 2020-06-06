package com.anastasia.subd.service;

import com.anastasia.subd.entity.Faculty;
import com.anastasia.subd.model.OffsetablePageRequest;
import com.anastasia.subd.model.PageableItems;
import com.anastasia.subd.repository.FacultyRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService implements Crud<Faculty> {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public void create(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    @Override
    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty get(Integer id) {
        return facultyRepository.getOne(id);
    }

    @Override
    public Optional<Faculty> find(Integer id) {
        return facultyRepository.findById(id);
    }

    @Override
    public PageableItems<Faculty> findAll(int offset, int count) {
        final Page<Faculty> page = facultyRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public void update(Faculty faculty) {
        if (faculty.getId() == null) {
            throw new RuntimeException("Faculty id is null");
        }
        facultyRepository.save(faculty);
    }

    @Override
    public void delete(Faculty faculty) {
        facultyRepository.delete(faculty);
    }
}