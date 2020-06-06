package com.anastasia.subd.service;

import com.anastasia.subd.entity.Student;
import com.anastasia.subd.model.GroupStudentCountModel;
import com.anastasia.subd.model.OffsetablePageRequest;
import com.anastasia.subd.model.PageableItems;
import com.anastasia.subd.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements Crud<Student> {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void create(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student get(Integer id) {
        return studentRepository.getOne(id);
    }

    @Override
    public Optional<Student> find(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public PageableItems<Student> findAll(int offset, int count) {
        Page<Student> page = studentRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public void update(Student student) {
        if (student.getId() == null) {
            throw new RuntimeException("Student id is null");
        }
        studentRepository.save(student);
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }

    public List<GroupStudentCountModel> getStudentCountGroupedByGroup(Integer markMoreThan) {
        return studentRepository.getStudentCountGroupedByGroup(markMoreThan);
    }
}