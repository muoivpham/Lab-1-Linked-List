package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import node.CountyNode;


public class CountyModel {
	public CountyNode loadAllCountyFromFile(String filename) throws FileNotFoundException {
		CountyNode head = new CountyNode("CountyNames");

		head.setRight(null);
		head.setDown(head);

		//read File
		String name;
		Scanner scanner = new Scanner(new File(filename));

		CountyNode tail = head;

		while (scanner.hasNextLine()) {
			name = scanner.nextLine();
			// Counties' Name
			// create county Node
			CountyNode newNode = new CountyNode(name);
			newNode.setRight(null);
			// create the County's LL

			// gan newNode -> down -> head
			newNode.setDown(head);
			// xxxx -> down -> newNode?
			tail.setDown(newNode);

			tail = newNode;
		}

		return head;
	}

}
