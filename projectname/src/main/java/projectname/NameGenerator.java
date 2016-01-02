package projectname;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NameGenerator implements Runnable {
	private Integer count;
	private Random random;
	private List<NameValidator> validators;
	private static final Integer LETTER_COUNT = (((int) 'z') - ((int) 'a'));

	public NameGenerator(int count, NameValidator... validators) {
		this.count = count;
		this.validators = Arrays.asList(validators);
		this.random = new Random();
	}

	@Override
	public void run() {
		for (int i = 0; i < count; i++) {
			System.out.println(generateName());
		}
	}

	private char[] generateName() {
		boolean validated = true;
		char[] chars = new char[random.nextInt(20)];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = newChar();
		}
		for (NameValidator val : validators) {
			validated &= val.validate(chars);
		}
		if (validated) {
			return chars;
		} else {
			return generateName();
		}
	}

	private char newChar() {
		return (char) ((int) 'a' + random.nextInt(LETTER_COUNT));
	}
}
