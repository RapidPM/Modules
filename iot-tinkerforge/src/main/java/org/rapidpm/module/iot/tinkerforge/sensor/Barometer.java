/*
 * Copyright [2014] [www.rapidpm.org / Sven Ruppert (sven.ruppert@rapidpm.org)]
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

package org.rapidpm.module.iot.tinkerforge.sensor;

import com.tinkerforge.*;

import java.io.IOException;

/**
 * Created by Sven Ruppert on 09.02.14.
 */
public class Barometer extends TinkerForgeSensor<BrickletBarometer> {

    public BrickletBarometer getBrickletInstance() {
        return new BrickletBarometer(UID, ipcon);
    }

    public Barometer(String UID, int callbackPeriod, int port, String host) {
        super(UID, callbackPeriod, port, host);
    }

    public SensorValueAction actionAirPressure = new SensorValueAction(){};
    public SensorValueAction actionAltitude = new SensorValueAction(){};

    public void initBricklet() {
        try {
            bricklet.setAirPressureCallbackPeriod(callbackPeriod);
            bricklet.setAltitudeCallbackPeriod(callbackPeriod);
        } catch (TimeoutException | NotConnectedException e) {
            e.printStackTrace();
        }

        bricklet.addAirPressureListener(actionAirPressure::workOnValue);
        bricklet.addAltitudeListener(actionAltitude::workOnValue);
    }

}
