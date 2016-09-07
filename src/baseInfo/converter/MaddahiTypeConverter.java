package baseInfo.converter;

import baseInfo.FileType;
import baseInfo.MaddahiType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MaddahiTypeConverter implements AttributeConverter<MaddahiType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(MaddahiType maddahiType) {
        return maddahiType.getId();
    }

    @Override
    public MaddahiType convertToEntityAttribute(Integer id) {
        return MaddahiType.findById(id);
    }
}
