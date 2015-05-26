/*******************************************************************************
 * Copyright (c) 2010 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.usage.util.reader;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * @author Andre Dietisheim
 */
public class AppendUntilAlternativeImpl extends ReadUntilAlternativesImpl {

	private Writer writer;
	private int numOfWrittenCharacters;

	public AppendUntilAlternativeImpl(Reader reader, Writer writer, String... alternatives) {
		super(reader, alternatives);
		this.writer = writer;
	}

	@Override
	protected boolean doContinueRead(char character, int numberOfCharactersRead) throws IOException {
		if (super.doContinueRead(character, numberOfCharactersRead)) {
			if (!isMatching()) {
				// don't append matching characters
				writer.write(character);
				numOfWrittenCharacters++;
			}
			return true;
		} else {
			return false;
		}
	}

	public int getNumOfWrittenCharacters() {
		return numOfWrittenCharacters;
	}
}