package com.nood.hrm.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Permission extends BaseEntity<Integer> {

    private static final long serialVersionUID = -6525908145032868837L;
    private Integer parentId;
    private String name;
    private String css;
    private String href;
    private Integer type;
    private String permission;
    private Integer sort;

    private List<Permission> child;
}
