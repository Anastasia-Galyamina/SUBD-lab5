package com.anastasia.subd.service;

import com.anastasia.subd.entity.Lecturer;
import com.anastasia.subd.model.OffsetablePageRequest;
import com.anastasia.subd.model.PageableItems;
import com.anastasia.subd.repository.LecturerRepositoty;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LecturerService implements Crud<Lecturer> {

    private final LecturerRepositoty lecturerRepositoty;

    public LecturerService(LecturerRepositoty lecturerRepositoty) {
        this.lecturerRepositoty = lecturerRepositoty;
    }

    @Override
    public void create(Lecturer lecturer) {
        lecturerRepositoty.save(lecturer);
    }

    @Override
    public List<Lecturer> findAll() {
        return lecturerRepositoty.findAll();
    }

    @Override
    public Lecturer get(Integer id) {
        return lecturerRepositoty.getOne(id);
    }

    @Override
    public Optional<Lecturer> find(Integer id) {
        return lecturerRepositoty.findById(id);
    }

    @Override
    public PageableItems<Lecturer> findAll(int offset, int count) {
        Page<Lecturer> page = lecturerRepositoty.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public void update(Lecturer lecturer) {
        if (lecturer.getId() == null) {
            throw new RuntimeException("Lecturer id is null");
        }
        lecturerRepositoty.save(lecturer);
    }

    @Override
    public void delete(Lecturer lecturer) {
        lecturerRepositoty.delete(lecturer);
    }
}