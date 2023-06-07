package Controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

import Views.F_Main;
import entities.CompteRendu;
import entities.Medecin;
import entities.Rendezvous;

public class MyDefaultTableModelAllCR extends DefaultTableModel {

	List<CompteRendu> Compterendu;
	HashSet<CompteRendu> modified;
	
	
	
	public MyDefaultTableModelAllCR(List<CompteRendu> Compterendu) {
		super();
		this.Compterendu = Compterendu;
		modified = new HashSet<CompteRendu>();
	}

	@Override
	public int getRowCount() {
		if (Compterendu == null) {
			return 0;
		}
		return Compterendu.size();
	}
	
	public HashSet<CompteRendu> getModified(){
		return modified;
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public String getColumnName(int column) {
		String name = null;
		switch (column) {
			case 0:
				name = "Rendez-vous";
				break;
			case 1:
				name = "Visiteur";
				break;
			case 2:
				name = "Médecin";
				break;
			case 3:
				name = "Colnfiance";
				break;
			case 4:
				name = "Lisibilité";
				break;
			case 5:
				name = "Problèmes";
				break;
			default:
				break;
		}
		return name;
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@Override
	public Object getValueAt(int row, int column) {
		CompteRendu CR = Compterendu.get(row);
		Object value = null;
		switch (column) {
			case 0:
				value = CR.getRendezvous().getId();
				break;
			case 1:
				value = CR.getUser().getId() + " | " + CR.getUser().getLogin();	
				break;
			case 2:
				value = CR.getMedecin().getNom();
				break;
			case 3:
				value = CR.getConfiance();
				break;
			case 4:
				value = CR.getLisibilite();
				break;
			case 5:
				value = CR.getProbleme();
				break;
			default:
				break;
		}
		return value;
	}
	
	@Override
	public void setValueAt(Object aValue, int row, int column) {
		CompteRendu cr = Compterendu.get(row);
		Object value = aValue;
		switch (column) {
			case 3:
				cr.setConfiance((String) value);
				break;
			case 4:
				cr.setLisibilite((String) value);
				break;
			case 5:
				cr.setProbleme((String) value);
				break;

			default:
				break;
		}
		modified.add(cr);
	}
	


	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class<?> type = null;
		switch (columnIndex) {
			case 0:
				type = Integer.class;
				break;
			case 1:
				type = String.class;
				break;
			case 2:
				type = String.class;
				break;
			case 3:
				type = String.class;
				break;
			case 4:
				type = String.class;
				break;
			case 5:
				type = String.class;
				break;
			default:
				break;
		}
		return type;
	}

	@Override
	public void removeRow(int row) {
		Compterendu.remove(row);
		super.removeRow(row);
	}
	
	

}
