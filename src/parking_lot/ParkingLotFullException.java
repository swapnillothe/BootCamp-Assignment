package parking_lot;

class ParkingLotFullException extends Exception{
  ParkingLotFullException() {
    super("parking Lot Full.");
  }
}
