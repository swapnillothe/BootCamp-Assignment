package parking_lot;

interface ParkingLotObserver {

  void addParkingLot(ParkingLot parkingLot);

  void notifyObserverWithFull(ParkingLot parkingLot);

  void notifyObserverWithFreeSpace(ParkingLot parkingLot);

  boolean isParkingLotFull(ParkingLot parkingLot);
}
