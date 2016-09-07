package baseInfo.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class OfferTypeConverter implements AttributeConverter<OfferType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(OfferType offerType) {
        return offerType.getId();
    }

    @Override
    public OfferType convertToEntityAttribute(Integer id) {
        return OfferType.findById(id);
    }
}
