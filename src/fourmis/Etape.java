package fourmis;

public abstract class Etape {

	Etape next() {
		return this;
	}

	protected abstract void step();
	
}
