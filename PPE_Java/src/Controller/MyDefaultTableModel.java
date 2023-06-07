package Controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

import Views.F_Main;
import entities.Rendezvous;

public class MyDefaultTableModel extends DefaultTableModel {

	List<Rendezvous> Rendezvous;
	HashSet<Rendezvous> modified;
	
	
	
	public MyDefaultTableModel(List<Rendezvous> Rendezvous) {
		super();
		this.Rendezvous = Rendezvous;
		modified = new HashSet<Rendezvous>();
	}

	@Override
	public int getRowCount() {
		if (Rendezvous == null) {
			return 0;
		}
		return Rendezvous.size();
	}
	
	public HashSet<Rendezvous> getModified(){
		return modified;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public String getColumnName(int column) {
		String name = null;
		switch (column) {
			case 0:
				name = "Id";
				break;
			case 1:
				name = "Nom";
				break;
			case 2:
				name = "Date";
				break;
			case 3:
				name = "Médecin";
				break;
			case 4:
				name = "Adresse";
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
		Rendezvous rdv = Rendezvous.get(row);
		Object value = null;
		switch (column) {
			case 0:
				value = rdv.getId();
				break;
			case 1:
				value = rdv.getNom();	
				break;
			case 2:
				value = rdv.getDate();
				break;
			case 3:
				value = rdv.getMedecin().getNom();
				break;
			case 4:
				value = rdv.getMedecin().getAdresse();
				break;
			default:
				break;
		}
		return value;
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		Rendezvous rdv = Rendezvous.get(row);
		Object value = aValue;
		switch (column) {
			case 1:
				rdv.setNom((String) value);	
				break;
			case 2:
				rdv.setDate((Date) value);
				break;
			default:
				break;
		}
		modified.add(rdv);
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
				type = Date.class;
				break;
			case 3:
				type = String.class;
				break;
			case 4:
				type = String.class;
				break;
			default:
				break;
		}
		return type;
	}

	@Override
	public void removeRow(int row) {
		Rendezvous.remove(row);
		super.removeRow(row);
	}
	
	

}
