package com.nood.hrm.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

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
}
