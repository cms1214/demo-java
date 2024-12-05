package org.novel.controller;

import lombok.extern.slf4j.Slf4j;
import org.novel.handler.LoginInterceptor;
import org.novel.model.bo.LoginUserBO;
import org.novel.model.dto.UserDTO;
import org.novel.model.dto.UserLoginDTO;
import org.novel.model.dto.UserRegisterDTO;
import org.novel.model.po.User;
import org.novel.model.vo.ResponseVO;
import org.novel.model.vo.UserVO;
import org.novel.query.UserPageQuery;
import org.novel.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.soap.Addressing;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * xxx管理系统/用户模块
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 获取用户列表
     * @return 用户列表
     */
    @GetMapping("/getList")// 负责接受get请求
    public ResponseVO get() {
        ArrayList<UserVO> userList = new ArrayList<>();

        UserVO userVO = new UserVO();
        userVO.setName("张三");
        userVO.setAge(18);
        userVO.setEmail("zhangsan@163.com");

        log.info("info级别的日志");
        log.warn("warn级别的日志");
        log.error("error级别的日志");
        log.debug("debug级别的日志");

        // int i = 1/0;

        UserVO userVO1 = new UserVO();
        userVO1.setName("李四");
        userVO1.setAge(19);
        userVO1.setEmail("lisi@163.com");

        userList.add(userVO);
        userList.add(userVO1);

        return ResponseVO.ok().data("item", userList);
    }

    /**
     * 根据名字获取用户
     * @param name 名字
     * @return 用户信息
     */
    @GetMapping("/getUserByName")
    public ResponseVO getUserByName(@RequestParam String name) {
        /**
         * 用于解析URL查询参数，通过http://localhost:8080/api/user/getUserByName?name=John
         */
        UserVO userVO = new UserVO();
        userVO.setName(name);
        userVO.setAge(18);
        return ResponseVO.ok().data("item", userVO);
    }

    /**
     * 通过id获取用户
     * @param id 用户id
     * @return 用户信息
     */
    @GetMapping("/getUserById/{id}")
    public ResponseVO getUserById(@PathVariable String id) {
        // @PathVariable 用于接收解析路径参数，http://localhost:8080/api/user/getUserById/123
        UserVO userVO = new UserVO();
        userVO.setId(id);
        userVO.setName("111");
        userVO.setAge(18);
        HashMap<String, Object> map = new HashMap<>();
        map.put("查询出来的用户", userVO);
        LoginUserBO loginUserBO = LoginInterceptor.threadLocal.get();
        UserVO userVO1 = new UserVO();
        userVO1.setName(loginUserBO.getName());
        userVO1.setEmail(loginUserBO.getEmail());
        map.put("当前登录用户", userVO1);
        return ResponseVO.ok().data("item", map);
    }

    /**
     * 根据id和name获取用户
     * @param id 用户id
     * @param name 用户名
     * @return 用户信息
     */
    @GetMapping("/getUserByIdAndName/{id}")
    public ResponseVO getUserByIdAndName(@PathVariable String id, @RequestParam(required = false) String name) {
        UserVO userVO = new UserVO();
        userVO.setId(id);
        if (name != null) {
            userVO.setName(name);
        }else {
            userVO.setName("张三");
        }
        return ResponseVO.ok().data("item", userVO);
    }

    /**
     * 注册用户
     * @param user 用户信息
     */
    @PostMapping("/register")//用于接收保存数据请求
    public ResponseVO save(@RequestBody UserRegisterDTO user){
        // alt + enter 快速生成方法
        return userService.register(user);
    }

    /**
     * 用户登录
     * @return
     */
    @PostMapping("/login")
    public ResponseVO login(@RequestBody UserLoginDTO userLoginDTO) {
        // ctrl+alt+鼠标左键 跳转到方法实现类
        ResponseVO responseVO = userService.login(userLoginDTO);
        return responseVO;
    }

    /**
     * 分页查询
     * @param pageQuery 分页查询对象
     */
    @GetMapping("/page")
    public ResponseVO queryUserPage( UserPageQuery pageQuery){
        return userService.queryUserPage(pageQuery);
    }


    /**
     * 普通保存用户
     * @param user 用户信息
     * @return 响应
     */
    @PostMapping("/save")
    public ResponseVO save1(@RequestBody UserDTO user) {
        User user1 = new User();
        BeanUtils.copyProperties(user, user1);
        boolean save = userService.save(user1);
        return save ? ResponseVO.ok() : ResponseVO.error();
    }

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return 被更新的用户信息
     */
    @PutMapping("/updateById")//用于接收更新请求
    public ResponseVO updateById(@RequestBody UserDTO user) {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        //userService.updateById(user)
        return ResponseVO.ok().data("item", userVO);
    }

    /**
     * 根据id删除用户信息
     * @param id 用户id
     * @return 被删除的用户信息
     */
    @DeleteMapping("/remove/{id}")
    public ResponseVO removeById(@PathVariable String id) {
        UserVO userVO = new UserVO();
        userVO.setId(id);
        //UserService.removeById(id)
        return ResponseVO.ok().data("item", userVO);
    }
}
