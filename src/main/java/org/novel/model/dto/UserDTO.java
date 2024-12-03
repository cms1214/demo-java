package org.novel.model.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String name;
    private Integer age;
    private String pwd;
    private String email;
    private Integer sex;
}
