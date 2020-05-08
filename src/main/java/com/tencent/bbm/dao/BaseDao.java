package com.tencent.bbm.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author bbm
 * 公用
 * @param <T>
 */
public interface BaseDao<T>  extends Mapper<T>, MySqlMapper<T> {
}
