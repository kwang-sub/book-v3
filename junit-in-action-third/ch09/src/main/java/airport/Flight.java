/*
 * ========================================================================
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */
package airport;

import java.util.HashSet;
import java.util.Set;

public class Flight {

    private String flightNumber;
    private int seats;
    Set<Passenger> passengers = new HashSet<>();

    public Flight(String flightNumber, int seats) {
        this.flightNumber = flightNumber;
        this.seats = seats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        if (passengers.size() > seats) {
            throw new RuntimeException("현재 승객 수보다 적은 좌석을 설정할 수 없습니다!");
        }
        this.seats = seats;
    }

    public int getNumberOfPassengers() {
        return passengers.size();
    }

    public boolean addPassenger(Passenger passenger) {
        if (passengers.size() >= seats) {
            throw new RuntimeException("좌석 수보다 더 많은 승객을 추가할 수 없습니다!");
        }
        return passengers.add(passenger);
    }

    public boolean removePassenger(Passenger passenger) {
        return passengers.remove(passenger);
    }

    @Override
    public String toString() {
        return "Flight " + getFlightNumber();
    }

}
