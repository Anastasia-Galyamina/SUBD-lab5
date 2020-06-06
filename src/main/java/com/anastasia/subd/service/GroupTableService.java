package com.anastasia.subd.service;

import com.anastasia.subd.entity.GroupTable;
import com.anastasia.subd.model.OffsetablePageRequest;
import com.anastasia.subd.model.PageableItems;
import com.anastasia.subd.repository.GroupTableRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupTableService implements Crud<GroupTable> {

    private final GroupTableRepository groupTableRepository;

    public GroupTableService(GroupTableRepository groupTableRepository) {
        this.groupTableRepository = groupTableRepository;
    }

    @Override
    public void create(GroupTable groupTable) {
        groupTableRepository.save(groupTable);
    }

    @Override
    public List<GroupTable> findAll() {
        return groupTableRepository.findAll();
    }

    @Override
    public GroupTable get(Integer id) {
        return groupTableRepository.getOne(id);
    }

    @Override
    public Optional<GroupTable> find(Integer id) {
        return groupTableRepository.findById(id);
    }

    @Override
    public PageableItems<GroupTable> findAll(int offset, int count) {
        Page<GroupTable> page = groupTableRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public void update(GroupTable groupTable) {
        if (groupTable.getId() == null) {
            throw new RuntimeException("GroupTable id is null");
        }
        groupTableRepository.save(groupTable);
    }

    @Override
    public void delete(GroupTable groupTable) {
        groupTableRepository.delete(groupTable);
    }
}