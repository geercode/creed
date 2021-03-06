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

package com.geercode.creed.core.modular.event.ancester;

/**
 * <p>Description : 事件</p>
 * <p>Created on  : 2018-11-01 16:46</p>
 *
 * @author jerryniu
 * @since 1.0.0
 */
public interface Event {
    /**
     * <p>description : 信息载体</p>
     * <p>create   on : 2019-03-06 17:56:43</p>
     *
     * @author jerryniu
     * @return 信息载体
     * @since 1.0.0
     */
    <P> P getPayload();
}
