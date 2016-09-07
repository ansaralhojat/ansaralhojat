package baseInfo.converter;

import baseInfo.FileFormat;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class FormatConverter implements AttributeConverter<FileFormat, Integer> {
    @Override
    public Integer convertToDatabaseColumn(FileFormat fileFormat) {
        return fileFormat.getId();
    }

    @Override
    public FileFormat convertToEntityAttribute(Integer id) {
        return FileFormat.findById(id);
    }
}
