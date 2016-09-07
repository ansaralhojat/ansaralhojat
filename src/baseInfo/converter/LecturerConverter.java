package baseInfo.converter;

import baseInfo.Decorum;
import baseInfo.Lecturer;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LecturerConverter implements AttributeConverter<Lecturer, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Lecturer lecturer) {
        return lecturer.getId();
    }

    @Override
    public Lecturer convertToEntityAttribute(Integer id) {
        return Lecturer.findById(id);
    }
}
