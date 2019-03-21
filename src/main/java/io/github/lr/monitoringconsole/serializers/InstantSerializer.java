package io.github.lr.monitoringconsole.serializers;

import java.io.IOException;
import java.time.Instant;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import io.github.lr.monitoringconsole.utils.UtilsHelper;

/**
 * Serializador de instante de tiempo (Instant).
 * 
 * @author lravanal
 *
 */
public class InstantSerializer extends JsonSerializer<Instant> {

    @Override
    public void serialize(Instant value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
    	jsonGenerator.writeString(UtilsHelper.formatDateTime(value));
    }
    
}
