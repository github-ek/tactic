package com.tacticlogistics.integrador.files.handlers.readers;

import java.io.IOException;
import java.nio.file.Path;

public interface Reader {
	String read(final Path input) throws IOException;
}