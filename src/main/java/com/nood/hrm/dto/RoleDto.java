package com.nood.hrm.dto;

import com.nood.hrm.model.Role;
import lombok.Data;

import java.util.List;

@Data
public class RoleDto extends Role {

    private List<Long> permissionIds;

    private List<Integer> departmentIds;
}
