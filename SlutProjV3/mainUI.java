package SlutProjV2;


import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JFileChooser;


//Startar Interface - en status rad, 2 textfields som tar emot filer och en knapp
class mainUI extends JFrame implements ActionListener {
	
	Button infile;
	Button outfile;
	Button StartOperation;
	Label giveInfile = new Label();  
	Label setOutputfile = new Label();
	public static Label Status;
	boolean inFileCorrect, outFileCorrect;
	public static File inFileName, outFileName;
	
	public mainUI() {
		
		this.setSize(600,230);
		this.setTitle("Kalkylark CSV till XML format");
		this.setLayout(new GridLayout(6,1));		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		Panel p4 = new Panel();
		Panel p5 = new Panel();
		Panel p6 = new Panel();
		
		
		Status = new Label("Välkommen!   Välj CSV fil!                ");
		p1.add(Status);
		
		
		giveInfile.setText("CSV fil:                                  ");
		infile = new Button("Välj CSV fil");
		p2.add(infile);
		p2.add(giveInfile);
		infile.addActionListener(this);
		
		setOutputfile.setText("Namn på blivande XML filen: ");
		outfile = new Button("Ange XML filen");
		p3.add(outfile);
		p3.add(setOutputfile);
		outfile.addActionListener(this);
		
		StartOperation = new Button("Starta konventering");
		p4.add(StartOperation);
		StartOperation.addActionListener(this);
		
				
		Label CSVinstructions = new Label("Observera CSV filen måste ha rätt format, kolla manualen!");
		p6.add(CSVinstructions);
		
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.add(p5);
		this.add(p6);
		this.setVisible(true);
	}

	
	
	// väntar på action från textfields eller knapp och sätter igång konverting om båda
	// filerna stämmer.
	public void actionPerformed (ActionEvent e) {
		
		if (e.getSource() == infile) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fileChooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				File testtest = fileChooser.getSelectedFile();
				inFileName = new File(testtest.getAbsolutePath());
				if (fileChecker(inFileName,1)) {
					inFileCorrect = true;
										giveInfile.setText(inFileName.getAbsolutePath());
					Status.setText("Korrekt!");
					System.out.println(inFileName.getAbsolutePath());
				} else giveInfile.setText("");	
				
				
			}
			
			
		}
		
		if (e.getSource() == outfile) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fileChooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				File testtest2 = fileChooser.getSelectedFile();
				outFileName = new File(testtest2.getAbsolutePath());
				if (fileChecker(outFileName,2)) {
					outFileCorrect = true;
					setOutputfile.setText(testtest2.getAbsolutePath());
					Status.setText("Korrekt!");
					System.out.println(outFileName.getAbsolutePath());
				} else setOutputfile.setText("");	
				
				
			}
			
			
		}
		
		if (e.getSource() == StartOperation) {
			if (inFileCorrect && outFileCorrect) {
				Status.setText("Båda är korrekt! Startar konvertering...");
				ConvertCSVtoXML newConversion = new ConvertCSVtoXML();
			} else Status.setText("Något är fel kolla filerna!");
		}
				
	}
	
	
	//kollar om filen kan skapas, redan finns eller är en katalog
	public boolean fileChecker(File filename, int inOroutFile){
	
		if(inOroutFile==1){
		    if (!filename.exists()){
			Status.setText(filename + " finns ej!");
			return false;
		    }
		    if(filename.isDirectory()){
			Status.setText(filename + " är en katalog!");
			return false;
		    }
		    if(!filename.canRead()){
			Status.setText(filename + " kan inte läsas!");
			return false;
		    }
		}
		
		if(inOroutFile==2){
		    if (filename.exists()){
			Status.setText(filename + " finns redan!");
			return false;
		    }
		    if(filename.isDirectory()){
			Status.setText(filename + " är en katalog!");
			return false;
		    }		    
		
		}return true;
	}
		
		
}
