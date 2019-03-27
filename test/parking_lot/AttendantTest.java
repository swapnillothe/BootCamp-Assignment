package parking_lot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttendantTest {
  @Test
  void shouldNotifiedByParkingLotIfParkingLotIsFull() throws ParkingLotFullException {
    Car car = new Car();

    Attendant attendant = new Attendant();
    ParkingLot parkingLot = new ParkingLot(1, attendant);
    parkingLot.park(car);

    assertTrue(attendant.isParkingLotFull(parkingLot));
  }

  @Test
  void shouldNotNotifiedByParkingLotIfParkingLotIsNotFull() throws ParkingLotFullException {
    Car car = new Car();

    Attendant attendant = new Attendant();
    ParkingLot parkingLot = new ParkingLot(2, attendant);
    parkingLot.park(car);

    assertFalse(attendant.isParkingLotFull(parkingLot));
  }
}