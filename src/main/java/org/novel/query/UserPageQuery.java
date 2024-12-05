package org.novel.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserPageQuery extends PageQuery{
    private Integer age;
    private String email;
    private String name;
}