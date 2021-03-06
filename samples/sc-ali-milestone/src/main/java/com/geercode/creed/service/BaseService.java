/*
 * Copyright 2018-2050 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.geercode.creed.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import java.util.Map;

/**
 * <p>基础service接口</p>
 *
 * @author jerryniu
 * @since 2019-05-09
 */
public interface BaseService<T> extends IService<T> {
    /**
     * 根据自定义语句查询数据
     *
     * @param myBatisSqlId mapper.xml中sqlId
     * @param conditions 条件参数
     * @return java.lang.Object 数据实体
     */
    Object getObjectBySqlId(String myBatisSqlId, Object conditions);

    /**
     * 根据 sqlid 查询数据返回单个数据
     *
     * @param myBatisSqlId mapper.xml中sqlId
     * @param conditions 条件参数
     * @return java.util.List 数据实体列表
     */
    List getListBySqlId(String myBatisSqlId, Object conditions);

    /**
     * 根据自定义语句查询数据
     *
     * @param querySqlId 查询语句sqlId
     * @param countSqlId 查询总记录数语句sqlId
     * @param param 条件参数
     * @param pageSize 每页大小
     * @param currentPage 查询当前页
     * @return com.baomidou.mybatisplus.core.metadata.IPage 数据实体分页
     */
    IPage<Object> queryPageBySqlId(String querySqlId, String countSqlId, Map<String, Object> param, Long pageSize,
            Long currentPage);
}