package parking_lot;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
  private int size;
  private ParkingLotObserver attendent;
  private List<Car> parkedCars;

  ParkingLot(int size, ParkingLotObserver attendent) {
    this.size = size;
    this.attendent = attendent;
    attendent.addParkingLot(this);
    parkedCars = new ArrayList<>();
  }

  void park(Car car) throws ParkingLotFullException {
    if (parkedCars.size() == size){
      throw new ParkingLotFullException();
    }
    parkedCars.add(car);
    if(parkedCars.size() == size){
      this.attendent.notifyObserverWithFull(this);
    }
  }

  boolean unPark(Car car) {
    if(parkedCars.size()==size){
      this.attendent.notifyObserverWithFreeSpace(this);
    }
    return parkedCars.remove(car);
  }
}
