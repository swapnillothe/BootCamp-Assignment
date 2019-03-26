package parking_lot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttendentTest {
  @Test
  void shouldNotifiedByParkingLotIfParkingLotIsFull() throws ParkingLotFullException {
    Car car = new Car();

    Attendent attendent = new Attendent();
    ParkingLot parkingLot = new ParkingLot(1, attendent);
    parkingLot.park(car);

    assertTrue(attendent.isParkingLotFull(parkingLot));
  }

  @Test
  void shouldNotNotifiedByParkingLotIfParkingLotIsNotFull() throws ParkingLotFullException {
    Car car = new Car();

    Attendent attendent = new Attendent();
    ParkingLot parkingLot = new ParkingLot(2, attendent);
    parkingLot.park(car);

    assertFalse(attendent.isParkingLotFull(parkingLot));
  }
}