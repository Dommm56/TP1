package ca.csf.dfc.classes.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import javafx.event.ActionEvent;

public class actionPerformedTest {
	
	
    private boolean actionRealisee = false;
	
	@Test
	void constructeur() {
		assertThrows(IllegalArgumentException.class, () -> new ActionEvent(null, null));
	}

	@Test
	void actionPerformed() {
		ActionEvent a = new ActionEvent(e -> this.actionRealisee = true,);
		assertFalse(this.actionRealisee);
		a.actionPerformed(null);
		assertTrue(this.actionRealisee);
	}

}
