package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class AirportTest {

    @DisplayName("Given 이코노미 항공편에서")
    @Nested
    class EconomyFlightTest{
        private Flight economyFlight;

        @BeforeEach
        void setUp() {
            economyFlight = new Flight("1", "Economy");
        }

        @Test
        @DisplayName("이코노미 항공편과 일반 승객에 관한 테스트")
        void testEconomyFlightRegularPassengers() {
            Passenger mike = new Passenger("Mike", false);
            assertThat(economyFlight.getId()).isEqualTo("1");
            assertThat(economyFlight.addPassenger(mike)).isTrue();
            assertThat(economyFlight.getPassengersList().size()).isEqualTo(1);
            assertThat(economyFlight.getPassengersList().get(0).getName()).isEqualTo("Mike");
            assertThat(economyFlight.removePassenger(mike)).isTrue();
            assertThat(economyFlight.getPassengersList().size()).isEqualTo(0);
        }

        @Test
        @DisplayName("이코노미 항공편과 VIP 승객에 관한 테스트")
        void testEconomyFlightVipPassenger() {
            Passenger james = new Passenger("James", true);
            assertThat(economyFlight.getId()).isEqualTo("1");
            assertThat(economyFlight.addPassenger(james)).isTrue();
            assertThat(economyFlight.getPassengersList().size()).isEqualTo(1);
            assertThat(economyFlight.getPassengersList().get(0).getName()).isEqualTo("James");
            assertThat(economyFlight.removePassenger(james)).isFalse();
            assertThat(economyFlight.getPassengersList().size()).isEqualTo(1);
        }
    }

    @DisplayName("Given 비즈니스 항공편에서")
    @Nested
    class BusinessFlightTest{
        private Flight businessFlight;

        @BeforeEach
        void setUp() {
            businessFlight = new Flight("2", "Business");
        }

        @Test
        @DisplayName("비즈니스 항공편과 일반 승객에 관한 테스트")
        void testBusinessFlightRegularPassenger() {
            Passenger mike = new Passenger("Mike", false);

            assertThat(businessFlight.addPassenger(mike)).isFalse();
            assertThat(businessFlight.getPassengersList().size()).isEqualTo(0);
            assertThat(businessFlight.removePassenger(mike)).isFalse();
            assertThat(businessFlight.getPassengersList().size()).isEqualTo(0);
        }

        @Test
        @DisplayName("비즈니스 항공편과 VIP 승객에 관한 테스트")
        void testBusinessFlightVipPassenger() {
            Passenger james = new Passenger("James", true);
            assertThat(businessFlight.addPassenger(james)).isTrue();
            assertThat(businessFlight.getPassengersList().size()).isEqualTo(1);
            assertThat(businessFlight.removePassenger(james)).isFalse();
            assertThat(businessFlight.getPassengersList().size()).isEqualTo(1);
        }
    }


}