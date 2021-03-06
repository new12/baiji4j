package com.ctriposs.baiji.rpc.common.formatter;

import com.ctriposs.baiji.Serializer;
import com.ctriposs.baiji.specific.SpecificRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class ContentFormatterBase implements ContentFormatter {

    private final String _mediaType;
    private final String _extension;
    private final String _encoding;
    private final Serializer _serializer;

    protected ContentFormatterBase(String mediaType, String extension, String encoding, Serializer serializer) {
        _mediaType = mediaType;
        _extension = extension;
        _encoding = encoding;
        _serializer = serializer;
    }

    @Override
    public String getMediaType() {
        return _mediaType;
    }

    @Override
    public String getExtension() {
        return _extension;
    }

    @Override
    public String getEncoding() {
        return _encoding;
    }

    @Override
    public <T extends SpecificRecord> void serialize(OutputStream outputStream, T obj) throws IOException {
        _serializer.serialize(obj, outputStream);
    }

    @Override
    public <T extends SpecificRecord> T deserialize(Class<T> clazz, InputStream inputStream) throws IOException {
        return _serializer.deserialize(clazz, inputStream);
    }
}
