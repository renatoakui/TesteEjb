package br.com.projeto;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Session Bean implementation class HelloBean
 */
@Stateless
@LocalBean
public class HelloBean implements HelloBeanLocal {

	@Inject ConsultarPorCdi cdi;
    /**
     * Default constructor. 
     */
    public HelloBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String getHelloMessage() {
//		String saida = "Hello mother fucker23456789";
		String saida = cdi.displayBean();
		return saida;
	}

}
