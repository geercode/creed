/*
 * Copyright 2018-2050 the original author or authors.
 * Powered by Yimei Corp.
 * All Rights Reserved.
 */

package com.geercode.creed.samples.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geercode.creed.samples.repo.dao.entity.TProxyEntity;
import com.geercode.creed.samples.service.TProxyService;
import com.geercode.creed.samples.web.common.BaseResp;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Description : 测试控制器</p>
 * <p>Created on  : 2018-09-10 18:56</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    private static final long TEST_ID = 11906L;
    ///跳过检测

    @Autowired
    private TProxyService tProxyService;

    /**
     * <p>description : testGen</p>
     * <p>create   on : 2018-09-14 16:19:02</p>
     *
     * @author jerryniu
     * @version 1.0.0
     */
    @RequestMapping("/gen")
    public String testGen() {
        TProxyEntity tProxyEntity = new TProxyEntity();
        tProxyEntity.setId(TEST_ID);
        List list = tProxyService.list(new QueryWrapper(tProxyEntity));
        log.debug(list.toString());
        List list1 = tProxyService.getListBySqlId("findCourseById", null);
        log.debug(list1.toString());
        TProxyEntity tProxyEntity1 = (TProxyEntity) tProxyService.getObjectBySqlId("findCourseById_By", null);
        log.debug(tProxyEntity1.toString());
        return "success";
    }

    /**
     * 获取数据列表
     *
     * @author jerryniu
     */
    @ApiOperation("查询分页")
    @GetMapping("/list")
    public BaseResp findListByPage(@RequestParam(name = "page", defaultValue = "1") int pageIndex,
            @RequestParam(name = "rows", defaultValue = "20") int step) {
        Page page = new Page(pageIndex, step);
        tProxyService.page(page, null);
        return BaseResp.success(page);
    }

    /**
     * 获取全部数据
     *
     * @author jerryniu
     */
    @ApiOperation("查询所有数据")
    @GetMapping("/all")
    public BaseResp findAll() {
        List<TProxyEntity> models = tProxyService.list(null);
        return BaseResp.success(models);
    }

    /**
     * 根据ID查找数据
     *
     * @author jerryniu
     */
    @ApiOperation("查询单条记录")
    @GetMapping("/find")
    public BaseResp find(Long id) {
        TProxyEntity entity = tProxyService.getById(id);
        if (entity == null) {
            return BaseResp.fail("尚未查询到此ID");
        }
        return BaseResp.success(entity);
    }

    /**
     * 添加数据
     *
     * @author jerryniu
     */
    @ApiOperation(value = "添加单条记录", notes = "id自增")
    @PostMapping(value = "/add")
    public BaseResp addItem(TProxyEntity entity) {
        boolean isOk = tProxyService.save(entity);
        if (isOk) {
            return BaseResp.success("数据添加成功");
        }
        return BaseResp.fail("数据添加失败");
    }

    /**
     * 更新数据
     *
     * @author jerryniu
     */
    @ApiOperation("更新单条记录")
    @PutMapping(value = "/update")
    public BaseResp updateItem(TProxyEntity entity) {
        boolean isOk = tProxyService.updateById(entity);
        if (isOk) {
            return BaseResp.success("数据更改成功");
        }
        return BaseResp.fail("数据更改失败");
    }

    /**
     * 删除数据
     *
     * @author jerryniu
     */
    @ApiOperation("删除记录")
    @DeleteMapping("/del")
    public BaseResp deleteItems(List<Long> ids) {
        boolean isOk = tProxyService.removeByIds(ids);
        if (isOk) {
            return BaseResp.success("数据删除成功");
        }
        return BaseResp.fail("数据删除失败");
    }
}