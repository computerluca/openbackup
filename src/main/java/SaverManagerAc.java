public class SaverManagerAc{
	
	public static void main (String[] args){
		SaveManager sm = new SaveManager();
		sm.aggiungi_campo("ciao","coglione");
		
	sm.aggiungi_campo("partita_iva","aljdfòlakjfla");
	sm.aggiungi_campo("codicefiscale","add");
	
	System.out.println(sm.componi_campi());
	sm.Salva();
	
	
	
	
	
}}
