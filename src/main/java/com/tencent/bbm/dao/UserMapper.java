package com.tencent.bbm.dao;

import com.tencent.bbm.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author bbm
 * 用户mapper
 */
@Mapper
@Component
public interface UserMapper extends BaseDao<User> {
}
