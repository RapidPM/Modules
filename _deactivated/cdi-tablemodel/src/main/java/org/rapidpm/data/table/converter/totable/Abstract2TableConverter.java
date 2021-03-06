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

package org.rapidpm.data.table.converter.totable;

import org.apache.log4j.Logger;
import org.rapidpm.data.table.Table;
import org.rapidpm.data.table.TableCreator;

/**
 * Sven Ruppert - www.svenruppert.de
 *
 * @author Sven Ruppert
 * @version 0.1
 *          <p></p>
 *          This Source Code is part of the www.svenruppert.de project.
 *          please contact sven.ruppert@me.com
 * @since 03.06.2010
 * Time: 12:59:28
 */

public abstract class Abstract2TableConverter<E> implements Orm2TableConverter<E> {
    private static final Logger logger = Logger.getLogger(Abstract2TableConverter.class);

    protected abstract void setTableName(Table table);

    protected abstract <C extends ConfigElements> void convertImpl(final TableCreator tableCreator, E entity, C config);

    public abstract TableCreator creatTableCreator();

    @Override
    public <C extends ConfigElements> Table convert(final E entity, final C config) {
        final TableCreator tableCreator = creatTableCreator(); //refac verwende TableCreatorExecuter
        tableCreator.createNewTableInstance();
        tableCreator.getTable().setTableName("NeoScio Table");

        convertImpl(tableCreator, entity, config);

        final Table table = tableCreator.getTable();
        setTableName(table);
        table.reorderCellsInAllRows();
        table.reorderRows(1, false);
        return table;
    }

}
