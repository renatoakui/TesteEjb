package br.com.projeto;

import javax.ejb.Local;

@Local
public interface HelloBeanLocal {
	
	public String getHelloMessage();

}
