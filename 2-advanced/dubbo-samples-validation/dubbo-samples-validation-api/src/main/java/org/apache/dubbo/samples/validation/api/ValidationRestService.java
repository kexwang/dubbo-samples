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

package org.apache.dubbo.samples.validation.api;

import org.apache.dubbo.samples.validation.api.model.DeleteParameter;
import org.apache.dubbo.samples.validation.api.model.QueryParameter;
import org.apache.dubbo.samples.validation.api.model.SaveOrUpdateParameter;

import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ValidationRestService {

    @GetMapping("/query1")
    void query1(@RequestParam("id") @Min(1) Integer id);

    @GetMapping("/query2")
    void query2(@RequestParam QueryParameter parameter);

    @PostMapping("/query3")
    void query3(@RequestBody QueryParameter parameter);

    @PostMapping("/save")
    void save(@RequestBody SaveOrUpdateParameter parameter);

    @PostMapping("/update")
    void update(@RequestBody SaveOrUpdateParameter parameter);

    @PostMapping("/delete")
    void delete(@RequestBody DeleteParameter parameter);

}
