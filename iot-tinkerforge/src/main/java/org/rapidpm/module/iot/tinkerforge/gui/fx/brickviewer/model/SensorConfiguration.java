package org.rapidpm.module.iot.tinkerforge.gui.fx.brickviewer.model;

import org.rapidpm.module.iot.tinkerforge.sensor.TinkerForgeSensor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenaernst on 22.02.14.
 */
public class SensorConfiguration {
    private final Sensor sensor;
    private List<Persistence> persistenceList = new ArrayList<>();
    private boolean connected;
    private Thread thread;
    private TinkerForgeSensor<?> tinkerForgeSensorConnection;

    private List<SensorValueActionConfiguration> sensorValueActionConfigurations = new ArrayList<>();

    public SensorConfiguration(Sensor sensor) {
        this.sensor = sensor;
    }

    public void addPersistence(Persistence persistence) {
        persistenceList.add(persistence);
    }

    public void removePersistence(Persistence persistence) {
        persistenceList.remove(persistence);
    }

    public Sensor getSensor() {
        return sensor;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public TinkerForgeSensor<?> getTinkerForgeSensorConnection() {
        return tinkerForgeSensorConnection;
    }

    public void setTinkerForgeSensorConnection(TinkerForgeSensor<?> tinkerForgeSensorConnection) {
        this.tinkerForgeSensorConnection = tinkerForgeSensorConnection;
    }

    public List<SensorValueActionConfiguration> getSensorValueActionConfigurations() {
        return sensorValueActionConfigurations;
    }

    public void addSensorValueAction(TinkerForgeSensor.SensorValueAction sensorValueAction) {
        getSensorValueActionConfigurations().add(new SensorValueActionConfiguration(sensorValueAction));
    }

    public void setSensorValueActionConfigurations(List<SensorValueActionConfiguration> sensorValueActionConfigurations) {
        this.sensorValueActionConfigurations = sensorValueActionConfigurations;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}