//package com.nood.hrm.service.impl;
//
//import com.nood.hrm.common.response.Response;
//import com.nood.hrm.dto.DepartmentDto;
//import com.nood.hrm.mapper.DepartmentMapper;
//import com.nood.hrm.model.Department;
//import com.nood.hrm.service.DepartmentService;
//import com.nood.hrm.util.TreeUtil;
//import com.nood.hrm.util.UserConstants;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class DepartmentServiceImpl implements DepartmentService {
//
//    @Autowired
//    private DepartmentMapper departmentMapper;
//
//    @Override
////    @DataPermission(deptAlias = "d")
//    public List<Department> getDeptAll(Department department) {
//        return departmentMapper.getFuzzyDept(department);
//    }
//
//    @Override
////    @DataPermission(deptAlias = "d")
//    public List<DepartmentDto> buildDeptAll(DepartmentDto deptDto) {
//        return departmentMapper.buildAll(deptDto);
//    }
//
//    @Override
////    @DataPermission(deptAlias = "d")
//    public List<DepartmentDto> roleDeptTreeData(Integer roleId) {
//
//        List<DepartmentDto> selectRoleDeptTree = departmentMapper.selectRoleDeptTree(roleId);
//        List<DepartmentDto> buildAll = departmentMapper.buildAll(new DepartmentDto());
//
//        List<DepartmentDto> tree = TreeUtil.deptTree(selectRoleDeptTree, buildAll);
//        return tree;
//    }
//
//    @Override
//    public Response insertDept(Department dept) {
//        Department parentDept = departmentMapper.selectDeptById(dept.getParentId());
//        if (parentDept == null) {
//            dept.setAncestors(0 + "");
//            dept.setParentId(0);
//        } else {
//            if (UserConstants.DEPT_DISABLE.equals(parentDept.getStatus().toString())) {
////            throw new Exception("部门停用，不允许新增");
//                return Response.failure("上级部门停用，不允许新增!");
//            }
//            dept.setAncestors(parentDept.getAncestors() + "," + dept.getParentId());
//        }
//
//        int i = departmentMapper.insertDept(dept);
//        return Response.judge(i);
//    }
//
//    @Override
//    public String checkDeptNameUnique(Department dept) {
//        Department info = departmentMapper.checkDeptNameUnique(dept.getDeptName(),dept.getParentId());
//        if (info != null && !info.getId().equals(dept.getId())){
//            return UserConstants.DEPT_NAME_NOT_UNIQUE;
//        }
//        return UserConstants.DEPT_NAME_UNIQUE;
//
//    }
//
//    @Override
//    public Department selectDeptById(Integer deptId) {
//        return departmentMapper.selectDeptById(deptId);
//    }
//
//    @Override
//    public Department getDeptById(Integer deptId) {
//        return departmentMapper.getDeptById(deptId);
//    }
//
//    @Override
//    public int updateDept(Department dept) {
//        Department parentInfo = departmentMapper.selectDeptById(dept.getParentId());
//        Department oldInfo = selectDeptById(dept.getId());
//        if(parentInfo != null && oldInfo != null){
//            String newAncestors = parentInfo.getAncestors() + "," + parentInfo.getId();
//            String oldAncestors = oldInfo.getAncestors();
//            dept.setAncestors(newAncestors);
//            updateDeptChildren(dept.getId(), newAncestors, oldAncestors);
//        }
//        int result = departmentMapper.updateDept(dept);
//        if (UserConstants.DEPT_NORMAL.equals(dept.getStatus().toString())) {
//            // 如果该部门是启用状态，则启用该部门的所有上级部门
//            updateParentDeptStatus(dept);
//        }
//        return result;
//    }
//
//    @Override
//    public int selectNormalChildrenDeptById(Integer deptId) {
//        return departmentMapper.selectNormalChildrenDeptById(deptId);
//    }
//
//    @Override
//    public int selectDeptCount(Integer parentId) {
//        Department dept =new Department();
//        dept.setParentId(parentId);
//        return departmentMapper.selectDeptCount(dept);
//    }
//
//    @Override
//    public boolean checkDeptExistUser(Integer deptId) {
//        int result = departmentMapper.checkDeptExistUser(deptId);
//        return result > 0 ? true : false;
//    }
//
//    @Override
//    public int deleteDeptById(Integer deptId) {
//        return departmentMapper.deleteDeptById(deptId);
//    }
//
//    @Override
//    public int changeStatus(Department department) {
//        return departmentMapper.updateDept(department);
//    }
//
//    /**
//     * 修改子元素关系
//     *
//     * @param id 被修改的部门ID
//     * @param newAncestors 新的父ID集合
//     * @param oldAncestors 旧的父ID集合
//     */
//    public void updateDeptChildren(Integer id, String newAncestors, String oldAncestors)
//    {
//        List<Department> children = departmentMapper.selectChildrenDeptById(id);
//        for (Department child : children)
//        {
//            child.setAncestors(child.getAncestors().replace(oldAncestors, newAncestors));
//        }
//        if (children.size() > 0)
//        {
//            departmentMapper.updateDeptChildren(children);
//        }
//    }
//
//    /**
//     * 修改该部门的父级部门状态
//     *
//     * @param dept 当前部门
//     */
//    private void updateParentDeptStatus(Department dept)
//    {
//        dept = departmentMapper.selectDeptById(dept.getId());
//        departmentMapper.updateDeptStatus(dept);
//    }
//}
