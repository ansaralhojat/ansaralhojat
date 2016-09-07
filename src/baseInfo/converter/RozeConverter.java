package baseInfo.converter;

import baseInfo.Roze;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RozeConverter implements AttributeConverter<Roze, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Roze roze) {
        return roze.getId();
    }

    @Override
    public Roze convertToEntityAttribute(Integer id) {
        return Roze.findById(id);
    }
}
