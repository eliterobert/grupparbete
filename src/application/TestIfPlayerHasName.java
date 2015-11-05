package application;

import org.junit.Assert;
import org.junit.Test;

public class TestIfPlayerHasName {

	@Test
	public void checkIfPlayerGetsANameWhenMade() {
		String name = "Player1";
		Player player = new Player(name, 1);
		Assert.assertTrue(player.getName().equals(name));
	}

}
