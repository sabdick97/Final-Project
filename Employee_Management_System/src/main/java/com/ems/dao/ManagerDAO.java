package com.ems.dao;

import com.ems.entity.Manager;

public interface ManagerDAO {
void saveManager(Manager manager);
Manager getManagerUsingId(int id);
Manager updateManager(int id, Manager manager);
void deleteManagerUsingId(int id);
boolean login(String userName, String password);
 void assignManagerToEmployee(int employeeId, int managerId);

}
