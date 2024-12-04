package org.novel.model.dto;

import lombok.Data;

@Data
public class UserLoginDTO {
    /**
     * 邮箱
     */
    private String email;
   
    /**
     * 密码
     */
    private String pwd;
}