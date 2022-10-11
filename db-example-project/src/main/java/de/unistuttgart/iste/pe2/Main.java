package de.unistuttgart.iste.pe2;

import de.unistuttgart.iste.pe2.examples.JDBCExamples;
import de.unistuttgart.iste.pe2.examples.ORMExamples;

public class Main {

	public static void main(String[] args) {

		JDBCExamples jdbcExamples = new JDBCExamples();
		jdbcExamples.runDemonstration();

		// ORMExamples ormExamples = new ORMExamples();
		// ormExamples.runDemonstration();
	}
}
