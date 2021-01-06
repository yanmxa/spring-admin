package com.nood.hrm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.nood.hrm.common.response.Response;
import com.nood.hrm.dto.DepartmentDto;
import com.nood.hrm.mapper.DeptInfoMapper;
import com.nood.hrm.mapper.RoleDepartmentMapper;
import com.nood.hrm.mapper.UserInfoMapper;
import com.nood.hrm.model.DeptInfo;
import com.nood.hrm.model.UserInfo;
import com.nood.hrm.service.DepartmentInfoService;
import com.nood.hrm.util.TreeUtil;
import com.nood.hrm.util.UserConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@DS("dept")
public class DepartmentInfoServiceImpl implements DepartmentInfoService {

    @Autowired
    private DeptInfoMapper deptInfoMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RoleDepartmentMapper roleDepartmentMapper;

    @Override
    public List<DeptInfo> getDeptAll() {
        return deptInfoMapper.getFuzzyDept(new DeptInfo());
    }

    @Override
//    @DataPermission(deptAlias = "d")
    public List<DepartmentDto> buildDeptAll() {
        return deptInfoMapper.buildAll();
    }

    @Override
//    @DataPermission(deptAlias = "d")
    public List<DepartmentDto> roleDeptTreeData(Integer roleId) {

        List<String> deptIds = getDeptIdsByRoleId(roleId);

        List<DepartmentDto> selectRoleDeptTree = deptIds.stream().map(id -> {
            DeptInfo dept = deptInfoMapper.getDeptById(id);
            if (dept != null) return getDto(dept);
            else return null;
        }).filter(e -> e != null).collect(Collectors.toList());

        List<DepartmentDto> buildAll = deptInfoMapper.getFuzzyDept(new DeptInfo()).stream()
                .map(e -> getDto(e))
                .collect(Collectors.toList());
//        List<Department> departmentByRoleId = roleDepartmentMapper.getDepartmentByRoleId(roleId);
//        List<DepartmentDto> selectRoleDeptTree = deptInfoMapper.selectRoleDeptTree(roleId);
//        List<DepartmentDto> buildAll = deptInfoMapper.buildAll(new DepartmentDto());
        List<DepartmentDto> tree = TreeUtil.deptTree(selectRoleDeptTree, buildAll);
//        System.out.println(tree);
        return tree;
    }

    @DS("master")
    private List<String> getDeptIdsByRoleId(Integer roleId) {
        List<String> deptIds = roleDepartmentMapper.getDeptIdsByRoleId(roleId);
        return deptIds;
    }

    private DepartmentDto getDto(DeptInfo deptInfo) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(deptInfo.getDeptId());
        departmentDto.setTitle(deptInfo.getDeptName());
        departmentDto.setParentId(deptInfo.getDeptParentId());
        return departmentDto;
    }

    @Override
    public Response insertDept(DeptInfo dept) {
        DeptInfo parentDept = deptInfoMapper.selectDeptByNo(dept.getDeptParentId());
        if (parentDept == null) {
//            dept.setAncestors("001");
            dept.setDeptParentId(DeptInfo.defaultParentId);
        } else {
            if (UserConstants.DEPT_DISABLE.equals(parentDept.getState())) {
//            throw new Exception("部门停用，不允许新增");
                return Response.failure("上级部门停用，不允许新增!");
            }
//            dept.setAncestors(parentDept.getAncestors() + "," + dept.getParentId());
        }

        int i = deptInfoMapper.insertDept(dept);
        return Response.judge(i);
    }

    @Override
    public String checkDeptNameUnique(DeptInfo dept) {
        DeptInfo info = deptInfoMapper.checkDeptNameUnique(dept.getDeptName(), dept.getDeptParentId());
        if (info != null && !info.getDeptId().equals(dept.getDeptId())){
            return UserConstants.DEPT_NAME_NOT_UNIQUE;
        }
        return UserConstants.DEPT_NAME_UNIQUE;

    }

    public DeptInfo selectDeptByNo(String deptId) {
        return deptInfoMapper.selectDeptByNo(deptId);
    }

    @Override
    public DeptInfo getDeptById(String id) {
        return deptInfoMapper.getDeptById(id);
    }

    @Override
    public int updateDept(DeptInfo dept) {
        DeptInfo parentInfo = deptInfoMapper.selectDeptByNo(dept.getDeptParentId());
//        Department parentInfo = departmentMapper.selectDeptById(dept.getParentId());
//        Department oldInfo = selectDeptById(dept.getId());
        DeptInfo oldInfo = selectDeptByNo(dept.getDeptId());
//        if(parentInfo != null && oldInfo != null){
//            String newAncestors = parentInfo.getAncestors() + "," + parentInfo.getId();
//            String oldAncestors = oldInfo.getAncestors();
//            dept.setAncestors(newAncestors);
//            updateDeptChildren(dept.getId(), newAncestors, oldAncestors);
//        }
//        System.out.println(dept);
        int result = deptInfoMapper.updateDept(dept);

        if (UserConstants.DEPT_NORMAL.equals(dept.getState())) {
            // 如果该部门是启用状态，则启用该部门的所有上级部门
            updateParentDeptStatus(dept);
        }
        return result;
    }

    @Override
    public int selectNormalChildrenDeptById(String deptId) {
        return deptInfoMapper.selectNormalChildrenDeptById(deptId);
    }

    @Override
    public int selectDeptCount(String parentId) {
        DeptInfo dept =new DeptInfo();
        dept.setDeptParentId(parentId);
        dept.setDeptId(parentId);
        return deptInfoMapper.selectDeptCount(dept);
    }

    @Override
    @DS("user")
    public boolean checkDeptExistUser(String no) {
        List<UserInfo> userInfos = userInfoMapper.getUserByDeptId(no);
        int count = 0;
        if (userInfos != null && userInfos.size() > 0) count = userInfos.size();
        return count > 0 ? true : false;
    }

    @Override
    public int deleteDeptById(String deptId) {
        return deptInfoMapper.deleteDeptById(deptId);
    }

    @Override
    public int changeStatus(DeptInfo department) {
        return deptInfoMapper.updateDept(department);
    }

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

    /**
     * 修改该部门的父级部门状态
     *
     * @param dept 当前部门
     */
    private void updateParentDeptStatus(DeptInfo dept) {
        DeptInfo parentDept = deptInfoMapper.getDeptByNo(dept.getDeptParentId());
        parentDept.setState(UserConstants.DEPT_NORMAL);
        deptInfoMapper.updateDeptStatus(parentDept);
    }
}
