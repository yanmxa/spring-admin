package com.nood.hrm.dto;

import com.nood.hrm.model.UserInfo;
import lombok.Data;

@Data
public class UserInfoDto extends UserInfo {
    private String userid;
}
