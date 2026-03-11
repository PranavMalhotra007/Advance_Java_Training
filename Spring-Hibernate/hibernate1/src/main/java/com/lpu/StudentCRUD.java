package com.lpu;

public interface StudentCRUD {
	void findById(int id);
	void updatePhone(int id, long phone);
	void updateName(int id, String Name);
	void deleteById(int id);
	void saveStudent(int id, String name, long phone);
	void ListOfAllStudents();
}
