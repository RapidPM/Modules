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

package gui.org.rapidpm.modul.javafx.searchbox.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.google.common.collect.Lists;
import gui.org.rapidpm.modul.javafx.searchbox.demo.DemoKeyMapper;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.rapidpm.commons.cdi.registry.property.CDIPropertyRegistryService;
import org.rapidpm.commons.cdi.registry.property.PropertyRegistryService;
import org.rapidpm.modul.javafx.searchbox.searchbox.SearchBoxDataElement;

/**
 * User: Sven Ruppert
 * Date: 30.08.13
 * Time: 07:28
 */
public class TransientDemoDataRow implements Serializable, SearchBoxDataElement {

    @Inject @CDIPropertyRegistryService PropertyRegistryService propertyRegistryService;
    @Inject
    DemoKeyMapper keyMapper;

    private StringProperty vorname;
    private StringProperty nachname;
    private StringProperty datum;
    private SimpleDoubleProperty betrag;

    private SimpleLongProperty ID; //normaly a normal Long, not shown at the table

    @PostConstruct
    public void init() {
        vorname = new SimpleStringProperty(this, map("vorname"));
        nachname = new SimpleStringProperty(this, map("nachname"));
        datum = new SimpleStringProperty(this, map("datum"));
        betrag = new SimpleDoubleProperty(this, map("betrag"));
        ID = new SimpleLongProperty(this, map("ID"));
    }

    private String map(final String key) {
        return propertyRegistryService.getRessourceForKey(keyMapper.map(key));
    }

    public void setBetrag(double betrag) {
        this.betrag.set(betrag);
    }

    public String getVorname() {
        return vorname.get();
    }

    public StringProperty vornameProperty() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname.set(vorname);
    }

    public String getNachname() {
        return nachname.get();
    }

    public StringProperty nachnameProperty() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname.set(nachname);
    }

    public String getDatum() {
        return datum.get();
    }

    public StringProperty datumProperty() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum.set(datum);
    }

    public Double getBetrag() {
        return betrag.get();
    }

    public DoubleProperty betragProperty() {
        return betrag;
    }

    public void setBetrag(Double betrag) {
        this.betrag.set(betrag);
    }

    public Long getID() {
        return ID.get();
    }

    public SimpleLongProperty IDProperty() {
        return ID;
    }

    public void setID(long ID) {
        this.ID.set(ID);
    }

    @Override public List<String> getValues() {
        return Lists.newArrayList(getID() + "", getVorname(), getNachname(), getDatum(), getBetrag() + "");
    }

    @Override public String shortInfo() {
        return getID() + " - " + getVorname() + " - " + getNachname() + " - " + getDatum() + " - " + getBetrag() + "";
    }
}
