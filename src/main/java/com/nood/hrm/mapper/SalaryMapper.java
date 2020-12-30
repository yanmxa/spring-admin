package com.nood.hrm.mapper;

import com.nood.hrm.dto.SalaryCustomDto;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface SalaryMapper {

    @Select("select column_comment from INFORMATION_SCHEMA.Columns where table_name='salary' and  table_schema='hrm")
    Set<String> getColumnCommits();

    @Insert("alter table ${table} add column `${name}` decimal(18,2) not null default 0 comment #{commit}")
    void addDecimalColumn(@Param("name") String name, @Param("commit") String commit, @Param("table") String table);

    @Insert("alter table ${table} add column `${name}` varchar(255) not null comment #{commit}")
    void addVarcharColumn(@Param("name") String name, @Param("commit") String commit, @Param("table") String table);

    @Delete("alter table ${table} drop column ${salaryColumn}")
    void deleteColumn(@Param("salaryColumn") String salaryColumn, @Param("table") String table);

    // alter table <表名> change <字段名> <字段新名称> <字段的类型>
    @Update("alter table ${table} change ${oldName} ${newName} decimal(18,2) comment #{commit}")
    void update2DecimalColumn(@Param("oldName") String oldName, @Param("newName") String newName, @Param("commit") String commit, @Param("table") String table);

    @Update("alter table ${table} change ${oldName} ${newName} varchar(255) comment #{commit}")
    void update2VarcharColumn(@Param("oldName") String oldName, @Param("newName") String newName, @Param("commit") String commit, @Param("table") String table);

    void insertWithMap(@Param("column2record") Map<String,Object> column2record, @Param("table") String table);



//    List<Map<String,Object>> getAllSalaryByPage(@Param("startPosition") Integer offset,
//                                                @Param("limit") Integer limit,
//                                                @Param("columns") List<String> columns);

    @Delete("delete from ${table} where id = #{id}")
    int deleteById(@Param("id") long id, @Param("table") String table);

    List<Map<String,Object>> getSalaryByFuzzyNameAndYear(@Param("columns") List<String> columns,
                                                         @Param("salaryCustomDto") SalaryCustomDto salaryCustomDto,
                                                         @Param("table") String table);

    List<Map<String,Object>> getSalaryByFuzzyNameAndYearAndMonth(@Param("columns") List<String> columns,
                                                                 @Param("salaryCustomDto") SalaryCustomDto salaryCustomDto,
                                                                 @Param("table") String table);

    List<Map<String,Object>> getSalaryByNoAndYear(@Param("salaryCustomDto") SalaryCustomDto salaryCustomDto,
                                                  @Param("no") String no,
                                                  @Param("table") String table);

    List<Map<String,Object>> getSalaryByNoAndYearAndMonth(@Param("salaryCustomDto") SalaryCustomDto salaryCustomDto,
                                                          @Param("no") String no,
                                                          @Param("table") String table);


    void createSalaryTable(String tableName);

    @Delete("delete from ${table} where ${salaryCustomDto.dateAlias} = #{salaryCustomDto.date} " +
            "and ${salaryCustomDto.employeeNoAlias} = #{salaryCustomDto.no}")
    int deleteByNoAndDate(@Param("salaryCustomDto") SalaryCustomDto salaryCustomDto,
                           @Param("table") String table);
}
