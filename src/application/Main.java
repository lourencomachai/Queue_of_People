package application;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import entities.Person;
import resources.PrintData;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//implementation of the functional interface
		PrintData pd = (n)->{
			Queue<Person> queue = n; 
			for (Person person: queue) {
				System.out.println(person.getId()+" -- "+person.getName());
			}
		};
		
		Queue<Person> queue = new LinkedList<Person>();
		
		System.out.print("Type the number of persons: ");
		int number = input.nextInt(); //int value
		
		int count = 0;
		
		while(count != number) {
			
			System.out.println("Person number "+(count+1));
			
			System.out.print("Type the id: ");
			Integer id = input.nextInt();
			input.nextLine();
			System.out.print("Type the name: ");
			String name = input.nextLine();
			
			//implementation of the Person interface (anonymous class)
			
			Person person = new Person(){
				private String name;
				
				private Integer id;
				
				public void setName(String name) {
					this.name = name;
				}
				
				public void setId(Integer id) {
					this.id =id;
				}
				
				public String getName() {
					return name;
				}
				
				public Integer getId() {
					return id;
				}
			};
			
			person.setId(id);
			person.setName(name);
			
			queue.add(person);
			
			count++;
		}
		
		pd.printData(queue);
		
		input.close();
	}

}
