package com.nood.hrm.service;

import com.nood.hrm.common.response.Response;
import com.nood.hrm.dto.SalaryCustomDto;
import com.nood.hrm.dto.SalaryMetaDto;
import com.nood.hrm.model.SalaryMeta;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface SalaryService {
    Response<SalaryMeta> getAllMetaByPage(Integer offset, Integer limit);

    Response<SalaryMeta> saveMeta(SalaryMeta salaryMeta);

    SalaryMeta getById(Integer id);

    Response<SalaryMeta> updateMeta(SalaryMeta salaryMeta);

    void downLoadSalaryMeta(HttpServletResponse response);

    int deleteMetaBy(Integer id);

    Response<SalaryMeta> getMetaByFuzzyName(String name, Integer offset, Integer limit);

    Response updateSalary(MultipartFile file);

    List<SalaryMetaDto> getSalaryTableHead();

    Response getSalaryTable(Integer offset, Integer limit, SalaryCustomDto salaryCustomDto);

    int deleteSalaryById(long id);
}
