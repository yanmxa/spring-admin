package com.nood.hrm.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.nood.hrm.model.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDepartmentMapper {

    @Delete("delete from sys_role_department where roleId = #{id}")
    int deleteRoleDeptByRoleId(Integer id);

    int save(@Param("roleId") Integer roleId, @Param("departmentIds") List<Integer> departmentIds);

//    @Select("select d.* from sys_department d join sys_role_department rd on d.id = rd.departmentId where rd.roleId = #{id} order by d.parentId")
//    List<Department> getDepartmentByRoleId(Integer id);

    @Select("select t.departmentId from sys_role_department t where t.roleId = #{roleId}")
    @DS("master")
    List<String> getDeptIdsByRoleId(Integer roleId);

}
