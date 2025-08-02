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

package org.apache.dubbo.samples.validation.api.model;

import org.apache.dubbo.samples.validation.api.group.Save;
import org.apache.dubbo.samples.validation.api.group.Update;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * ValidationParameter
 */
@Data
public class SaveOrUpdateParameter implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(groups = Update.class)
    @Min(1)
    private Integer id;

    @NotNull // disallow null
    @Size(min = 2, max = 20) // min and max
    private String name;

    @NotNull(groups = Save.class)// save时不能为空
    // disallow null when save, but allow null when update, that is: not update
    @Pattern(regexp = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")
    private String email;

    @Min(18) // min
    @Max(100) // max
    private Integer age;

    @Past // must be a past time
    private Date loginDate;

    @Future // must be a future time
    private Date expiryDate;

}
