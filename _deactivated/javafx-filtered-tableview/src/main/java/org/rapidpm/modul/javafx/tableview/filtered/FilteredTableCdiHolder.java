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

package org.rapidpm.modul.javafx.tableview.filtered;

import java.util.Locale;

import javax.inject.Inject;

import org.rapidpm.commons.cdi.locale.CDILocale;
import org.rapidpm.commons.cdi.logger.CDILogger;
import org.rapidpm.commons.cdi.registry.property.CDIPropertyRegistryService;
import org.rapidpm.commons.cdi.registry.property.PropertyRegistryService;
import org.rapidpm.module.se.commons.logger.Logger;

/**
 * User: Sven Ruppert
 * Date: 21.06.13
 * Time: 13:26
 */
public class FilteredTableCdiHolder {

    private static final String COMPONENT_NAME = "javafx.filtered.tableview";

    private @Inject
    @CDILogger
    Logger logger;

    @Inject @CDIPropertyRegistryService
    private PropertyRegistryService propertyRegistryService;

    private @Inject @CDILocale
    Locale defaultLocale;

    public String getRessource(final String relativeKey) {
        final String mappedKey = propertyRegistryService.getRessourceForKey(COMPONENT_NAME + "." + relativeKey);
        if (logger.isDebugEnabled()) {
            logger.debug("mappedKey - " + mappedKey);
        }
        return mappedKey;
    }

}
