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

package com.geercode.creed.runner;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * <p>Description : client测试</p>
 * <p>Created on  : 2018-10-18 17:12</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
@Component
@Slf4j
public class ClientRegisterCheck {

    @Autowired
    private EurekaClient discoveryClient;

    public String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("A-UAA", false);
        return instance.getHomePageUrl();
    }

    @PostConstruct
    public void init() {
        log.info(">>>>>>>>>>>>> TEST");
        log.info(serviceUrl());
    }
}
