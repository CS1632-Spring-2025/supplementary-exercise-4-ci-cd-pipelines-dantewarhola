package edu.pitt.cs;

import org.mockito.Mockito;
import static org.mockito.Mockito.when; 

public interface Cat {
	public static Cat createInstance(InstanceType type, int id, String name) {
		switch (type) {
			case IMPL:
				return new CatImpl(id, name);
			case BUGGY:
				return new CatBuggy(id, name);
			case SOLUTION:
				return new CatSolution(id, name);
			case MOCK:
			    Cat c = Mockito.mock(Cat.class);
				when(c.getId()).thenReturn(id);
				when(c.getName()).thenReturn(name);
				when(c.getRented()).thenReturn(false);
				when(c.toString()).thenReturn("ID " + id + ". " + name);
				return c;
			default:
				assert(false);
				return null;
		}
	}

	// WARNING: You are not allowed to change any part of the interface.
	// That means you cannot add any method nor modify any of these methods.
	
	public void rentCat();

	public void returnCat();

	public void renameCat(String name);

	public String getName();

	public int getId();

	public boolean getRented();

	public String toString();
}
