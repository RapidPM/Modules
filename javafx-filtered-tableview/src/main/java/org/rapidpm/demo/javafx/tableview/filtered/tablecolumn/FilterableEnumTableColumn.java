/*
 * Copyright (c) 2013, jhsheets@gmail.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package org.rapidpm.demo.javafx.tableview.filtered.tablecolumn;

import org.rapidpm.demo.javafx.tableview.filtered.operators.EnumOperator;
import org.rapidpm.demo.javafx.tableview.filtered.tablecolumn.editor.EnumFilterEditor;
import org.rapidpm.demo.javafx.tableview.filtered.operators.EnumOperator;
import org.rapidpm.demo.javafx.tableview.filtered.tablecolumn.editor.EnumFilterEditor;

/**
 * @author Sven Ruppert
 */
public class FilterableEnumTableColumn<S, T>
        extends AbstractFilterableTableColumn<S, T, EnumOperator<T>, EnumFilterEditor<T>> {
    public FilterableEnumTableColumn() {
        this("", null);
    }

    public FilterableEnumTableColumn(String text) {
        this(text, null);
    }

    public FilterableEnumTableColumn(T[] enumValues) {
        this("", enumValues);
    }

    public FilterableEnumTableColumn(String text, T[] enumValues) {
        super(text, new EnumFilterEditor<>(text, enumValues));
    }

    public void setEnumValues(T[] enumValues) {
        getFilterEditor().populateMenuItems(enumValues);
    }
}
