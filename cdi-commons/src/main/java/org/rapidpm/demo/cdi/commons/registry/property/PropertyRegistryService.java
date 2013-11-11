/*
 * Copyright [2013] [www.rapidpm.org / Sven Ruppert (sven.ruppert@rapidpm.org)]
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.rapidpm.demo.cdi.commons.registry.property;

import javax.inject.Inject;

import org.rapidpm.demo.cdi.commons.logger.CDILogger;
import org.rapidpm.module.se.commons.logger.Logger;

import java.io.Serializable;

/**
 * User: Sven Ruppert
 * Date: 10.06.13
 * Time: 07:34
 * <p/>
 * The PropertyRegistryService will decide
 * what kind of registry-implementations will be used here.
 * <p/>
 * For example the file based implementations.
 */
public abstract class PropertyRegistryService implements Serializable {

    private @Inject @CDILogger Logger logger;

    public abstract String getRessourceForKey(String ressourceKey);

    private String mappClassRessourceKey(final Class clazz, final String relativeKey) {
        return clazz.getName() + "." + relativeKey;
    }

    public String getClassMappedRessource(final Class clazz, final String relativeKey) {
        final String mappedKey = mappClassRessourceKey(clazz, relativeKey);
        if (logger.isDebugEnabled()) {
            logger.debug("mappedKey - " + mappedKey);
        }
        return getRessourceForKey(mappedKey);
    }
}
