package com.nood.hrm.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.nood.hrm.dto.DepartmentDto;
import com.nood.hrm.model.Department;
import com.nood.hrm.model.DeptInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@DS("dept")
public interface DeptInfoMapper {
    /**
     * 模糊查询部门
     * @return
     */
    List<DeptInfo> getFuzzyDept(@Param("deptInfo") DeptInfo deptInfo);


    /**
     * 部门树
     * @return
     */
    List<DepartmentDto> buildAll();

    /**
     * 校验部门名称
     * @param deptName 岗位名称
     * @param parentId
     * @return
     */
    DeptInfo checkDeptNameUnique(@Param("deptName") String deptName, @Param("parentId") String parentId);


    /**
     * 新增部门信息
     * @param dept 岗位信息
     * @return 结果
     */
    @Insert("INSERT INTO DeptInfo(deptId, deptName, deptShortName, deptParentId, state, sequence) " +
            "values(#{deptId}, #{deptName}, #{deptShortName}, #{deptParentId}, #{state}, #{sequence})")
    int insertDept(DeptInfo dept);
    /**
     * 根据部门ID查询信息
     * @return 部门信息
     */
    DeptInfo selectDeptByNo(String deptId);

    /**
     * 通过id查询部门信息
     * @return
     */
    @Select("select * from master.DeptInfo d where d.deptId = #{deptId}")
    DeptInfo getDeptById(String deptId);


    /**
     * 根据ID查询所有子部门
     *
     * @param id 父亲部门ID
     * @return 部门列表
     */
     List<Department> selectChildrenDeptById(Integer id);


    /**
     * 根据角色ID查询部门
     *
     * @param id 角色ID
     * @return 部门列表
     */
     List<DepartmentDto> selectRoleDeptTree(Integer id);
    /**
     * 修改子元素关系
     *
     * @param depts 子元素
     * @return 结果
     */
    int updateDeptChildren(@Param("depts") List<Department> depts);

    /**
     * 修改部门信息
     *
     * @param dept 部门信息
     * @return 结果
     */
    int updateDept(DeptInfo dept);

    /**
     * 修改所在部门的父级部门状态
     *
     * @param dept 部门
     */
     void updateDeptStatus(DeptInfo dept);

    /**
     * 根据ID查询所有子部门（正常状态）
     *
     * @param deptId 部门ID
     * @return 子部门数
     */
    int selectNormalChildrenDeptById(String deptId);
    /**
     * 查询部门数
     *
     * @param dept 部门信息
     * @return 结果
     */
    @Select("select count(1) from DeptInfo where deptId = #{deptId} or deptParentId = #{deptParentId}")
    int selectDeptCount(DeptInfo dept);

    /**
     * 查询部门是否存在用户
     *
     * @param deptId 部门ID
     * @return 结果
     */
    int checkDeptExistUser(Integer deptId);

    /**
     * 删除部门管理信息
     *
     * @param deptId 部门ID
     * @return 结果
     */
    int deleteDeptById(String deptId);

    @Select("select * from DeptInfo where deptId = #{no}")
    DeptInfo getDeptByNo(String no);
}
