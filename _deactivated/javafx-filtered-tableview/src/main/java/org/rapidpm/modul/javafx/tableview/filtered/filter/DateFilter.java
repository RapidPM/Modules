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

package org.rapidpm.modul.javafx.tableview.filtered.filter;

import java.util.Date;

import org.rapidpm.modul.javafx.tableview.filtered.FilteredTableView;
import org.rapidpm.modul.javafx.tableview.filtered.operators.operation.DefaultDateOperation;
import org.rapidpm.modul.javafx.tableview.filtered.operators.operation.Operation;

/**
 * Created with IntelliJ IDEA.
 * User: Sven Ruppert
 * Date: 06.05.13
 * Time: 13:06
 * To change this template use File | Settings | File Templates.
 */
public abstract class DateFilter<T> extends FilteredTableViewIterator<T, Date> {

    public DateFilter(FilteredTableView tableView) {
        super(tableView);
    }

    /**
     * z.B. return new DefaultStringOperation();
     */
    @Override
    public Operation getDefaultOperation() {
        return new DefaultDateOperation();
    }
}
