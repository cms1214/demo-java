package org.novel.service;

import org.novel.model.dto.UserDTO;
import org.novel.model.dto.UserLoginDTO;
import org.novel.model.dto.UserRegisterDTO;
import org.novel.model.po.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.novel.model.vo.ResponseVO;
import org.novel.query.UserPageQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author novel
 * @since 2024-12-04
 */
public interface IUserService extends IService<User> {
    /**
     * 注册信息
     * @param user 用户信息
     * @return 视图层对象
     */
    ResponseVO register(UserRegisterDTO user);

    /**
     * 登录方法
     * @param userLoginDTO 登录信息
     * @return json视图对象
     */
    ResponseVO login(UserLoginDTO userLoginDTO);

    /**
     * 分页查询方法
     * @param pageQuery 分页查询参数
     * @return json
     */
    ResponseVO queryUserPage(UserPageQuery pageQuery);
}
