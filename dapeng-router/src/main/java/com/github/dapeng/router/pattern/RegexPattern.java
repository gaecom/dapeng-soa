/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.dapeng.router.pattern;

/**
 * 描述: 正则 条件表达式
 * etc:
 * <p>
 * method match r"setFoo.*"
 *
 * @author hz.lei
 * @date 2018年04月13日 下午9:40
 */
public class RegexPattern implements Pattern {

    public final java.util.regex.Pattern pattern;

    public RegexPattern(java.util.regex.Pattern pattern) {

        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "RegexPattern{" +
                "pattern=" + pattern +
                '}';
    }
}
