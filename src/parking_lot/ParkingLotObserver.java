package parking_lot;

interface ParkingLotObserver {

  void addParkingLot(ParkingLot parkingLot);

  void notifyObserver(ParkingLot parkingLot);

  boolean isParkingLotFull(ParkingLot parkingLot);
}
