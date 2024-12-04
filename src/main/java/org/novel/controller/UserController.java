package org.novel.controller;

import lombok.extern.slf4j.Slf4j;
import org.novel.model.dto.UserDTO;
import org.novel.model.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * xxx管理系统/用户模块
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {
    /**
     * 获取用户列表
     * @return 用户列表
     */
    @GetMapping("/getList")// 负责接受get请求
    public List<UserVO> get() {
        ArrayList<UserVO> userList = new ArrayList<>();

        UserVO userVO = new UserVO();
        userVO.setName("张三");
        userVO.setAge(18);
        userVO.setEmail("zhangsan@163.com");

        log.info("info级别的日志");
        log.warn("warn级别的日志");
        log.error("error级别的日志");
        log.debug("debug级别的日志");

        UserVO userVO1 = new UserVO();
        userVO1.setName("李四");
        userVO1.setAge(19);
        userVO1.setEmail("lisi@163.com");

        userList.add(userVO);
        userList.add(userVO1);

        return userList;
    }

    /**
     * 根据名字获取用户
     * @param name 名字
     * @return 用户信息
     */
    @GetMapping("/getUserByName")
    public UserVO getUserByName(@RequestParam String name) {
        /**
         * 用于解析URL查询参数，通过http://localhost:8080/api/user/getUserByName?name=John
         */
        UserVO userVO = new UserVO();
        userVO.setName(name);
        userVO.setAge(18);
        return userVO;
    }

    /**
     * 通过id获取用户
     * @param id 用户id
     * @return 用户信息
     */
    @GetMapping("/getUserById/{id}")
    public UserVO getUserById(@PathVariable String id) {
        // @PathVariable 用于接收解析路径参数，http://localhost:8080/api/user/getUserById/123
        UserVO userVO = new UserVO();
        userVO.setId(id);
        userVO.setName("张三");
        userVO.setAge(18);
        return userVO;
    }

    /**
     * 根据id和name获取用户
     * @param id 用户id
     * @param name 用户名
     * @return 用户信息
     */
    @GetMapping("/getUserByIdAndName/{id}")
    public UserVO getUserByIdAndName(@PathVariable String id, @RequestParam(required = false) String name) {
        UserVO userVO = new UserVO();
        userVO.setId(id);
        if (name != null) {
            userVO.setName(name);
        }else {
            userVO.setName("张三");
        }
        return userVO;
    }

    /**
     * 注册用户
     * @param user 用户信息
     */
    @PostMapping("/register")//用于接收保存数据请求
    public UserVO save(@RequestBody UserDTO user){
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        //对数据进行保存
        return userVO;
    }

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return 被更新的用户信息
     */
    @PutMapping("/updateById")//用于接收更新请求
    public UserVO updateById(@RequestBody UserDTO user) {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        //userService.updateById(user)
        return userVO;
    }

    /**
     * 根据id删除用户信息
     * @param id 用户id
     * @return 被删除的用户信息
     */
    @DeleteMapping("/remove/{id}")
    public UserVO removeById(@PathVariable String id) {
        UserVO userVO = new UserVO();
        userVO.setId(id);
        //UserService.removeById(id)
        return userVO;
    }
}
