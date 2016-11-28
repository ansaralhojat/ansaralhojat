package baseInfo.converter;

import baseInfo.MaddahiCategory;
import baseInfo.MaddahiType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MaddahiCategoryConverter implements AttributeConverter<MaddahiCategory, Integer> {
    @Override
    public Integer convertToDatabaseColumn(MaddahiCategory maddahiCategory) {
        return maddahiCategory.getId();
    }

    @Override
    public MaddahiCategory convertToEntityAttribute(Integer id) {
        return MaddahiCategory.findById(id);
    }
}
