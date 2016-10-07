package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import node.SpeciesNode;


public class SpeciesModel {
	public SpeciesNode loadAllSpeciesNames(String fileName) throws FileNotFoundException {
		SpeciesNode head = new SpeciesNode("Head", "");
		SpeciesNode tail = head;

		Scanner scanner = new Scanner(new File(fileName));
		String line;
		String[] names = new String[2];
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			names = line.split("\\/");

			SpeciesNode newNode = new SpeciesNode(names[0], names[1]);

			newNode.setRightPtr(head);
			tail.setRightPtr(newNode);
			tail = newNode;
		}
		return head;
	}

}
