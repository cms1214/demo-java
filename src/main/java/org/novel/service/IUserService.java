package org.novel.service;

import org.novel.model.dto.UserDTO;
import org.novel.model.dto.UserRegisterDTO;
import org.novel.model.po.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.novel.model.vo.ResponseVO;

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
}
