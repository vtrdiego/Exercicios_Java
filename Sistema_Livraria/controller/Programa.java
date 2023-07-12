package controller;

import model.AbstractDao;
import viewer.JanelaPrincipal;

public class Programa {

	public static void main(String[] args) {
		
		AbstractDao.recuperarObjetos();
		JanelaPrincipal janela = new JanelaPrincipal ();
		janela.setVisible(true);
		
	
	}

}
