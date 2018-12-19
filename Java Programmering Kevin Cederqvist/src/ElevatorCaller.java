import java.util.Scanner;
import java.util.Random;

public class ElevatorCaller {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		//creates a loop (constrained by a boolean) to randomly generate a floor the elevator starts on.
		//however, it cannot start on the 13th floor. No one goes to floor 13.
		boolean randLoop = true;
		int rand_num = 13;
		while (randLoop) {
			Random rand = new Random();
			rand_num = rand.nextInt(15);
			if (rand_num != 13) {
				randLoop = false;
			}
		}
		
		Elevator TheElevator = new Elevator(rand_num, "The Elevator"); //creates THE ELEVATOR

		System.out.println("Welcome to: " + Elevator.name + "!"); //TheElevator's name is The Elevator.
		//Yes, it is that simple.
		
		boolean mainLoop = true;
		while (mainLoop) {
			System.out.println("\n" + Elevator.name + " is currently on the " + //the loop keeps telling you what floor you are on
					TheElevator.getFloorName() + "."); //every time the elevator has stopped (including the first run)
			System.out.println("Which floor do you want to go to?");
			int number=scanner.nextInt();
			
			mainLoop = TheElevator.verifyFloor(number); //verifyFloor takes the floor number, and returns a boolean.
			//the reason for this is visible in the Elevator class.
		}
		scanner.close(); //scanner closes if mainLoop becomes false, which occurs when user travels from the 15th floor to bottom

	}
}
