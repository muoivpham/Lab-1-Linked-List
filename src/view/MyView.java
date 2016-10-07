/**************************************************************************/
/*  Program Name:    Lab# 1                                               */
/*                                                                        */
/*  Student Name:    Muoi Pham                                            */
/*  Semester:        Fall,  2016                                          */
/*  Class & Section: CoSc 20803                                           */
/*  Instructor:      Dr. Comer                                            */
/*  Due Date:        October 6, 2016                                      */
/*                                                                        */
/*  Program Overview:                                                     */
/*      To exercise your knowledge of sequential and circular linked lists*/
/* 		The data structure you are required to build for this assignment  */
/* 		is shown later on in this lab specification                       */
/*                                                                        */
/*  Input:                                                                */
/*      Your program should provide a friendly and intuitive GUI that 	  */
/* 		allows the user to define and input data to support the required  */
/* 		functionality. Three data files will be provided for this 		  */
/* 		assignment 														  */
/*                                                                        */
/*  Output:                                                               */
/*     Three Java interfaces are shown at the bottom of this assignment.  */
/* 	   Your program MUST implement these three interfaces. 				  */
/* 		Additional decomposition is recommended.                          */
/*                                                                        */
/*  Program Limitations:                                                  */
/*      You MUST use this data structure in your program. 				  */
/* 		Java may provide classes that MIGHT do some of this program 	  */
/* 		for you – YOU ARE NOT ALLOWED TO USE THOSE CLASSES!!!! 			  */
/*		Also you may NOT use arrays or Vectors in solving this problem.   */
/*		Design your algorithms so that no “statically” allocated arrays   */
/*		or Vectors are needed. You should use node structures consistent  */
/*	 	with those shown below.                                           */
/*                                                                        */
/**************************************************************************/

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.TextField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import model.CountyModel;
import model.SpeciesModel;
import model.TreeModel;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import node.CountyNode;
import node.SpeciesNode;
import node.TreeNode;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyView extends JFrame {

	private JPanel contentPane;

	DefaultListModel<String> leftModel;
	DefaultListModel<String> rightModel;
	CountyModel countyModel = new CountyModel();
	SpeciesModel speciesModel = new SpeciesModel();
	TreeModel treeModel = new TreeModel();
	CountyNode tree;

	private JList leftList;
	private JList rightList;
	private JLabel lblIcon;
	private JPanel panel;
	private JButton btnCountynames;
	private JButton btnSpeciesNames;
	private JButton btnTreeWiltData;
	private JButton btnDisplay;
	private JButton btnNewButton;
	private JButton btnDisplayAllTt;
	private JButton btnAddNewTree;
	private JButton btnNewButton_1;
	private JButton btnDeleteTree;

	private String countyNamesFile = "";
	private String speciesNamesFile = "";
	private String treeWiltDataFile = "";

	boolean bCounty = false, bSpecies = false, bAll = false, bPoints = false;
	private JLabel lblAddFile;
	private JLabel lblDisplay;
	private JButton btnPointsExceeding;
	private JLabel lblOtherFunctions;
	private JTextField pointsTf = new JTextField(10);
	private SpeciesNode greatestS;

	void initRightModelSpecies(String name) {
		// name = Common Name Tree

		rightModel = new DefaultListModel<String>();
		CountyNode p = tree;
		while (p.getDown() != tree) {
			SpeciesNode headS = p.getDown().getRight();
			SpeciesNode nodeS = headS;
			while (nodeS.getRightPtr() != headS) {
				if (nodeS.getRightPtr().getCommonName().equals(name)) {

					TreeNode headT = nodeS.getRightPtr().getDownPtr();
					TreeNode tailT = nodeS.getRightPtr().getLastPtr();
					TreeNode nodeT = headT;

					while (nodeT != null) {
						rightModel.addElement(nodeT.toString());

						nodeT = nodeT.getDownPtr();
					}
				}
				nodeS = nodeS.getRightPtr();
			}

			p = p.getDown();
		}
		rightList.setModel(rightModel);
	}

	void initRightModelPoints(String name, double points) {
		// ??

		rightModel = new DefaultListModel<String>();
		CountyNode p = tree;
		while (p.getDown() != tree) {
			SpeciesNode headS = p.getDown().getRight();
			SpeciesNode nodeS = headS;
			while (nodeS.getRightPtr() != headS) {
				if (nodeS.getRightPtr().getCommonName().equals(name)) {
					// add trees to the SpeciesNode

					TreeNode headT = nodeS.getRightPtr().getDownPtr();
					TreeNode tailT = nodeS.getRightPtr().getLastPtr();
					TreeNode nodeT = headT;

					while (nodeT != null) {
						if (nodeT.getPoints() > points) {
							rightModel.addElement(nodeT.toString());
						}
						nodeT = nodeT.getDownPtr();
					}
				}
				nodeS = nodeS.getRightPtr();
			}

			p = p.getDown();
		}
		rightList.setModel(rightModel);
	}

	void initRightModelAll(String name) {
		// name = Common Name Tree

		rightModel = new DefaultListModel<String>();
		CountyNode p = tree;
		while (p.getDown() != tree) {
			SpeciesNode headS = p.getDown().getRight();
			SpeciesNode nodeS = headS;
			while (nodeS.getRightPtr() != headS) {

				if (nodeS.getRightPtr().getCommonName().equals(name)) {
					// add the tree to species Node

					TreeNode headT = nodeS.getRightPtr().getDownPtr();
					TreeNode tailT = nodeS.getRightPtr().getLastPtr();
					TreeNode nodeT = headT;

					if (nodeS.getRightPtr().getNumTrees() > 0) {
						rightModel.addElement(
								p.getDown().getCountyName() + "(" + nodeS.getRightPtr().getNumTrees() + "):");
					}

					while (nodeT != null) {

						rightModel.addElement(nodeT.toString());

						nodeT = nodeT.getDownPtr();
					}
				}
				nodeS = nodeS.getRightPtr();
			}

			p = p.getDown();
		}
		rightList.setModel(rightModel);
	}

	void initRightModelbyCounty(String name) {
		// name = CountyName

		rightModel = new DefaultListModel<String>();
		CountyNode p = tree;
		while (p.getDown() != tree) {
			if (p.getDown().getCountyName().equals(name)) {
				rightModel.addElement("The numTrees field of the " + p.getDown().getCountyName() + ": "
						+ String.valueOf(p.getDown().getNumTrees()));
				SpeciesNode headS = p.getDown().getRight();
				SpeciesNode nodeS = headS;
				while (nodeS.getRightPtr() != headS) {
					if (nodeS.getRightPtr().getNumTrees() != 0) {
						SpeciesNode nodeS1 = nodeS.getRightPtr();

						TreeNode headT = nodeS1.getDownPtr();
						TreeNode tailT = nodeS1.getLastPtr();
						TreeNode nodeT = headT;

						while (nodeT != null) {
							rightModel.addElement(nodeS1.getCommonName() + "/" + nodeT.toString());

							nodeT = nodeT.getDownPtr();
						}
					}
					nodeS = nodeS.getRightPtr();
				}
			}
			p = p.getDown();
		}
		rightList.setModel(rightModel);
	}

	void addNewTree(TreeNode newTree, String nameC) {

		CountyNode p = tree;
		while (p.getDown() != tree) {
			if (p.getDown().getCountyName().equals(nameC)) {
				SpeciesNode headS = p.getDown().getRight();
				SpeciesNode nodeS = headS;
				while (nodeS.getRightPtr() != headS) {
					if (nodeS.getRightPtr().getCommonName().equals(newTree.getName())) {
						SpeciesNode nodeS1 = nodeS.getRightPtr();

						TreeNode headT = nodeS1.getDownPtr();
						TreeNode tailT = nodeS1.getLastPtr();
						TreeNode nodeT = headT;
						// add new Node to last Node
						if (tailT == null) {
							nodeS.getRightPtr().setDownPtr(newTree);
							nodeS.getRightPtr().setLastPtr(newTree);
							System.out.println("add null");
						} else {
							tailT.setDownPtr(newTree);
							nodeS.getRightPtr().setLastPtr(newTree);
							System.out.println("add Tail");
						}
					}
					nodeS = nodeS.getRightPtr();
				}
			}
			p = p.getDown();
		}

	}

	void initModelByCounty() {
		leftModel = new DefaultListModel<String>();
		CountyNode headC = null;
		try {
			headC = countyModel.loadAllCountyFromFile(countyNamesFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CountyNode p = headC;
		while (p.getDown() != headC) {
			leftModel.addElement(p.getDown().getCountyName());

			p = p.getDown();
		}
		leftList.setModel(leftModel);

	}

	void initModelByAll() {
		leftModel = new DefaultListModel<String>();
		SpeciesNode headS = null;
		try {
			headS = speciesModel.loadAllSpeciesNames(speciesNamesFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SpeciesNode p = headS;
		while (p.getRightPtr() != headS) {
			leftModel.addElement(p.getRightPtr().getCommonName());

			p = p.getRightPtr();
		}
		leftList.setModel(leftModel);
	}

	void initModelByPoints() {
		leftModel = new DefaultListModel<String>();
		SpeciesNode headS = null;
		try {
			headS = speciesModel.loadAllSpeciesNames(speciesNamesFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SpeciesNode p = headS;
		while (p.getRightPtr() != headS) {
			leftModel.addElement(p.getRightPtr().getCommonName());
			p = p.getRightPtr();
		}
		leftList.setModel(leftModel);
	}

	void initModelBySpecies() {
		leftModel = new DefaultListModel<String>();
		SpeciesNode headS = null;
		try {
			headS = speciesModel.loadAllSpeciesNames(speciesNamesFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SpeciesNode p = headS;
		while (p.getRightPtr() != headS) {
			leftModel.addElement(p.getRightPtr().getCommonName());

			p = p.getRightPtr();
		}
		leftList.setModel(leftModel);
	}

	String searchForGreatestSpecies() {
		SpeciesNode headS = null;
		try {
			headS = speciesModel.loadAllSpeciesNames(speciesNamesFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SpeciesNode p = headS;
		int max = p.getRightPtr().getNumTrees();
		String ans = p.getRightPtr().getCommonName() + "/" + p.getRightPtr().getScientificName();

		while (p.getRightPtr() != headS) {
			if (p.getRightPtr().getNumTrees() > max) {
				max = p.getRightPtr().getNumTrees();
				ans = p.getRightPtr().getCommonName() + "/" + p.getRightPtr().getScientificName();
			}
			p = p.getRightPtr();
		}
		return ans;
	}

	void resetButton() {
		bCounty = false;
		bSpecies = false;
		bAll = false;
		bPoints = false;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyView frame = new MyView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyView() {
		try {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 700, 600);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);

			JSplitPane splitPane = new JSplitPane();
			contentPane.add(splitPane, BorderLayout.CENTER);

			JPanel panelLeft = new JPanel();
			JScrollPane scrollPane = new JScrollPane();
			panelLeft.setBorder(new TitledBorder("SELECTION"));
			panelLeft.add(scrollPane);
			splitPane.setLeftComponent(panelLeft);

			contentPane.add(new JLabel(new ImageIcon("Treeimg.png")), BorderLayout.NORTH);

			panel = new JPanel();
			contentPane.add(panel, BorderLayout.SOUTH);
			panel.setLayout(new MigLayout("", "[][][][][][]", "[][][][][][]"));

			btnCountynames = new JButton("CountyNames");
			btnCountynames.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fileChooser = new JFileChooser();
					int returnvalue = fileChooser.showOpenDialog(null);
					if (returnvalue == JFileChooser.APPROVE_OPTION) {
						File selectedFile = fileChooser.getSelectedFile();
						countyNamesFile = selectedFile.getAbsolutePath();
					}

				}
			});

			lblAddFile = new JLabel("Add File:");
			panel.add(lblAddFile, "cell 0 0");
			panel.add(btnCountynames, "cell 0 1");

			btnSpeciesNames = new JButton("Species Names");
			btnSpeciesNames.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fileChooser = new JFileChooser();
					int returnvalue = fileChooser.showOpenDialog(null);
					if (returnvalue == JFileChooser.APPROVE_OPTION) {
						File selectedFile = fileChooser.getSelectedFile();
						speciesNamesFile = selectedFile.getAbsolutePath();
					}

				}
			});
			panel.add(btnSpeciesNames, "cell 2 1");

			btnTreeWiltData = new JButton("Tree Wilt Data");
			btnTreeWiltData.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fileChooser = new JFileChooser();
					int returnvalue = fileChooser.showOpenDialog(null);
					if (returnvalue == JFileChooser.APPROVE_OPTION) {
						File selectedFile = fileChooser.getSelectedFile();
						treeWiltDataFile = selectedFile.getAbsolutePath();
					}
				}
			});
			panel.add(btnTreeWiltData, "cell 4 1");

			btnDisplay = new JButton("County Names");
			btnDisplay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if ((!countyNamesFile.equals("")) && (!speciesNamesFile.equals(""))
							&& (!treeWiltDataFile.equals(""))) {
						tree = treeModel.loadAllTree(countyNamesFile, speciesNamesFile, treeWiltDataFile);
						initModelByCounty();
						// init the rightModel
						bCounty = true;
						bSpecies = false;
						bAll = false;
						bPoints = false;

					} else {
						JOptionPane.showMessageDialog(null, "Add 3 files again");

					}

				}

			});

			lblDisplay = new JLabel("Display by: ");
			panel.add(lblDisplay, "cell 0 2");
			panel.add(btnDisplay, "cell 0 3");

			btnNewButton = new JButton("Common Names");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if ((!countyNamesFile.equals("")) && (!speciesNamesFile.equals(""))
							&& (!treeWiltDataFile.equals(""))) {
						tree = treeModel.loadAllTree(countyNamesFile, speciesNamesFile, treeWiltDataFile);
						initModelBySpecies();
						bCounty = false;
						bSpecies = true;
						bAll = false;
						bPoints = false;
					} else {
						JOptionPane.showMessageDialog(null, "Add 3 files again");
					}

				}
			});
			panel.add(btnNewButton, "cell 2 3");

			btnAddNewTree = new JButton("Add New Tree");
			btnAddNewTree.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if ((!countyNamesFile.equals("")) && (!speciesNamesFile.equals(""))
							&& (!treeWiltDataFile.equals(""))) {
						tree = treeModel.loadAllTree(countyNamesFile, speciesNamesFile, treeWiltDataFile);

						JTextField countyName = new JTextField(8);
						JTextField commonName = new JTextField(8);
						JTextField scientificName = new JTextField(8);

						JTextField points = new JTextField(5);
						JTextField circumferance = new JTextField(5);
						JTextField height = new JTextField(5);
						JTextField crownSpread = new JTextField(5);
						JTextField yrStart = new JTextField(5);
						JTextField yrEnd = new JTextField(5);

						JTextField treeDimensions = new JTextField(8);
						JTextField person = new JTextField(15);

						JPanel addTreePanel = new JPanel();
						JPanel panelNorth = new JPanel();
						JPanel panelCenter = new JPanel();
						JPanel panelSouth = new JPanel();
						addTreePanel.setLayout(new BorderLayout());

						panelNorth.add(new JLabel("County Name:"));
						panelNorth.add(countyName);

						panelNorth.add(Box.createHorizontalStrut(10)); // a
																		// spacer

						panelNorth.add(new JLabel("Common Name:"));
						panelNorth.add(commonName);

						panelNorth.add(Box.createHorizontalStrut(10)); // a
																		// spacer

						panelNorth.add(new JLabel("Scientific Name:"));
						panelNorth.add(scientificName);

						panelCenter.add(Box.createHorizontalStrut(10)); // a
																		// spacer

						panelCenter.add(new JLabel("Points >= 200 :"));
						panelCenter.add(points);

						panelCenter.add(new JLabel("Circumferance:"));
						panelCenter.add(circumferance);

						panelCenter.add(new JLabel("Height:"));
						panelCenter.add(height);

						panelCenter.add(new JLabel("Crown Spread:"));
						panelCenter.add(crownSpread);

						panelCenter.add(new JLabel("Year Start:"));
						panelCenter.add(yrStart);

						panelCenter.add(new JLabel("Year End:"));
						panelCenter.add(yrEnd);

						panelSouth.add(new JLabel("Name Person Registering The Tree:"));
						panelSouth.add(person);

						addTreePanel.add(panelNorth, BorderLayout.NORTH);
						addTreePanel.add(panelCenter, BorderLayout.CENTER);
						addTreePanel.add(panelSouth, BorderLayout.SOUTH);

						int result = JOptionPane.showConfirmDialog(null, addTreePanel,
								"Please Enter New Tree's Infomation", JOptionPane.OK_CANCEL_OPTION);
						
							double pointsInput = Double.parseDouble(points.getText());
							while (pointsInput < 200) {
								points.setText("");
								int result1 = JOptionPane.showConfirmDialog(null, addTreePanel,
										"Please Enter Points again", JOptionPane.OK_CANCEL_OPTION);
								pointsInput = Double.parseDouble(points.getText());
							}
						

						String[] info = new String[8];
						info[0] = commonName.getText();
						info[1] = points.getText();
						info[2] = circumferance.getText();
						info[3] = height.getText();
						info[4] = crownSpread.getText();
						info[5] = yrStart.getText();
						info[6] = yrEnd.getText();
						info[7] = person.getText();

						TreeNode newTree = new TreeNode(info);
						addNewTree(newTree, countyName.getText());
						initModelByAll();
						
					} else {
						JOptionPane.showMessageDialog(null, "Add 3 files again");
					}

				}
			});

			btnPointsExceeding = new JButton("Points Exceeding");
			btnPointsExceeding.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if ((!countyNamesFile.equals("")) && (!speciesNamesFile.equals(""))
							&& (!treeWiltDataFile.equals(""))) {
						tree = treeModel.loadAllTree(countyNamesFile, speciesNamesFile, treeWiltDataFile);

						JPanel addTreePanel = new JPanel();
						addTreePanel.add(new JLabel("A scale point value >= 200: "), BorderLayout.CENTER);
						addTreePanel.add(pointsTf, BorderLayout.CENTER);
						int result = JOptionPane.showConfirmDialog(null, addTreePanel, "Please Enter Points",
								JOptionPane.OK_CANCEL_OPTION);

						try {
							double pointsInput = Double.parseDouble(pointsTf.getText());
							while (pointsInput < 200) {
								pointsTf.setText("");
								int result1 = JOptionPane.showConfirmDialog(null, addTreePanel,
										"Please Enter Points again", JOptionPane.OK_CANCEL_OPTION);
								pointsInput = Double.parseDouble(pointsTf.getText());
							}
							initModelByPoints();
						} catch (NumberFormatException numEx) {
							int result1 = JOptionPane.showConfirmDialog(null, addTreePanel, "Please Enter Points again",
									JOptionPane.OK_CANCEL_OPTION);

						}

						bCounty = false;
						bSpecies = false;
						bAll = false;
						bPoints = true;
					} else {
						JOptionPane.showMessageDialog(null, "Add 3 files again");
					}

				}
			});
			panel.add(btnPointsExceeding, "cell 4 3");

			// All Trees
			btnDisplayAllTt = new JButton("All Trees");
			btnDisplayAllTt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if ((!countyNamesFile.equals("")) && (!speciesNamesFile.equals(""))
							&& (!treeWiltDataFile.equals(""))) {
						tree = treeModel.loadAllTree(countyNamesFile, speciesNamesFile, treeWiltDataFile);
						initModelByAll();
						bCounty = false;
						bSpecies = false;
						bAll = true;
						bPoints = false;

					} else {
						JPanel addTreePanel = new JPanel();
						JPanel panelCenter = new JPanel();
						JPanel panelSouth = new JPanel();
						panelCenter.add(new JLabel("Add 3 files again"));
						addTreePanel.setLayout(new BorderLayout());
						addTreePanel.add(panelCenter, BorderLayout.CENTER);

						int result = JOptionPane.showConfirmDialog(null, addTreePanel, "Error!!!",
								JOptionPane.OK_CANCEL_OPTION);
					}

				}

			});
			panel.add(btnDisplayAllTt, "cell 5 3");

			lblOtherFunctions = new JLabel("Other Functions:");
			panel.add(lblOtherFunctions, "cell 0 4");
			panel.add(btnAddNewTree, "cell 0 5");

			btnNewButton_1 = new JButton("Greatest Susceptibility");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					// load File and search for the greatest susceptibility to
					// oak tree wilt
					if ((!countyNamesFile.equals("")) && (!speciesNamesFile.equals(""))
							&& (!treeWiltDataFile.equals(""))) {
						tree = treeModel.loadAllTree(countyNamesFile, speciesNamesFile, treeWiltDataFile);

						// the tree occurring with the greatest frequency in the
						// data base
						JOptionPane.showMessageDialog(null, searchForGreatestSpecies());

					} else {
						JOptionPane.showMessageDialog(null, "Add 3 files again");

					}

				}
			});
			panel.add(btnNewButton_1, "cell 2 5");

			btnDeleteTree = new JButton("Delete Tree");
			btnDeleteTree.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					//
					if ((!countyNamesFile.equals("")) && (!speciesNamesFile.equals(""))
							&& (!treeWiltDataFile.equals(""))) {
						tree = treeModel.loadAllTree(countyNamesFile, speciesNamesFile, treeWiltDataFile);
						String nameLeft = (String) leftList.getSelectedValue();
						String nameRight = (String) rightList.getSelectedValue();

						if (bCounty) {
							// county Info
						} else {
							SpeciesNode headS = null;
							try {
								headS = speciesModel.loadAllSpeciesNames(speciesNamesFile);
							} catch (FileNotFoundException ex) {
								// TODO Auto-generated catch block
								ex.printStackTrace();
							}
							SpeciesNode p = headS;
							String str = nameLeft + "/" + nameRight;
							String[] treeinfo = str.split("/");
							TreeNode removeTree = new TreeNode(treeinfo);

							while (p.getRightPtr() != headS) {
								if (p.getRightPtr().getCommonName().equals(removeTree.getName())) {

									SpeciesNode nodeS1 = p.getRightPtr();

									TreeNode headT = nodeS1.getDownPtr();
									TreeNode tailT = nodeS1.getLastPtr();
									TreeNode nodeT = headT;
									if (headT != null && removeTree != null) {
										if (headT.compareTo(removeTree) == 0) {
											if (headT.getDownPtr() == null) {
												nodeS1.setDownPtr(null);
												nodeS1.setLastPtr(null);
											}
											nodeS1.setDownPtr(headT.getDownPtr());
											headT.setDownPtr(null);
										}
									}
									if (nodeT != null) {
										while (nodeT.getDownPtr() != null) {
											// if (head)
											TreeNode currentTree = nodeT.getDownPtr();
											if (currentTree.compareTo(removeTree) == 0)
												if (nodeS1.getLastPtr() == currentTree) {
													nodeS1.setLastPtr(nodeT);
													System.out.println("success");
												}
											nodeT.setDownPtr(currentTree.getDownPtr());
											nodeT = nodeT.getDownPtr();
										}
									}
								}
								p = p.getRightPtr();
							}
						}
						rightModel.remove(rightList.getSelectedIndex());

					} else {
						JOptionPane.showMessageDialog(null, "Add 3 files again");

					}

				}
			});
			panel.add(btnDeleteTree, "cell 4 5");

			leftList = new JList();
			leftList.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					String name = (String) leftList.getSelectedValue();

					if (bCounty)
						initRightModelbyCounty(name);
					if (bSpecies)
						initRightModelSpecies(name);
					if (bAll)
						initRightModelAll(name);
					if (bPoints) {
						try {
							initRightModelPoints(name, Double.parseDouble(pointsTf.getText()));
						} catch (NumberFormatException NFE) {

						}
					}
				}
			});
			leftList.setModel(new AbstractListModel() {
				String[] values = new String[] {};

				public int getSize() {
					return values.length;
				}

				public Object getElementAt(int index) {
					return values[index];
				}
			});
			scrollPane.setViewportView(leftList);

			JPanel panelRight = new JPanel();
			JScrollPane scrollPane_1 = new JScrollPane();

			splitPane.setRightComponent(scrollPane_1);

			rightList = new JList();
			scrollPane_1.setViewportView(rightList);
		} catch (Error e) {

		}
	}

}
