package com.nood.hrm.mapper;

import com.nood.hrm.model.SalaryMeta;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import sun.jvm.hotspot.runtime.PerfDataEntry;

import java.util.List;

@Repository
public interface SalaryMetaMapper {

    @Select("select count(*) from salary_meta")
    Long countAll();

    @Select("select * from salary_meta t order by t.id limit #{startPosition}, #{limit}")
    List<SalaryMeta> getAllMetaByPage(@Param("startPosition") Integer offset, @Param("limit") Integer limit);


    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into salary_meta(name, type, property, detail, history, isDecimal, status, createTime, updateTime) " +
            "values(#{name}, #{type}, #{property}, #{detail}, #{history}, #{isDecimal}, #{status}, now(), now())")
    int save(SalaryMeta salaryMeta);

    int updateSalaryMeta(SalaryMeta salaryMeta);

    @Select("select * from salary_meta where id=#{id}")
    SalaryMeta getById(Integer id);

    @Select("select * from salary_meta")
    List<SalaryMeta> getAllMeta();

    @Delete("delete from salary_meta where id = #{id}")
    int deleteMetaById(Integer id);

    @Select("select count(*) from salary_meta t where t.name like '%${name}%'")
    Long countMetaByFuzzyName(String name);

    @Select("select * from salary_meta t where t.name like '%${name}%' order by t.id limit #{startPosition}, #{limit}")
    List<SalaryMeta> getMetaByFuzzyNameWithPage(@Param("name") String name,
                                                @Param("startPosition") Integer offset,
                                                @Param("limit") Integer limit);
}
