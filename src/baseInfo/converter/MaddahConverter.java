package baseInfo.converter;

import baseInfo.Lecturer;
import baseInfo.Maddah;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MaddahConverter implements AttributeConverter<Maddah, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Maddah maddah) {
        return maddah.getId();
    }

    @Override
    public Maddah convertToEntityAttribute(Integer id) {
        return Maddah.findById(id);
    }
}
