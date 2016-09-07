package baseInfo.converter;

import baseInfo.FileDurationUnit;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class FileDurationUnitConverter implements AttributeConverter<FileDurationUnit, Integer> {
    @Override
    public Integer convertToDatabaseColumn(FileDurationUnit fileDurationUnit) {
        return fileDurationUnit.getId();
    }

    @Override
    public FileDurationUnit convertToEntityAttribute(Integer id) {
        return FileDurationUnit.findById(id);
    }
}
