package telran.view;

public class ExitItem extends Item {

	public ExitItem(InputOutput inputOutput) {
		super(inputOutput);
	}

	@Override
	public String displayedName() {
		return "Exit";
	}

	@Override
	public void perform() {
		inputOutput.displayLine("Bye, bye");
	}

	@Override
	public boolean isExit() {
		return true;
	}
}
