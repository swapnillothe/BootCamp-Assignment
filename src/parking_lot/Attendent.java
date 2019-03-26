package parking_lot;


import java.util.HashMap;
import java.util.Map;

class Attendent implements ParkingLotObserver{
  private Map<ParkingLot, Boolean> parkingLots;

  Attendent() {
    this.parkingLots = new HashMap<>();
  }

  public void addParkingLot(ParkingLot parkingLot){
    this.parkingLots.put(parkingLot,Boolean.FALSE);
  }

  @Override
  public void notifyObserver(ParkingLot parkingLot) {
    parkingLots.put(parkingLot,Boolean.TRUE);
  }

  @Override
  public boolean isParkingLotFull(ParkingLot parkingLot) {
    return this.parkingLots.get(parkingLot);
  }
}
