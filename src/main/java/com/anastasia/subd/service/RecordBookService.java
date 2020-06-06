package com.anastasia.subd.service;

import com.anastasia.subd.entity.RecordBook;
import com.anastasia.subd.model.OffsetablePageRequest;
import com.anastasia.subd.model.PageableItems;
import com.anastasia.subd.repository.RecordBookRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordBookService implements Crud<RecordBook> {

    private final RecordBookRepository recordBookRepository;

    public RecordBookService(RecordBookRepository recordBookRepository) {
        this.recordBookRepository = recordBookRepository;
    }

    @Override
    public void create(RecordBook recordBook) {
        recordBookRepository.save(recordBook);
    }

    @Override
    public List<RecordBook> findAll() {
        return recordBookRepository.findAll();
    }

    @Override
    public RecordBook get(Integer id) {
        return recordBookRepository.getOne(id);
    }

    @Override
    public Optional<RecordBook> find(Integer id) {
        return recordBookRepository.findById(id);
    }

    @Override
    public PageableItems<RecordBook> findAll(int offset, int count) {
        Page<RecordBook> page = recordBookRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public void update(RecordBook recordBook) {
        if (recordBook.getId() == null) {
            throw new RuntimeException("RecordBook id is null");
        }
        recordBookRepository.save(recordBook);
    }

    @Override
    public void delete(RecordBook recordBook) {
        recordBookRepository.delete(recordBook);
    }
}