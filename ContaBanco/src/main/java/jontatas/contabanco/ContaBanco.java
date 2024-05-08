/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package jontatas.contabanco;

import jontatas.contabanco.Menus.MenuInicial;
import jontatas.contabanco.gestaoContas.ListaContas;

/**
 *
 * @author jonat
 */
public class ContaBanco {

    public static void main(String[] args) {
         ListaContas listaContas = new ListaContas(); 
         
        MenuInicial menu = new MenuInicial(); // Criando uma instância do menu inicial
        menu.menuInicial(listaContas); // Chamando o menu inicial e passando a lista de contas como argumento
    }
}
