package org.novel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.codec.digest.Md5Crypt;
import org.novel.model.dto.UserDTO;
import org.novel.model.dto.UserLoginDTO;
import org.novel.model.dto.UserRegisterDTO;
import org.novel.model.po.User;
import org.novel.mapper.UserMapper;
import org.novel.model.vo.ResponseVO;
import org.novel.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.novel.utils.BusinessException;
import org.novel.utils.JWTUtil;
import org.novel.utils.RandomUtils;
import org.novel.utils.ResponseEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author novel
 * @since 2024-12-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public ResponseVO register(UserRegisterDTO registerDTO) {
        if (registerDTO.getName() == null) {
            throw new BusinessException(ResponseEnum.REGISTER_FAIL);//抛出参数不能为空
        }

        User user = new User();//new用户一个对象
        BeanUtils.copyProperties(registerDTO, user);//拷贝值
        user.setSecret("$1$" + RandomUtils.getRandomString(6));//随机生成一个盐
        String pwd = Md5Crypt.md5Crypt(registerDTO.getPwd().getBytes(), user.getSecret());//密码+盐 加密处理
        user.setPwd(pwd);//设置密码

        //账号唯一性检查 123456@qq.com
        if (checkUnique(user.getEmail())) {
            userMapper.insert(user);//保存用户信息
            return ResponseVO.ok().message("注册成功");//返回成功
        } else {
            return ResponseVO.setResult(ResponseEnum.USER_REPEAT);//用户已经存在
        }
    }

    @Override
    public ResponseVO login(UserLoginDTO userLoginDTO) {
        List<User> userList = userMapper.selectList(new QueryWrapper<User>().eq("email", userLoginDTO.getEmail()));

        if (userList != null && userList.size() ==1) {
            User user = userList.get(0);//验证通过
            String crypt = Md5Crypt.md5Crypt(userLoginDTO.getPwd().getBytes(), user.getSecret());//对请求过来的密码进行加密
            if (crypt.equals(user.getPwd())) {
                String token = JWTUtil.geneJsonWebToken(user);//生成token
                return ResponseVO.ok().data("token",token);
            }else {
                return ResponseVO.setResult(ResponseEnum.USER_PWD_ERROR);//密码错误
            }
        }else {

            return ResponseVO.setResult(ResponseEnum.ACCOUNT_UNREGISTER);//未注册
        }
    }

    /**
     * 校验用户账号唯一
     *
     * @param email 邮箱
     * @return 返回false表示已经存在，true表示不存在
     */
    private boolean checkUnique(String email) {
        QueryWrapper queryWrapper = new QueryWrapper<User>().eq("email", email);//创建查询条件
        List<User> list = userMapper.selectList(queryWrapper); //查找数据库中是否有对应的账号
        return list.size() > 0 ? false : true;//大于零返回false否则返回true
    }
}
