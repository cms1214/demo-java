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

    //测试删除用户
    @Test
    public void testDeleteUser() {
        userMapper.deleteById(2);
        System.out.println("删除成功");
    }

    //查询用户
    @Test
    public void testGetUser() {
        User user = userMapper.selectById(2);
        System.out.println(user);
    }
}