package parking_lot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

  @Test
  void shouldParkCarIntoTheParkingLot() throws ParkingLotFullException {
    ParkingLotObserver attendant = new Attendant();
    ParkingLot parkingLot = new ParkingLot(20, attendant);
    Car car = new Car();

    assertDoesNotThrow(() -> parkingLot.park(car));
  }

  @Test
  void shouldThrowExceptionWhenParkingLotIsFullAndTryingToParkCarIntoTheParkingLot() throws ParkingLotFullException {
    ParkingLotObserver attendant = new Attendant();
    ParkingLot parkingLot = new ParkingLot(1, attendant);
    Car car1 = new Car();
    Car car2 = new Car();
    parkingLot.park(car1);

    assertThrows(ParkingLotFullException.class,()->parkingLot.park(car2));
  }

  @Test
  void shouldNotifyTheAttendedAfterParkingLotHasFull() throws ParkingLotFullException {
    TestAttendant attendant = new TestAttendant();
    ParkingLot parkingLot = new ParkingLot(1, attendant);
    Car car1 = new Car();
    parkingLot.park(car1);

    assertTrue(attendant.isNotifiedForParkingLotFull);
  }


  @Test
  void shouldNotifyTheAttendedWhenTheParkingLotGetFreeAfterGettingFull() throws ParkingLotFullException {
    TestAttendant attendent = new TestAttendant();
    ParkingLot parkingLot = new ParkingLot(1, attendent);
    Car car1 = new Car();
    parkingLot.park(car1);

    parkingLot.unPark(car1);

    assertTrue(attendent.isNotifiedForFreeParkingLot);
  }

}

class TestAttendant extends Attendant {
  boolean isNotifiedForParkingLotFull = false;
  boolean isNotifiedForFreeParkingLot = false;
  @Override
  public void notifyObserverWithFull(ParkingLot parkingLot) {
    isNotifiedForParkingLotFull = true;
  }

  @Override
  public void notifyObserverWithFreeSpace(ParkingLot parkingLot) {
    isNotifiedForFreeParkingLot = true;
  }
}

