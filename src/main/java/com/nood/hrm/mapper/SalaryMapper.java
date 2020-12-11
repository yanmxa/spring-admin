package com.nood.hrm.mapper;

import com.nood.hrm.dto.SalaryConditionDto;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import sun.jvm.hotspot.runtime.PerfDataEntry;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface SalaryMapper {

    @Select("select column_comment from INFORMATION_SCHEMA.Columns where table_name='salary' and  table_schema='hrm")
    Set<String> getColumnCommits();

    @Insert("alter table salary add column ${name} decimal(18,2) not null default '0' comment #{commit}")
    void addDecimalColumn(@Param("name") String name, @Param("commit") String commit);

    @Insert("alter table salary add column ${name} varchar(255) not null comment #{commit}")
    void addVarcharColumn(@Param("name") String name, @Param("commit") String commit);

    @Delete("alter table salary drop column ${salaryColumn}")
    void deleteColumn(String salaryColumn);

    // alter table <表名> change <字段名> <字段新名称> <字段的类型>
    @Update("alter table salary change ${oldName} ${newName} decimal(18,2) comment #{commit}")
    void update2DecimalColumn(@Param("oldName") String oldName, @Param("newName") String newName, @Param("commit") String commit);

    @Update("alter table salary change ${oldName} ${newName} varchar(255) comment #{commit}")
    void update2VarcharColumn(@Param("oldName") String oldName, @Param("newName") String newName, @Param("commit") String commit);

    void insertWithMap(@Param("column2record") Map<String,Object> column2record);

    @Select("select count(*) from salary")
    Long countAll();


//    List<Map<String, Object>> getAllSalaryByPage(Integer offset, Integer limit);

    List<Map<String,Object>> getAllSalaryByPage(@Param("startPosition") Integer offset,
                                                @Param("limit") Integer limit,
                                                @Param("columns") List<String> columns);

    @Delete("delete from salary where id = #{id}")
    int deleteById(long id);

    List<Map<String,Object>> getSalaryByFuzzyName(@Param("columns") List<String> columns,
                                                  @Param("salaryConditionDto") SalaryConditionDto salaryConditionDto);
}
