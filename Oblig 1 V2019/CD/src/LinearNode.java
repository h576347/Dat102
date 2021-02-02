package no.hvl.dat102;

public class LinearNode<T> {
	private LinearNode<CD> neste;
	private CD element;
	
	/*****************Oppretter en tom node*****************************************************/
	
	public LinearNode()  {
		
		neste   =  null;
		element = null;
	}
	
	
	/*****************Oppretter en node med et element.*****************************************/
	
	public LinearNode (CD elem) {
		
		neste   = null;
		element = elem;
	}
	
	
	/******************Returnerer etterfølger.**************************************************/
	
	public LinearNode<CD> getNeste()  {
		
		return neste;
	}
	
	
	/******************Setter neste til node*****************************************************/
	
	public void setNeste (LinearNode<CD> node)  {
		
		neste = node;
	}
	
	
	/******************Returnerer elementet til denne noden***************************************/
	
	public CD getElement() {
		
		return element;
	
	}
	
	
	/*******************Setter nytt element i denne noden.******************************************/
	
	public void setElement (CD elem) {
		
		element = elem;
		}
	}


