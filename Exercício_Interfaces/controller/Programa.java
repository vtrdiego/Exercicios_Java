package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Pessoa;
import viewer.JanelaPrincipal;

public class Programa {
	
	public static void main(String[] args) {
		Programa.recuperarObjetos();
		JanelaPrincipal janela = new JanelaPrincipal ();
		janela.setVisible(true);
		
	}
}
