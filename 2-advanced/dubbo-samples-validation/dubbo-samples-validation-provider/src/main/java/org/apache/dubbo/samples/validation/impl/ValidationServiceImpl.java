/*
 *
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.apache.dubbo.samples.validation.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.samples.validation.api.model.QueryParameter;
import org.apache.dubbo.samples.validation.api.model.SaveOrUpdateParameter;
import org.apache.dubbo.samples.validation.api.model.DeleteParameter;
import org.apache.dubbo.samples.validation.api.ValidationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DubboService
public class ValidationServiceImpl implements ValidationService {

    @Override
    public void query(QueryParameter parameter) {
        LOGGER.info("==========[{}]==========", "ValidationService.query");
    }

    @Override
    public void save(SaveOrUpdateParameter parameter) {
        LOGGER.info("==========[{}]==========", "ValidationService.save");
    }

    @Override
    public void update(SaveOrUpdateParameter parameter) {
        LOGGER.info("==========[{}]==========", "ValidationService.update");
    }

    @Override
    public void delete(DeleteParameter parameter) {
        LOGGER.info("==========[{}]==========", "ValidationService.delete");
    }

}
