package puzzles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class Test {
	
	public HashMap<String, Integer> aboveBelow(List<Integer> intList, int comparator) {
		System.out.println("Comparator: " + comparator);
		System.out.print("Integer input list: ");
		intList.forEach(i -> System.out.print(" | " + i));
		System.out.print("\n");
		HashMap<String, Integer> ab = new HashMap<String, Integer>();
		int above = 0; 
		int below = 0;
		
		for(Integer i : intList) {
			if(i == comparator) {
				continue;
			}
			if(i > comparator) {
				above++;
			} else if(i < comparator) {
				below++;
			}
		}
		
		ab.put("above", above);
		ab.put("below", below);
		
		for(Map.Entry<String, Integer> entry : ab.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		return ab; 
	}
	
	public String stringRotation(String myString, int rotation) {
		
		int length = myString.length();
		
		if(length == rotation) {
			System.out.println("No change, length matches string length so full rotation. Initial rotation: " + rotation + " | myString: " + myString + " | String length: " + length);
			return myString;
		}
			
		
		StringBuilder newString = new StringBuilder(myString.substring(length - rotation, length));
		newString.append(myString.substring(0, length-rotation));
		
		System.out.println("Initial rotation: " + rotation + " | Initial myString: " + myString + " | String length: " + length);
		System.out.println("Rotated myString: " + newString.toString() + " | String length: " + newString.length());
		return newString.toString();
	}
	
	public static void main(String[] args) throws IOException {
		Test test = new Test();
		Random rd = new Random();
		System.out.println("*Starting stringRotation*");
		String testString = UUID.randomUUID().toString().substring(0, 10);
		test.stringRotation(testString, rd.nextInt(testString.length()));
		//Add simple random unit tests
		System.out.println("*Ending stringRotation*\n");
		
		System.out.println("*Starting aboveBelow*");
		List<Integer> intList = new ArrayList<Integer>();/*Arrays.asList(1, 5, 2, 1, 10);*/
		
		for(int i = 0; i < 15; i++) {
			intList.add(rd.nextInt(10000));
		}
		test.aboveBelow(intList, rd.nextInt(10000));
		System.out.println("*Ending aboveBelow*");
	}
}

