package baseInfo.converter;

import baseInfo.Decorum;
import baseInfo.FileUsage;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class FileUsageConverter implements AttributeConverter<FileUsage, Integer> {
    @Override
    public Integer convertToDatabaseColumn(FileUsage fileUsage) {
        return fileUsage.getId();
    }

    @Override
    public FileUsage convertToEntityAttribute(Integer id) {
        return FileUsage.findById(id);
    }
}
