package com.javalesson.exeption;

import java.io.Closeable;
import java.io.IOException;

public interface SelfCloseble extends Closeable {
    @Override
    void close() throws IOException;
}
