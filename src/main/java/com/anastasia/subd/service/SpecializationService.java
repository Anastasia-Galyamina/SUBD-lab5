package com.anastasia.subd.service;

import com.anastasia.subd.entity.Specialization;
import com.anastasia.subd.model.OffsetablePageRequest;
import com.anastasia.subd.model.PageableItems;
import com.anastasia.subd.repository.SpecializationRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecializationService implements Crud<Specialization> {

    private final SpecializationRepository specializationRepository;

    public SpecializationService(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    @Override
    public void create(Specialization specialization) {
        specializationRepository.save(specialization);
    }

    @Override
    public List<Specialization> findAll() {
        return specializationRepository.findAll();
    }

    @Override
    public Specialization get(Integer id) {
        return specializationRepository.getOne(id);
    }

    @Override
    public Optional<Specialization> find(Integer id) {
        return specializationRepository.findById(id);
    }

    @Override
    public PageableItems<Specialization> findAll(int offset, int count) {
        Page<Specialization> page = specializationRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public void update(Specialization specialization) {
        if (specialization.getId() == null) {
            throw new RuntimeException("Specialization id is null");
        }
        specializationRepository.save(specialization);
    }

    @Override
    public void delete(Specialization specialization) {
        specializationRepository.delete(specialization);
    }
}