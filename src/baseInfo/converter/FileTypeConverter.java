package baseInfo.converter;

import baseInfo.FileType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class FileTypeConverter implements AttributeConverter<FileType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(FileType fileType) {
        return fileType.getId();
    }

    @Override
    public FileType convertToEntityAttribute(Integer id) {
        return FileType.findById(id);
    }
}
