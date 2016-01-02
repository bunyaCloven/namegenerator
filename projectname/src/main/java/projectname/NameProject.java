package projectname;

public class NameProject {
	public static void main(String... args) {
		new NameGenerator(20, NameProject::isLongerThan3).run();
	}

	private static boolean isLongerThan3(char[] input) {
		return input.length > 3;
	}
}
