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

package org.rapidpm.demo.javafx.tableview.control.cell.callback;

import javax.inject.Inject;

import javafx.scene.Node;
import javafx.scene.control.TableCell;
import org.rapidpm.demo.cdi.commons.logger.CDILogger;
import org.rapidpm.demo.javafx.tableview.filtered.FilteredTableDataRow;
import org.rapidpm.module.se.commons.logger.Logger;

/**
 * User: Sven Ruppert Date: 17.09.13 Time: 16:44
 */
public abstract class AbstractEditingCell<T> extends TableCell<FilteredTableDataRow, T> {

    private @Inject @CDILogger Logger logger;

    @Override
    public void startEdit() {
        if (!isEmpty()) {
            super.startEdit();
            createValueField();
            setText(null);
            setGraphic(getGraphicNode());
            startEditIsNotEmptyLastActions();
        }
    }


    @Override
    public void updateItem(T item, boolean empty) {
        if (logger.isDebugEnabled()) {
            logger.debug("updateItem " + item);
        }
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                if (logger.isDebugEnabled()) {
                    logger.debug("isEditing == true");
                }
                updateItemIsEditing();
                setText(null);
                setGraphic(getGraphicNode());
            } else {
                setText(getString());
                setGraphic(null);
            }
        }
    }

    public String getString() {
        if (logger.isDebugEnabled()) {
            logger.debug("getString called ");
        }
        if (getItem() == null) {
            if (logger.isDebugEnabled()) {
                logger.debug("getString -> = '' ");
            }
            return "";
        } else {
            return getStringIfItemNotNull();
        }
    }

    public abstract void updateItemIsEditing();

    public abstract String getStringIfItemNotNull();

    public abstract void startEditIsNotEmptyLastActions();

    public abstract Node getGraphicNode();

    public abstract void createValueField();


}
