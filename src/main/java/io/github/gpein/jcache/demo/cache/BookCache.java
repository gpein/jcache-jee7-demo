/**
 * Copyright (C) 2015 Guillaume Pein <guillaume.pein@gmail.com>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.gpein.jcache.demo.cache;

import io.github.gpein.jcache.configuration.CacheConfiguration;

import javax.cache.CacheManager;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

import static javax.cache.expiry.AccessedExpiryPolicy.factoryOf;

public class BookCache {

    public static final String CACHE_NAME = "book.cache";

    @Inject
    private CacheManager cacheManager;

    void setUp(@Observes @Initialized(ApplicationScoped.class) Object event) {
        cacheManager.createCache(CACHE_NAME, new MutableConfiguration().setExpiryPolicyFactory(factoryOf(new Duration(TimeUnit.MINUTES, 1))).setStatisticsEnabled(true));
    }
}
