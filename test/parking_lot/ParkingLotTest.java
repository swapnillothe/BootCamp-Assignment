package parking_lot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

  @Test
  void shouldParkCarIntoTheParkingLot() throws ParkingLotFullException {
    ParkingLot parkingLot = new ParkingLot(20);
    Car car = new Car();

    int expectedPlace = 1;
    assertEquals(parkingLot.park(car),expectedPlace);
  }

  @Test
  void shouldThrowExceptionWhenParkingLotIsFullAndTryingToParkCarIntoTheParkingLot() throws ParkingLotFullException {
    ParkingLot parkingLot = new ParkingLot(1);
    Car car1 = new Car();
    Car car2 = new Car();
    parkingLot.park(car1);

    assertThrows(ParkingLotFullException.class,()->parkingLot.park(car2));
  }
}