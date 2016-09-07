package baseInfo.converter;

import baseInfo.Decorum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DecorumConverter implements AttributeConverter<Decorum, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Decorum decorum) {
        return decorum.getId();
    }

    @Override
    public Decorum convertToEntityAttribute(Integer id) {
        return Decorum.findById(id);
    }
}
