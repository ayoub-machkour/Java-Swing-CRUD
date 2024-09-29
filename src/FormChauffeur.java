import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
public class FormChauffeur 
{

   //les composants de Formchauffeur
    private ArrayList<Chauffeur> lst_chauffeur=new ArrayList<Chauffeur>();
	private JFrame frmGestionLaListe;
	private JTextField txtmatricule;
	private JTextField txtnom;
	private JTable table;
    private JComboBox cbaffectation;
    private JRadioButton rbmarie;
    private JRadioButton rbnonmarie;
    private JComboBox cbpermis;
    private JCheckBox chnouriture;
    private  JCheckBox chdeplacement;
    private JCheckBox chtelephone ;
    private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnModifier;
	private String matricule="0";
	/**
	 * Launch the application.
	 */
    //*************************************************************
    private void vider() 
	{
		txtmatricule.setText(null);
		txtnom.setText(null);
		cbaffectation.setSelectedIndex(-1);//aucune selection des villes
		cbpermis.setSelectedIndex(-1);//aucun permis n'est selectionne
		rbnonmarie.setSelected(true); //option non marie est selectionnee par defaut
		chnouriture.setSelected(false);//deselectionner option nouriture
		chdeplacement.setSelected(false);//deselectionner option deplacement
		chtelephone.setSelected(false);	//deselectionner option telephone					
	}
    
    //*************************************************************
    
    private void charger_table()
    {
    	
    	Object Data[][]=new Object[lst_chauffeur.size()][6];
    	
    	for(int i=0;i<lst_chauffeur.size();i++)
    	{
    		Data[i][0]=lst_chauffeur.get(i).getMatricule();
    		Data[i][1]=lst_chauffeur.get(i).getNom_prenom();
    		Data[i][2]=lst_chauffeur.get(i).getVille_travail();
    		Data[i][3]=lst_chauffeur.get(i).isMarie()==true?"Marie(e)":"Non Marie(e)";
    		Data[i][4]=lst_chauffeur.get(i).getType_permis();
    		Data[i][5]=lst_chauffeur.get(i).getSalaire();
    	}
    	table.setModel(new DefaultTableModel(
    			Data,
    			new String[] {
    				"Matricule", "Nom & Pr\u00E9nom", "Affectation", "Mari\u00E9(e)", "Permis", "Salaire"
    			}
    		));
    }
    
    
    
    //*************************************************************
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormChauffeur window = new FormChauffeur();
					window.frmGestionLaListe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormChauffeur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionLaListe = new JFrame();
		frmGestionLaListe.setTitle("Gestion la liste des Chauffeurs");
		frmGestionLaListe.setBounds(100, 100, 814, 688);
		frmGestionLaListe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionLaListe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Matricule Chauffeur");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(77, 50, 153, 39);
		frmGestionLaListe.getContentPane().add(lblNewLabel);
		
		JLabel lblNomPrnom = new JLabel("Nom & Pr\u00E9nom");
		lblNomPrnom.setForeground(Color.RED);
		lblNomPrnom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomPrnom.setBounds(77, 85, 153, 39);
		frmGestionLaListe.getContentPane().add(lblNomPrnom);
		
		JLabel lblAffectation = new JLabel("Affectation");
		lblAffectation.setForeground(Color.RED);
		lblAffectation.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAffectation.setBounds(77, 120, 153, 39);
		frmGestionLaListe.getContentPane().add(lblAffectation);
		
		JLabel lblSituationFamiliale = new JLabel("Situation Familiale");
		lblSituationFamiliale.setForeground(Color.RED);
		lblSituationFamiliale.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSituationFamiliale.setBounds(77, 149, 153, 39);
		frmGestionLaListe.getContentPane().add(lblSituationFamiliale);
		
		JLabel lblTypePermis = new JLabel("Type Permis");
		lblTypePermis.setForeground(Color.RED);
		lblTypePermis.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTypePermis.setBounds(77, 215, 153, 39);
		frmGestionLaListe.getContentPane().add(lblTypePermis);
		
		JLabel lblDivers = new JLabel("Divers");
		lblDivers.setForeground(Color.RED);
		lblDivers.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDivers.setBounds(77, 245, 153, 39);
		frmGestionLaListe.getContentPane().add(lblDivers);
		
		txtmatricule = new JTextField();
		txtmatricule.setBounds(219, 60, 162, 20);
		frmGestionLaListe.getContentPane().add(txtmatricule);
		txtmatricule.setColumns(10);
		
		txtnom = new JTextField();
		txtnom.setColumns(10);
		txtnom.setBounds(219, 95, 162, 20);
		frmGestionLaListe.getContentPane().add(txtnom);
		
		cbaffectation = new JComboBox();
		cbaffectation.setModel(new DefaultComboBoxModel(new String[] {"Paris", "Lyon", "Marseille", "Toulouse", "Nice", "Nantes", "Brest", "Lille"}));
		cbaffectation.setBounds(219, 129, 147, 22);
		frmGestionLaListe.getContentPane().add(cbaffectation);
		
		 rbmarie = new JRadioButton("Mari\u00E9(e)");
		 buttonGroup.add(rbmarie);
		rbmarie.setForeground(new Color(0, 0, 255));
		rbmarie.setFont(new Font("Tahoma", Font.BOLD, 12));
		rbmarie.setBounds(87, 185, 109, 23);
		frmGestionLaListe.getContentPane().add(rbmarie);
		
		 rbnonmarie = new JRadioButton("Non Mari\u00E9(e)");
		 buttonGroup.add(rbnonmarie);
		rbnonmarie.setForeground(new Color(0, 0, 255));
		rbnonmarie.setFont(new Font("Tahoma", Font.BOLD, 12));
		rbnonmarie.setBounds(198, 185, 109, 23);
		frmGestionLaListe.getContentPane().add(rbnonmarie);
		
		 cbpermis = new JComboBox();
		cbpermis.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C"}));
		cbpermis.setBounds(217, 224, 164, 22);
		frmGestionLaListe.getContentPane().add(cbpermis);
		
		 chnouriture = new JCheckBox("Nouriture");
		chnouriture.setBounds(87, 277, 97, 23);
		frmGestionLaListe.getContentPane().add(chnouriture);
		
		 chdeplacement = new JCheckBox("d\u00E9placement");
		chdeplacement.setBounds(199, 277, 97, 23);
		frmGestionLaListe.getContentPane().add(chdeplacement);
		
		 chtelephone = new JCheckBox("Tel\u00E9phone");
		chtelephone.setBounds(314, 277, 97, 23);
		frmGestionLaListe.getContentPane().add(chtelephone);
		
		JButton btAjouter = new JButton("Ajouter");
		btAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double salaire=1500;
				double salaire_divers=0;
				try
				{
				Chauffeur ch=new Chauffeur();
				
				if(txtmatricule.getText().length()==0 && txtnom.getText().length()==0)
				{
			         throw new Exception(); 
				}
				
				ch.setMatricule(txtmatricule.getText());
				ch.setNom_prenom(txtnom.getText());
				ch.setVille_travail(cbaffectation.getSelectedItem().toString());
				ch.setType_permis(cbpermis.getSelectedItem().toString());
				//traitement marie ou non
				if(rbmarie.isSelected()==true)
				   ch.setMarie(true)	;
				else
					  ch.setMarie(false);
			//traitement salaire
				
				if(cbpermis.getSelectedItem().toString().equals("A"))
					salaire+=500;
				else if(cbpermis.getSelectedItem().toString().equals("B"))
					salaire+=1000;	
				else
					salaire+=1500;
				if(chnouriture.isSelected()==true)
					{
					salaire+=1000;
					 salaire_divers+=1000;
					}
				if(chdeplacement.isSelected()==true)
					{salaire+=500;
					salaire_divers+=500;
					}
				if(chtelephone.isSelected()==true)
					{salaire+=300;
					salaire_divers+=300;
					}
				ch.setSalaire(salaire);
				ch.setSalaire_divers(salaire_divers);
				//ajouter l'objet ch dans arraylist nlst_chauffeur
				lst_chauffeur.add(ch);
				 vider();
				
				}catch(Exception ex) {JOptionPane.showMessageDialog(null, "Veuillez saisir toutes les informations!!!!!!!!!!!!!!!!!");}
				charger_table();
			}

			
		});
		btAjouter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btAjouter.setBounds(518, 85, 115, 34);
		frmGestionLaListe.getContentPane().add(btAjouter);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		try
		{
		 matricule=JOptionPane.showInputDialog("Entrer Matricule chauffeur : ");
		 lst_chauffeur.forEach(p->{
			   if(p.getMatricule().equalsIgnoreCase(matricule))
			   {
				   txtmatricule.setText(p.getMatricule());
				   txtnom.setText(p.getNom_prenom());
				   cbaffectation.setSelectedItem(p.getVille_travail());
				   cbpermis.setSelectedItem(p.getType_permis());
				   if(p.isMarie()==true)
					   rbmarie.setSelected(true);
				   else
					   rbnonmarie.setSelected(true);
				   
				   if(p.getSalaire_divers()==0)
				   {
					   chnouriture.setSelected(false);
					   chdeplacement.setSelected(false);
					   chtelephone.setSelected(false);
				   }
				   if(p.getSalaire_divers()==1800)
				   {
					   chnouriture.setSelected(true);
					   chdeplacement.setSelected(true);
					   chtelephone.setSelected(true);
				   }
				   if(p.getSalaire_divers()==1000)
				   {
					   chnouriture.setSelected(true);
					   chdeplacement.setSelected(false);
					   chtelephone.setSelected(false);
				   }
				   
				   if(p.getSalaire_divers()==500)
				   {
					   chnouriture.setSelected(false);
					   chdeplacement.setSelected(true);
					   chtelephone.setSelected(false);
				   }
				   if(p.getSalaire_divers()==300)
				   {
					   chnouriture.setSelected(false);
					   chdeplacement.setSelected(false);
					   chtelephone.setSelected(true);
				   }
				   if(p.getSalaire_divers()==1500)
				   {
					   chnouriture.setSelected(true);
					   chdeplacement.setSelected(true);
					   chtelephone.setSelected(false);
				   }
				   if(p.getSalaire_divers()==1300)
				   {
					   chnouriture.setSelected(true);
					   chdeplacement.setSelected(false);
					   chtelephone.setSelected(true);
				   }
				   if(p.getSalaire_divers()==800)
				   {
					   chnouriture.setSelected(false);
					   chdeplacement.setSelected(true);
					   chtelephone.setSelected(true);
				   }
				   
				   btnModifier.setEnabled(true);
				   
			   }
		     })	;		
					
					
				
		}catch (Exception err) {	}
				
				
				
				
			}
		});
		btnRechercher.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRechercher.setBounds(518, 129, 115, 39);
		frmGestionLaListe.getContentPane().add(btnRechercher);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				try
				{
					String mat=JOptionPane.showInputDialog("Entrer Le matricule du chauffeur � supprimer : ");
				/***************************************************************************************************	
					for(int i=0;i<lst_chauffeur.size();i++)
					{
						if(lst_chauffeur.get(i).getMatricule().equalsIgnoreCase(mat))
						{
							if( JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce chauffeur portant le matricule : "+mat,
									"Confirmation", JOptionPane.YES_NO_OPTION) ==JOptionPane.YES_OPTION)
							     {
								     lst_chauffeur.remove(i);
								}
							break;
						}
					}
					********************************************/
					
             /*****************************************************************
					for(Chauffeur c:lst_chauffeur)
					{
						if(c.getMatricule().equalsIgnoreCase(mat))
						{
							if( JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce chauffeur portant le matricule : "+mat,
									"Confirmation", JOptionPane.YES_NO_OPTION) ==JOptionPane.YES_OPTION)
							     {
								     lst_chauffeur.remove(c);
								}
							break;
						}
					}
					******************************************************************/
					/********************************************************************
				lst_chauffeur.forEach(c->{
					
					  if(c.getMatricule().equalsIgnoreCase(mat))
					  {
					           if( JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce chauffeur portant le matricule : "+mat,
							         "Confirmation", JOptionPane.YES_NO_OPTION) ==JOptionPane.YES_OPTION)
					                {
						                       lst_chauffeur.remove(c);
						              }
					   
					  }
			                       	});		
			       ***************************************************/
					/*****************************************************/
					Iterator<Chauffeur> it =lst_chauffeur.iterator();
					boolean trouver=false;
					while(it.hasNext())
					{
						Chauffeur ch=it.next();
						if(ch.getMatricule().equalsIgnoreCase(mat))
						{
							trouver=true;
							  if( JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce chauffeur portant le matricule : "+mat,
								         "Confirmation", JOptionPane.YES_NO_OPTION) ==JOptionPane.YES_OPTION)
						                {	
						                              	lst_chauffeur.remove(ch);
						                }				
							break;
						}
					}	
					
					if(trouver==false )
						   JOptionPane.showMessageDialog(null, "Ce Matricule "+mat+ " non enregistr� dans la liste");
					
				}catch(Exception ex) {}
				
				charger_table();
			}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSupprimer.setBounds(518, 181, 115, 39);
		frmGestionLaListe.getContentPane().add(btnSupprimer);
		
		 btnModifier = new JButton("Modifier");
		 btnModifier.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		double salaire=0,salaire_divers=0;
		 		try
		 		{
		 			
		 			for(Chauffeur ch:lst_chauffeur)
		 			{
		 				if(ch.getMatricule().equalsIgnoreCase(matricule)) 
		 				{
		 				     lst_chauffeur.remove(ch);
		 				     break;
		 				}
		 			}
		 			
		 			/********************************************/
		 			
		 			Chauffeur ch=new Chauffeur();
					ch.setMatricule(txtmatricule.getText());
					ch.setNom_prenom(txtnom.getText());
					ch.setVille_travail(cbaffectation.getSelectedItem().toString());
					ch.setType_permis(cbpermis.getSelectedItem().toString());
					//traitement marie ou non
					if(rbmarie.isSelected()==true)
					   ch.setMarie(true)	;
					else
						  ch.setMarie(false);
				//traitement salaire
					
					if(cbpermis.getSelectedItem().toString().equals("A"))
						salaire+=500;
					else if(cbpermis.getSelectedItem().toString().equals("B"))
						salaire+=1000;	
					else
						salaire+=1500;
					if(chnouriture.isSelected()==true)
						{
						salaire+=1000;
						 salaire_divers+=1000;
						}
					if(chdeplacement.isSelected()==true)
						{salaire+=500;
						salaire_divers+=500;
						}
					if(chtelephone.isSelected()==true)
						{salaire+=300;
						salaire_divers+=300;
						}
					ch.setSalaire(salaire);
					ch.setSalaire_divers(salaire_divers);
					//ajouter l'objet ch dans arraylist nlst_chauffeur
					lst_chauffeur.add(ch);
					 vider();
		 			/***********************************************************/		 				 		
		 			
		 		}		 			
		 		catch(Exception ex){}
		 		
		 		charger_table();
		 		btnModifier.setEnabled(false);
		 		vider();
		 	}
		 });
		btnModifier.setEnabled(false);
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModifier.setBounds(518, 234, 115, 30);
		frmGestionLaListe.getContentPane().add(btnModifier);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	 if(JOptionPane.showConfirmDialog(null, "Voulez-vous Quitter L'application",
			        "Confirmation", JOptionPane.YES_NO_OPTION) ==JOptionPane.YES_OPTION)
	 {
		 System.exit(0);
	 }	
			}
		});
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQuitter.setBounds(518, 277, 115, 39);
		frmGestionLaListe.getContentPane().add(btnQuitter);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(42, 368, 488, 209);
		frmGestionLaListe.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(255, 0, 128)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Matricule", "Nom & Pr\u00E9nom", "Affectation", "Mari\u00E9(e)", "Permis", "Salaire"
			}
		));
		scrollPane.setViewportView(table);
	}
}
