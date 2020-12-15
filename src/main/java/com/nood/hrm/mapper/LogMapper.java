package com.nood.hrm.mapper;

import com.nood.hrm.dto.dto4log.ErrorLogDto;
import com.nood.hrm.dto.dto4log.LogDto;
import com.nood.hrm.dto.dto4log.LogQuery;
import com.nood.hrm.common.logger.entity.Log;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogMapper {

    /**
     * 保存日志
     * @param log
     */
    @Insert("insert into sys_log(username,ip,description,params,type,exceptionDetail,browser,method,time, createTime)values(#{userName},#{ip},#{description},#{params},#{type},#{exceptionDetail},#{browser},#{method},#{time},now())")
    void save(Log log);

    /**
     * 分页返回所有用户日志
     * @param logQuery 查询条件
     * @return
     */
    List<LogDto> getFuzzyLogByPage(@Param("startPosition") Integer startPosition,
                                   @Param("limit") Integer limit,
                                   @Param("logQuery") LogQuery logQuery);


    /**
     * 分页返回所有错误日志
     * @param logQuery 查询条件
     * @return
     */
    List<ErrorLogDto> getFuzzyErrorLogByPage(@Param("startPosition") Integer startPosition,
                                             @Param("limit") Integer limit,
                                             @Param("logQuery") LogQuery logQuery);


    /**
     * 删除所有日志
     * @param type 日志类型
     */
    @Delete("delete from sys_log where type = #{type}")
    void delAllByInfo(String type);


    int getFuzzyLogCount(@Param("logQuery") LogQuery logQuery);
}
