package com.infosource.domain.anno;

import java.lang.annotation.*;

/**
 * Created by wangrongtao on 16/3/16.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FormGlobalSetting {
    String tableCaption();
    String baseurl();
}
