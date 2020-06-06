package com.anastasia.subd;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@AllArgsConstructor
@SpringBootApplication
public class SubdApplication {

	@Autowired
	private final CrudService crudService;

	public static void main(String[] args) {
		SpringApplication.run(SubdApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void onStart() {
		crudService.createFaculty("Машиностроительный");
		crudService.deleteDepartment(111);
		crudService.updateFaculty(3, "Лингвистика-углубленный");
		crudService.getFaculties();
		crudService.getDepartmentsByFacultyId(1);
		crudService.getStudentCountGroupedByGroup(3);
		crudService.departmentPagination();
		crudService.facultyPagination();
		crudService.groupTablePagination();
		crudService.lecturerPagination();
		crudService.recordBookPagination();
		crudService.specializationPagination();
		crudService.studentPagination();
		crudService.subjectPagination();
	}
}