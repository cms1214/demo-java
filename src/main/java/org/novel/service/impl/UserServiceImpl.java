package org.novel.service.impl;

import org.novel.model.po.User;
import org.novel.mapper.UserMapper;
import org.novel.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
