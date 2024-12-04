package org.novel.mapper;

import org.junit.jupiter.api.Test;
import org.novel.model.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setName("张三");
        user.setAge(18);
        user.setEmail("zhangsan@qq.com");
        userMapper.insert(user);
        System.out.println("添加成功");
    }
}