package codec;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;

public class JsonCodec<T> {

    public Optional<String> serialize(T t) {
        try {
            return Optional.of(new ObjectMapper().writeValueAsString(t));
        } catch (JsonProcessingException e) {
            return Optional.empty();
        }
    }

    public Optional<String> serializeList(List<T> t) {
        try {
            return Optional.of(new ObjectMapper().writeValueAsString(t));
        } catch (JsonProcessingException e) {
            return Optional.empty();
        }
    }
}
