package com.nood.hrm.service;



import com.nood.hrm.common.response.Response;
import com.nood.hrm.dto.DepartmentDto;
import com.nood.hrm.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getDeptAll(Department myDept);

    List<DepartmentDto> buildDeptAll(DepartmentDto deptDto);

    List<DepartmentDto> roleDeptTreeData(Integer roleId);

    Response insertDept(Department myDept);

    String checkDeptNameUnique(Department dept);

    public Department selectDeptById(Integer deptId);

    Department getDeptById(Integer deptId);

    int updateDept(Department dept);

    int selectNormalChildrenDeptById(Integer deptId);

    int selectDeptCount(Integer parentId);;

    boolean checkDeptExistUser(Integer deptId);

    int deleteDeptById(Integer deptId);

    int changeStatus(Department department);
}
