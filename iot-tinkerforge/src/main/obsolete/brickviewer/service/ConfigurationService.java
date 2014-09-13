package org.rapidpm.module.iot.tinkerforge.gui.fx.brickviewer.service;

import org.rapidpm.module.iot.tinkerforge.gui.cml.WaitForQ;
import org.rapidpm.module.iot.tinkerforge.gui.fx.brickviewer.model.Masterbrick;
import org.rapidpm.module.iot.tinkerforge.gui.fx.brickviewer.model.MasterbrickConfiguration;
import org.rapidpm.module.iot.tinkerforge.gui.fx.brickviewer.model.Sensor;
import org.rapidpm.module.iot.tinkerforge.gui.fx.brickviewer.model.SensorConfiguration;
import org.rapidpm.module.iot.tinkerforge.sensor.Temperature;
import org.rapidpm.module.iot.tinkerforge.sensor.TinkerForgeSensorSingleValue;

import java.util.List;

/**
 * Created by lenaernst on 22.02.14.
 */
public class ConfigurationService {

    public MasterbrickConfiguration initialize(MasterbrickConfiguration masterbrickConfiguration) {

        SensorConnector sensorConnector = new SensorConnector();

        //masterbrickConfiguration.getPersistenceConfigurationList().stream().forEach();

        masterbrickConfiguration.getSensorConfigurationList().stream().forEach(e -> {
            Sensor sensor = e.getSensor();
            TinkerForgeSensorSingleValue<?> sensorConnection = sensorConnector.connect(sensor);
            e.setTinkerForgeSensorConnection(sensorConnection);
            if (e.isConnected()) {

                if (sensorConnection instanceof Temperature) {
                    Temperature temperature = (Temperature) sensorConnection;
                    temperature.actionTemperature = e.getSensorValueActionConfigurations().get(0).getSensorValueAction();
                }

                Thread sensorConnectionThread = new Thread(sensorConnection);
                e.setThread(sensorConnectionThread);
                sensorConnectionThread.start();
            }
        });

        return masterbrickConfiguration;
    }

    public static void main(String[] args) {

        //Holt Masterbricks von Service
        MasterBrickService masterBrickService = new MasterBrickService();
        List<Masterbrick> masterbricks = masterBrickService.findMasterbricks();
        Masterbrick masterbrick = masterbricks.get(0);

        //Configuration
        MasterbrickConfiguration masterbrickConfiguration = new MasterbrickConfiguration(masterbrick);
        masterbrick.getSensorList().stream().forEach(e -> masterbrickConfiguration.addSensorConfiguration(e));

        SensorConfiguration sensorConfiguration = masterbrickConfiguration.getSensorConfigurationList().get(0);
        sensorConfiguration.addSensorValueAction(new TinkerForgeSensorSingleValue.SensorValueAction() {
            @Override
            public void workOnValue(int sensorvalue) {
                double correctedSensorValue = sensorvalue / 100.0;
                System.out.println("correctedSensorValue = " + correctedSensorValue);
            }
        });
        sensorConfiguration.setConnected(true);

        MasterbrickConfiguration initialized = new ConfigurationService().initialize(masterbrickConfiguration);
        Thread thread = sensorConfiguration.getThread();

        try {
            Thread.sleep(30000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WaitForQ.waitForQ();
    }
}
