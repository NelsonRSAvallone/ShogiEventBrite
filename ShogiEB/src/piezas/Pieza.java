/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piezas;

import shogieb.Cuadro;

/**
 *
 * @author Nelson
 */
public abstract class Pieza extends Cuadro{
	
	public Pieza(String colorIn, String typeIn) {
		super(typeIn);
		color = colorIn;
	} 
}
