package com.anastasia.subd.service;

import com.anastasia.subd.entity.Subject;
import com.anastasia.subd.model.OffsetablePageRequest;
import com.anastasia.subd.model.PageableItems;
import com.anastasia.subd.repository.SubjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService implements Crud<Subject> {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void create(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject get(Integer id) {
        return subjectRepository.getOne(id);
    }

    @Override
    public Optional<Subject> find(Integer id) {
        return subjectRepository.findById(id);
    }

    @Override
    public PageableItems<Subject> findAll(int offset, int count) {
        Page<Subject> page = subjectRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public void update(Subject subject) {
        if (subject.getId() == null) {
            throw new RuntimeException("Subject id is null");
        }
        subjectRepository.save(subject);
    }

    @Override
    public void delete(Subject subject) {
        subjectRepository.delete(subject);
    }
}