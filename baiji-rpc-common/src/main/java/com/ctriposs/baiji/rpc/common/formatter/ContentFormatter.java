package com.ctriposs.baiji.rpc.common.formatter;

import com.ctriposs.baiji.specific.SpecificRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface ContentFormatter {

    String getMediaType();

    String getExtension();

    String getEncoding();

    <T extends SpecificRecord> void serialize(OutputStream outputStream, T obj) throws IOException;

    <T extends SpecificRecord> T deserialize(Class<T> clazz, InputStream inputStream) throws IOException;
}
