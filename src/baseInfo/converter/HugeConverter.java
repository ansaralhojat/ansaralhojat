package baseInfo.converter;

import baseInfo.Huge;
import baseInfo.Roze;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class HugeConverter implements AttributeConverter<Huge, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Huge huge) {
        return huge.getId();
    }

    @Override
    public Huge convertToEntityAttribute(Integer id) {
        return Huge.findById(id);
    }
}
