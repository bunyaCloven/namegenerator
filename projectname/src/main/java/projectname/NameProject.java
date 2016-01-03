package projectname;

public class NameProject {
	public static void main(String... args) {
		new NameProject();
	}

	public NameProject() {
		new NameGenerator(20, this::isLongerThan3, this::isShorterThan7,
				this::noTriples).run();
	}

	private boolean isLongerThan3(char[] input) {
		return input.length > 3;
	}

	private boolean isShorterThan7(char[] input) {
		return input.length < 7;
	}

	private boolean noTriples(char[] input) {
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
		boolean streakVowel = false;
		int count = 0;
		int maxCount = 0;
		for (char x : input) {
			if (isVowel(x) == streakVowel) {
				count++;
			} else {
				count = 1;
			}
			streakVowel = isVowel(x);
			if (count > maxCount) {
				maxCount = count;
			}
		}
		return maxCount < 3;
	}

	private boolean isVowel(char input) {
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
		for (char vowel : vowels) {
			if (vowel == input) {
				return true;
			}
		}
		return false;
	}
}
