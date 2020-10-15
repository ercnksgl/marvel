package com.path.marvelmobile.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import javax.inject.Scope;

@Scope
@Retention(RUNTIME)
public @interface MScope {
}
