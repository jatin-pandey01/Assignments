package com.aurionpro.authentication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableObjectOutputStream extends ObjectOutputStream {

	protected AppendableObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}
	
	@Override
    protected void writeStreamHeader() throws IOException {
        // do not write a header
        reset();
    }

}
