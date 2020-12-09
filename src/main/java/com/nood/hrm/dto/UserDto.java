package com.nood.hrm.dto;

import com.nood.hrm.model.User;
import lombok.Data;

@Data
public class UserDto extends User {

    private static final long serialVersionUID = -5784234789156935003L;

    private String departmentName;
    private String roleName;
}
