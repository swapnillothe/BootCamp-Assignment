package parking_lot;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
  private int size;
  private ParkingLotObserver attendant;
  private List<Car> parkedCars;

  ParkingLot(int size, ParkingLotObserver attendant) {
    this.size = size;
    this.attendant = attendant;
    attendant.addParkingLot(this);
    parkedCars = new ArrayList<>();
  }

  void park(Car car) throws ParkingLotFullException {
    if (parkedCars.size() == size){
      throw new ParkingLotFullException();
    }
    parkedCars.add(car);
    if(parkedCars.size() == size){
      this.attendant.notifyObserverWithFull(this);
    }
  }

  boolean unPark(Car car) {
    if(parkedCars.size()==size){
      this.attendant.notifyObserverWithFreeSpace(this);
    }
    return parkedCars.remove(car);
  }
}
