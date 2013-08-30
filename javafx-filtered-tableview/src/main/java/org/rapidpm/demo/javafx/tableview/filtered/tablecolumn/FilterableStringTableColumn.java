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

package org.rapidpm.demo.javafx.tableview.filtered.tablecolumn;

import org.rapidpm.demo.javafx.tableview.filtered.operators.StringOperator;
import org.rapidpm.demo.javafx.tableview.filtered.tablecolumn.editor.TextFilterEditor;

/**
 * @author Sven Ruppert
 */
public class FilterableStringTableColumn<S, T>
        extends AbstractFilterableTableColumn<S, T, StringOperator, TextFilterEditor> {
    public FilterableStringTableColumn() {
        this("");
    }

    public FilterableStringTableColumn(String text) {
        super(text, new TextFilterEditor(text));
    }
}
