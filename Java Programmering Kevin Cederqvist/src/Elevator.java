
public class Elevator {
	int currentFloor;
	static String name; //Static, so there can only be ONE instance of the name.
	//This means one could make several elevators, however, they would all need
	//to use the same name. Great if the name is 'Grand Hotel Lobby Elevator' for example,
	//less so to distinguish the elevators (though that is partially handled via different
	//instance names

	Elevator(int startingFloor, String Name) {
		this.currentFloor = startingFloor;
		Elevator.name = Name;
	}

	Floor Floor0 = new Floor(0, "Entrance floor", "plings once for the bottom floor.");
	Floor Floor1 = new Floor(1, "1st floor", "plings once for the first floor.");
	Floor Floor2 = new Floor(2, "2nd floor", "plings 2 times for the 2nd floor.");
	Floor Floor3 = new Floor(3, "3rd floor", "plings 3 times for the 3rd floor.");
	Floor Floor4 = new Floor(4);
	Floor Floor5 = new Floor(5);
	Floor Floor6 = new Floor(6);
	Floor Floor7 = new Floor(7);
	Floor Floor8 = new Floor(8);
	Floor Floor9 = new Floor(9);
	Floor Floor10 = new Floor(10);
	Floor Floor11 = new Floor(11);
	Floor Floor12 = new Floor(12);
	Floor Floor13 = new Floor(13, "Thirteenth Floor", "is silent as you pass the 13th floor.");
	Floor Floor14 = new Floor(14);
	Floor Floor15 = new Floor(15);
	//num, name, 'pling' output on pass by
	
	Floor[] floorList = {Floor0, Floor1, Floor2, Floor3,
			Floor4, Floor5, Floor6, Floor7, Floor8, Floor9,
			Floor10, Floor11, Floor12, Floor13, Floor14, Floor15};
	
	boolean verifyFloor(int goToFloor){
		boolean OK = true;
		if (goToFloor == currentFloor) {
			System.out.println("You're already on this floor.");
		}
		else if (goToFloor < 0) {
			System.out.println("Too far down.");
		}
		else if (goToFloor > floorList.length -1) {
			System.out.println("Too far up.");
		}
		else if (goToFloor == 13) {
			System.out.println("We don't go to floor 13.");
		}
		else {
			OK = changeFloor(goToFloor);
		}
		return OK; //default true. Returns false only if entry floor is 15 and exit is 0.
	}

	private boolean changeFloor(int goToFloor){ //private so changeFloor cannot be accessed without verifyFloor first
		int tempFloor = currentFloor;
		if (goToFloor == 0 && currentFloor == 15) {
			System.out.println("The elevator plings 14 times as you pass the 14th floor.");
			System.out.println("The elevator almost plings 13 times as you pass the 13th floor.");
			System.out.println("The elevator almost tries to pling 12 times for the 12th floor, but the elevator is too fast.");
			System.out.println("The elevator plings furiously as you descend - 11th floor, 10th floor,");
			System.out.println("9th floor, 7th floor, 5th floor - it's a blur- ");
			System.out.println("");
			System.out.println("Then the deafening crash, and all is dark henceforth.");
			System.out.println("The end.");
			return false;
		}
		else if (goToFloor < currentFloor) { //descending
			while (tempFloor >= goToFloor) {
				if (tempFloor == currentFloor || tempFloor == goToFloor) {
					tempFloor -=1;
					}
				else {
					System.out.println(floorList[tempFloor].getPling_sound());
					tempFloor -=1;	
				}
				//The tempFloor var is used to count the floors you ascend/descend. With a disregard for your starting floor
				//& exit floor, it calls the getPling_sound method to make a sound for every floor you pass.
			}
			goDown(goToFloor);
		}
		else if (goToFloor > currentFloor) { //ascending
			while (tempFloor <= goToFloor) {
				if (tempFloor == currentFloor || tempFloor == goToFloor) {
					tempFloor +=1;
					}
				else {
					System.out.println(floorList[tempFloor].getPling_sound());
					tempFloor +=1;	
				}
			}
			goUp(goToFloor);
		}
		return true; //final return true in case ascending & descending is OK
	} //end of changeFloor
	
	//The goUp and goDown methods are useless, as the 'meat' of the code is 
	//contained in the if-statements that call upon either one, and the
	//methods themselves only call upon setFloor. However, the two
	//methods were technically listed as required, and have therefore remained.
	private void goUp(int floorsToGo){
		setFloor(floorsToGo);
		}
	private void goDown(int floorsToGo){
		setFloor(floorsToGo);
	}
	
	void setFloor(int floor) { //setFloor does not actually set the floor, that is handled by goUp/Down.
		//It does output the floor you've arrived to, however.
		currentFloor = floor;
		if (floor < 2)
		{
			System.out.println("The elevator plings once, announcing your arrival on the " +floorList[currentFloor].getName() + ".");
			}
		else {
			System.out.println("The elevator plings " + floorList[currentFloor].getNum() +
					" times, announcing your arrival on the " +floorList[currentFloor].getName() + ".");
			}
		}
	int getFloor() {
		return currentFloor;
	}

	String getFloorName() {
		return floorList[currentFloor].getName();
	}
	void setElevatorName(String name) {
		Elevator.name = name;
	}
	String getElevatorName() {
		return name;
	}
}
