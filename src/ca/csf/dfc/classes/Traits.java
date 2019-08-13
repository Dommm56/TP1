package ca.csf.dfc.classes;

public enum Traits {
	
	SIX(6),
	HUIT(8),
	DIX(10),
	DOUZE(12),
	QUATORZE(14);
	
	private int m_trait;
	 
    Traits(int p_trait) {
        this.m_trait = p_trait;
    }
 
    public int getTrait() {
        return m_trait;
    }

}
