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

package org.rapidpm.module.iot.tinkerforge;

import org.rapidpm.module.iot.tinkerforge.gui.cml.WaitForQ;
import org.rapidpm.module.iot.tinkerforge.sensor.Humidity;
import org.rapidpm.module.iot.tinkerforge.sensor.Light;
import org.rapidpm.module.iot.tinkerforge.sensor.MotionDectector;
import org.rapidpm.module.iot.tinkerforge.sensor.SoundIntensity;

import java.util.Date;

import static org.rapidpm.module.iot.tinkerforge.sensor.TinkerForgeSensor.SensorValueAction;

/**
 * Created by Sven Ruppert on 10.03.14.
 */
public class SchnarchRadar {
    public static final String HOST = "192.168.0.201";  //schnarchradar
    public static final int PORT = 4223;
    private static int callbackPeriod = 1000;

//    private static final SensorDataRepository repo = new SensorDataRepository(ArangoDBRemote.database);

    public static void main(String args[]) throws Exception {

        final Light light = new Light("jxn", callbackPeriod, PORT, HOST);
        light.actionAmbientLight = new SensorValueAction() {
            @Override
            public void workOnValue(int sensorvalue) {
                final double lux = sensorvalue / 10.0;
                final String text = "Lux   : " + lux + " Lux";
                System.out.println(text);
//                repo.saveSensorValue(sensorvalue, light);
            }
        };
//        new Thread(light).start();

        final Humidity humidity = new Humidity("kc8", callbackPeriod, PORT, HOST);
        humidity.actionHumidity = new SensorValueAction() {
            @Override
            public void workOnValue(int sensorvalue) {
                final double tempNorm = sensorvalue / 10.0;
                final String text = "RelHum: " + tempNorm + " %RH";
//                lcd20x4.printLine(2, text);
                System.out.println(text);
//                repo.saveSensorValue(sensorvalue,humidity);
            }
        };
//        new Thread(humidity).start();

        final SoundIntensity soundIntensity = new SoundIntensity("iQj", callbackPeriod, PORT, HOST);
        soundIntensity.actionSoundIntensity = new SensorValueAction(){
            @Override
            public void workOnValue(int sensorvalue) {
//                final double soundNorm = sensorvalue / 10.0;
                final String text = "Sound: " + sensorvalue + " dB";
//                lcd20x4.printLine(2, text);
                System.out.println(text);
//                repo.saveSensorValue(sensorvalue,soundIntensity);
            }
        };
//        new Thread(soundIntensity).start();

        final MotionDectector motionDetector = new MotionDectector("kgn", callbackPeriod, PORT, HOST);
//        soundIntensity.actionSoundIntensity = new SensorValueAction(){
//            @Override
//            public void workOnValue(int sensorvalue) {
////                final double soundNorm = sensorvalue / 10.0;
//                final String text = "Sound: " + sensorvalue + " dB";
////                lcd20x4.printLine(2, text);
//                repo.saveSensorValue(sensorvalue,soundIntensity);
//            }
//        };
          motionDetector.getBrickletInstance().addMotionDetectedListener(() -> {
              System.out.println("Motion detected.. " + new Date());
//              repo.saveSensorValue(1, motionDetector);
          });
        new Thread(motionDetector).start();

        WaitForQ.waitForQ();
    }
}
