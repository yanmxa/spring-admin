package com.nood.hrm.mapper;

import com.nood.hrm.dto.DepartmentDto;
import com.nood.hrm.model.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {
    /**
     * 模糊查询部门
     * @param department 查询的名称
     * @return
     */
    List<Department> getFuzzyDept(@Param("department") Department department);


    /**
     * 部门树
     * @param deptDto
     * @return
     */
    List<DepartmentDto> buildAll(DepartmentDto deptDto);

    /**
     * 校验部门名称
     * @param deptName 岗位名称
     * @param parentId
     * @return
     */
    Department checkDeptNameUnique(@Param("deptName") String deptName, @Param("parentId") Integer parentId);


    /**
     * 新增部门信息
     * @param dept 岗位信息
     * @return 结果
     */
    @Insert("INSERT INTO sys_department(parentId, no, ancestors,deptName,sort,status, createTime, updateTime) " +
            "values(#{parentId}, #{no}, #{ancestors},#{deptName},#{sort},#{status}, now(), now())")
    int insertDept(Department dept);
    /**
     * 根据部门ID查询信息
     * @param id 部门ID
     * @return 部门信息
     */
    Department selectDeptById(Integer id);

    /**
     * 通过id查询部门信息
     * @param deptId
     * @return
     */
    @Select("select d.id, d.parentId, d.no, d.ancestors, d.deptName,d.sort,d.status,d.createTime,d.updateTime from sys_department d where d.id = #{deptId}")
    Department getDeptById(Integer deptId);


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
    int updateDept(Department dept);

    /**
     * 修改所在部门的父级部门状态
     *
     * @param dept 部门
     */
     void updateDeptStatus(Department dept);

    /**
     * 根据ID查询所有子部门（正常状态）
     *
     * @param deptId 部门ID
     * @return 子部门数
     */
    int selectNormalChildrenDeptById(Integer deptId);
    /**
     * 查询部门数
     *
     * @param dept 部门信息
     * @return 结果
     */
    int selectDeptCount(Department dept);

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
    int deleteDeptById(Integer deptId);
}
