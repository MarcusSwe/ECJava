package SlutProjV2;


import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.WindowConstants;
import javax.swing.JFrame;


//Startar Interface - en status rad, 2 textfields som tar emot filer och en knapp
class mainUI extends JFrame implements ActionListener {
	
	TextField infile;
	TextField outfile;
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
		
		
		Status = new Label("Välkommen!   Välj CSV fil!");
		p1.add(Status);
		
		giveInfile.setText("                                       CSV fil: ");
		infile = new TextField(30);
		p2.add(giveInfile);
		p2.add(infile);
		infile.addActionListener(this);
		
		setOutputfile.setText("Namn på blivande XML filen: ");
		outfile = new TextField(30);
		p3.add(setOutputfile);
		p3.add(outfile);
		outfile.addActionListener(this);
		
		StartOperation = new Button("Starta konventering");
		p4.add(StartOperation);
		StartOperation.addActionListener(this);
		
		Label InstructionsInputFormat = new Label("Ange exakt filaddress ex: C:\\TEST.TXT och tryck Enter");
		p5.add(InstructionsInputFormat);
		
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
			String infile2 = infile.getText();
			inFileName = new File(infile2);
			if (fileChecker(inFileName, 1)) {
				inFileCorrect = true;
				Status.setText("Filen fanns!");
				giveInfile.setText("                                       Korrekt! ");
			} else { inFileCorrect = false;
			giveInfile.setText("                                       CSV fil: ");
			}
		}
		
		if (e.getSource() == outfile) {
			String outfile2 = outfile.getText();
			outFileName = new File(outfile2);
			if (fileChecker(outFileName, 2)) {
				outFileCorrect = true;
				Status.setText("Filen skapad och redo.");
				setOutputfile.setText("                                       Korrekt! ");
			} else { outFileCorrect = false;
			setOutputfile.setText("Namn på blivande XML filen: ");
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
