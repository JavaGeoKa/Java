package telran.employees.service;

import java.util.List;

import telran.employees.dto.Programmer;

public interface IProgrammers {
	boolean addProgrammer(Programmer programmer);
	boolean removeProgrammer(int id);
	Programmer getProgrammerData(int id);
	boolean addNewTechnology(int id, String technology);
    boolean removeTechnology(int id,String technology);
    List<Programmer> getProgrammersWithTechnology(String technology);
    List<Programmer> getProgrammersWithSalary(int salaryFrom, int salaryTo);
    boolean updateSalary(int id, int salary);
	
}
