package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import node.CountyNode;
import node.SpeciesNode;
import node.TreeNode;


public class TreeModel {

	public CountyNode loadAllTree(String cFile, String sFile, String tFile) {

		CountyModel countyModel = new CountyModel();

		SpeciesModel speciesModel = new SpeciesModel();

		CountyNode headC = null;
		try {
			headC = countyModel.loadAllCountyFromFile(cFile);

			SpeciesNode headS = speciesModel.loadAllSpeciesNames(sFile);

			CountyNode pCounty = headC;

			// copy all of species to the CountyNamesNode's rightPtr
			while (pCounty.getDown() != headC) {
				pCounty.getDown().setRight((SpeciesNode) headS.clone());
				pCounty = pCounty.getDown();
			}

			// In

			Scanner scanner = new Scanner(new File(tFile));
			// read file and build the whole linkedLists
			CountyNode countyNode = headC;
			while (scanner.hasNextLine()) {

				// execute
				String cName = scanner.nextLine();// A
				// search for the position of countyName
				while (countyNode.getDown() != headC) {
					if (countyNode.getDown().getCountyName().equals(cName))
						break;
					countyNode = countyNode.getDown();
				}

				// NodeA is the current countyNode we are looking for
				CountyNode nodeA = countyNode.getDown();// A

				SpeciesNode headSpeciesNodeOfA = nodeA.getRight();
				SpeciesNode speciesNode = headSpeciesNodeOfA;

				String line = scanner.nextLine();
				while (!line.equals("$$$$$")) {

					String[] treeinfo = line.split("/");
					String tName = treeinfo[0];
					// searching for the species name
					while (speciesNode.getRightPtr() != headSpeciesNodeOfA) {
						if (speciesNode.getRightPtr().getCommonName().equals(tName)) {
							int numbS = speciesNode.getRightPtr().getNumTrees();
							numbS++;
							speciesNode.getRightPtr().setNumTrees(numbS);

							int numbC = nodeA.getNumTrees();
							numbC++;
							nodeA.setNumTrees(numbC);

							break;
						}

						speciesNode = speciesNode.getRightPtr();
					}

					// speciesNode = s
					SpeciesNode speciesNodeX = speciesNode.getRightPtr();
					TreeNode t = new TreeNode(treeinfo);

					if (speciesNodeX.getDownPtr() == null) {
						speciesNodeX.setDownPtr(t);
					} else {
						speciesNodeX.getLastPtr().setDownPtr(t);
					}

					speciesNodeX.setLastPtr(t);
					line = scanner.nextLine();
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return headC;
	}
}
