/**
 * Copyright 2016 CNKI Technology Co., Ltd. All rights reserved.
 * CNKI Technology Co., Ltd PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.suqc.dao;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface MyBatisDao {
}