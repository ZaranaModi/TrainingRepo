package com.inexture.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Stack implements StackInterface {

	// Stack methods push,pop,peak,isEmpty

	Stack() {
		System.out.println("Stack Constructor is called...");
	}

	public static void main(String args[]) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		StackInterface stackobj = ctx.getBean("stackobj", Stack.class);
		List<Integer> stack = new ArrayList<Integer>();
		int position = 0;
		int element = 0;
		int score = 0;
		int option=0;
		Scanner in;
		try {
			System.out.println(
					"Welcome To Stack Game Player ! \n Press Below numbers to play stack game \n Press [1] for Adding Elements into stack \n Press [2] for Adding Element to Specific position \n Press [3] for Delete Element from stack \n Press [4] for getting value from specific position from stack \n Press [5] for viewing stack elements \n Press [6] for Quit the game");
			System.out.println("Select Any Number for HighScore : ");
			try {
				in = new Scanner(System.in);
				option = in.nextInt();
			} catch (Exception ex) {
				System.out.println("Please Enter Valid Value for Option");
				
			}
			while (option != 6) {

				switch (option) {

				case 1:
					stackobj.pushElement(stack);
					score = score + 5;
					break;

				case 2:
					if (stack.isEmpty()) {
						System.out.println("Opps !!!Stack iS EMPTY...");
						break;
					}
					System.out
							.println("Hey Player Welcome to stage 2! \n Enter Position of stack to add the Element :");
					in = new Scanner(System.in);
					position = in.nextInt();
					
					if ((stack.get(position)) == null) {
						System.out.println("Please Enter Valid Position");
						break;
					}
					System.out.println("Enter Element to Add : ");
					in = new Scanner(System.in);
					element = in.nextInt();

					stackobj.pushElement(stack, element, position);

					score = score + 3;
					break;

				case 3:
					System.out.println("Hey Player Welcome to Stage 3 (Delete) !");
					stackobj.popElement(stack);
					score = score + 2;
					break;

				case 4:
					stackobj.peakElement(stack);
					break;

				case 5:
					stackobj.printStack(stack);
					score = score + 10;
					break;

				case 6:
					System.out.println("Thank you for Playing this game your score is [" + score + "]");
					System.exit(0);
					break;

				default:
					System.out.println("Please Enter Valid option to play the stack game");
					score = score - 5;
					break;
				}
				System.out.println(
						"\n\nWelcome To Stack Game Player ! \n Press Below numbers to play stack game \n Press [1] for Adding Elements into stack \n Press [2] for Adding Element to Specific position \n Press [3] for Delete Element from stack \n Press [4] for getting value from specific position from stack \n Press [5] for viewing stack elements \n Press [6] for Quit the game");
				System.out.println("Select Any Number for HighScore : ");
				try {
					in = new Scanner(System.in);
					option = in.nextInt();
				} catch (Exception ex) {
					System.out.println("Please Enter Valid Value for Option");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pushElement(List<Integer> stack) {
		try {
		System.out.println(
				"Welcome to Add task of this stack game player. \n How many Elements you would like to add in stack ?");
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();

		for (int i = 0; i < size; i++) {
			System.out.println("Enter element in stack :");
			in = new Scanner(System.in);
			stack.add(in.nextInt());
		}
		System.out.println("Elements are added succeesfully into stack..");
		}catch (Exception e) {
			System.out.println("Please Enter Valid Value...");
		}
	}

	public void pushElement(List<Integer> stack, int element, int position) {
		try {
			if (stack.isEmpty()) {
				System.out.println("Opps !!!Stack iS EMPTY...");
			} else {
				if ((stack.get(position)) != null) {
					stack.add(position, element);
					System.out.println("Element " + element + " is added successfully at this position " + position
							+ " in Stack...");
				} else {
					System.out.println("Position is Out of range for stack");
				}
			}
		} catch (Exception e) {
			System.out.println("Please Enter Valid Value...");
		}
	}

	public void popElement(List<Integer> stack) {
		try {
			if (stack.isEmpty()) {
				System.out.println("Opps !!!Stack iS EMPTY...");
			} else {
				int element = (stack.get(stack.size() - 1));
				stack.remove(stack.size() - 1);
				System.out.println("Element [" + element + "] is removed successfully from the  Stack...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void peakElement(List<Integer> stack) {
		try {
			if (stack.isEmpty()) {
				System.out.println("Opps !!!Stack iS EMPTY...");
			} else {
				System.out.println("Top Element of stack is [" + stack.get(stack.size() - 1) + "]");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printStack(List<Integer> stack) {
		System.out.println("--------Set Elements----------");
		if (stack.isEmpty()) {
			System.out.println("Stack iS EMPTY...");
		} else {
			for (int temp : stack) {
				System.out.println(temp);
			}
		}
	}

}
