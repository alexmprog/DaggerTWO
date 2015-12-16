package com.renovavision.daggertwo.di.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by alexmprog on 16.12.2015.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface UserScope {
}
