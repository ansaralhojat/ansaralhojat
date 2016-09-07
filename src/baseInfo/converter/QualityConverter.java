package baseInfo.converter;

import baseInfo.FileDurationUnit;
import baseInfo.Quality;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class QualityConverter implements AttributeConverter<Quality, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Quality quality) {
        return quality.getId();
    }

    @Override
    public Quality convertToEntityAttribute(Integer id) {
        return Quality.findById(id);
    }
}
