package parking_lot;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
  private int size;
  private List<Car> parkedCars;

  ParkingLot(int size) {
    this.size = size;
    parkedCars = new ArrayList<>();
  }

  int park(Car car) throws ParkingLotFullException {
    if (parkedCars.size() == size){
      throw new ParkingLotFullException();
    }
    parkedCars.add(car);
    return parkedCars.size();
  }
}
