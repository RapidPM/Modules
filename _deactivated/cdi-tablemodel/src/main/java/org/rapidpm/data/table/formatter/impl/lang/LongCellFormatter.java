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

package org.rapidpm.data.table.formatter.impl.lang;

import org.apache.log4j.Logger;
import org.rapidpm.data.table.annotation.CellFormatter;
import org.rapidpm.data.table.formatter.CellValueFormatter;

/**
 * Sven Ruppert - www.svenruppert.de
 *
 * @author Sven Ruppert
 * @version 0.1
 *          <p></p>
 *          This Source Code is part of the www.svenruppert.de project.
 *          please contact sven.ruppert@me.com
 * @since 23.06.2010
 * Time: 01:11:24
 */
@CellFormatter(Long.class)
public class LongCellFormatter implements CellValueFormatter<Long> {
    private static final Logger logger = Logger.getLogger(LongCellFormatter.class);

    @Override
    public String format(final Long value) {
        return value.toString();
    }
}
