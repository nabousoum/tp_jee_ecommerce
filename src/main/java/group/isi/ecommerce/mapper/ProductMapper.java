package group.isi.ecommerce.mapper;

import group.isi.ecommerce.dto.ProductDto;
import group.isi.ecommerce.entities.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductEntity toProductEntity(ProductDto productDto);
    ProductDto toProductDto(ProductEntity productEntity);
    List<ProductDto> toProductDtoList(List<ProductEntity> productEntityList);
    List<ProductEntity> toProductEntityList(List<ProductDto> productDtoList);
}
