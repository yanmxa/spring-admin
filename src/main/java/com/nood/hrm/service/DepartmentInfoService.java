package com.nood.hrm.service;



import com.nood.hrm.common.response.Response;
import com.nood.hrm.dto.DepartmentDto;
import com.nood.hrm.model.Department;
import com.nood.hrm.model.DeptInfo;

import java.util.List;

public interface DepartmentInfoService {

    List<DeptInfo> getDeptAll();

    List<DepartmentDto> buildDeptAll();

    List<DepartmentDto> roleDeptTreeData(Integer roleId);

    Response insertDept(DeptInfo myDept);

    String checkDeptNameUnique(DeptInfo dept);

    DeptInfo getDeptById(String id);

    int updateDept(DeptInfo dept);

    int selectNormalChildrenDeptById(String deptId);

    int selectDeptCount(String deptId);;

    boolean checkDeptExistUser(String deptId);

    int deleteDeptById(String deptId);

    int changeStatus(DeptInfo department);
}
