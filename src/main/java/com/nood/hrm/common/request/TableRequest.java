package com.nood.hrm.common.request;

import lombok.Data;

import java.io.Serializable;


@Data
public class TableRequest implements Serializable {

    private Integer page;
    private Integer limit;
    private Integer offset;

    public void countOffset() {
        if (page == null || limit == null) {
            offset = 0;
            return;
        }
        offset = (page - 1) * limit;
    }


}
