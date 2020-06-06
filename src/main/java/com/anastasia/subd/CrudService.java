package com.anastasia.subd;

import com.anastasia.subd.entity.*;
import com.anastasia.subd.model.PageableItems;
import com.anastasia.subd.service.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class CrudService {

    private final DepartmentService departmentService;

    private final FacultyService facultyService;

    private final GroupTableService groupTableService;

    private final LecturerService lecturerService;

    private final RecordBookService recordBookService;

    private final SpecializationService specializationService;

    private final StudentService studentService;

    private final SubjectService subjectService;

    public CrudService(DepartmentService departmentService,
                       FacultyService facultyService,
                       GroupTableService groupTableService,
                       LecturerService lecturerService,
                       RecordBookService recordBookService,
                       SpecializationService specializationService,
                       StudentService studentService,
                       SubjectService subjectService) {
        this.departmentService = departmentService;
        this.facultyService = facultyService;
        this.groupTableService = groupTableService;
        this.lecturerService = lecturerService;
        this.recordBookService = recordBookService;
        this.specializationService = specializationService;
        this.studentService = studentService;
        this.subjectService = subjectService;
    }

    public void createFaculty(String name) {
        Faculty faculty = new Faculty();
        faculty.setName(name);
        facultyService.create(faculty);
    }

    public void deleteDepartment(Integer id) {
        Department department = new Department();
        department.setId(id);
        departmentService.delete(department);
    }

    public void updateFaculty(Integer id, String name) {
        Faculty faculty = new Faculty();
        faculty.setId(id);
        faculty.setName(name);
        facultyService.update(faculty);
    }

    public void getFaculties() {
        Timestamp start = new Timestamp(System.currentTimeMillis());
        System.out.println(facultyService.findAll());
        Timestamp end = new Timestamp(System.currentTimeMillis());
        System.out.println("Время выполнения запроса: " + (end.getTime() - start.getTime()) + " мс");
    }

    public void getDepartmentsByFacultyId(Integer id) {
        Timestamp start = new Timestamp(System.currentTimeMillis());
        System.out.println(departmentService.getByFacultyId(id));
        Timestamp end = new Timestamp(System.currentTimeMillis());
        System.out.println("Время выполнения запроса: " + (end.getTime() - start.getTime()) + " мс");
    }

    public void getStudentCountGroupedByGroup(Integer markMoreThan) {
        Timestamp start = new Timestamp(System.currentTimeMillis());
        System.out.println(studentService.getStudentCountGroupedByGroup(markMoreThan));
        Timestamp end = new Timestamp(System.currentTimeMillis());
        System.out.println("Время выполнения запроса: " + (end.getTime() - start.getTime()) + " мс");
    }

    public void departmentPagination() {
        PageableItems<Department> departments = departmentService.findAll(1, 2);
        departments.getItems().forEach(System.out::println);
    }

    public void facultyPagination() {
        PageableItems<Faculty> facultys = facultyService.findAll(0, 3);
        facultys.getItems().forEach(System.out::println);
    }

    public void groupTablePagination() {
        PageableItems<GroupTable> groupTables = groupTableService.findAll(2, 2);
        groupTables.getItems().forEach(System.out::println);
    }

    public void lecturerPagination() {
        PageableItems<Lecturer> lecturers = lecturerService.findAll(0, 4);
        lecturers.getItems().forEach(System.out::println);
    }

    public void recordBookPagination() {
        PageableItems<RecordBook> recordBooks = recordBookService.findAll(0, 3);
        recordBooks.getItems().forEach(System.out::println);
    }

    public void specializationPagination() {
        PageableItems<Specialization> specializations = specializationService.findAll(1, 4);
        specializations.getItems().forEach(System.out::println);
    }

    public void studentPagination() {
        PageableItems<Student> students = studentService.findAll(1, 4);
        students.getItems().forEach(System.out::println);
    }

    public void subjectPagination() {
        PageableItems<Subject> subjects = subjectService.findAll(0, 1);
        subjects.getItems().forEach(System.out::println);
    }
}