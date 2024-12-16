package group.isi.ecommerce.services.impl;

import group.isi.ecommerce.dto.ProductDto;
import group.isi.ecommerce.entities.ProductEntity;
import group.isi.ecommerce.exceptions.EntityExistsException;
import group.isi.ecommerce.exceptions.EntityNotFoundException;
import group.isi.ecommerce.mapper.ProductMapper;
import group.isi.ecommerce.repositories.ProductRepository;
import group.isi.ecommerce.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    public Optional<ProductDto> saveProduct(ProductDto productDto) {

        if (productRepository.findByRef(productDto.getRef()).isPresent()) {
            throw new EntityExistsException("");
        }
        var productEntity = productRepository.save(productMapper.toProductEntity(productDto));
        return Optional.of(productMapper.toProductDto(productEntity));

//        var productEntity = productRepository.save(productMapper.toProductEntity(productDto));
//        return (productEntity != null) ? Optional.of(productMapper.toProductDto(productEntity)) : Optional.empty();
    }

    @Override
    public Optional<ProductDto> updateProduct(ProductDto productDto) {
        return productRepository.findByRef(productDto.getRef())
                .map(product -> {
                    product.setRef(productDto.getRef());
                    product.setName(productDto.getName());
                    product.setStock(productDto.getStock());
                    product.setIdUser(productDto.getIdUser());
                    var productEntity = productRepository.save(product);
                    return Optional.of(productMapper.toProductDto(productEntity));
                })
                .orElseThrow(() -> new EntityNotFoundException(""));
    }

    @Override
    public boolean deleteProduct(String ref) {
        if (productRepository.findByRef(ref).isEmpty()) {
            throw new EntityNotFoundException("");
        }
        productRepository.deleteById(ref);
        return true;
    }

    @Override
    public Optional<List<ProductDto>> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        return Optional.of(productMapper.toProductDtoList(products));
    }

    @Override
    public Optional<ProductDto> getProductById(String ref) {
        return productRepository.findByRef(ref)
                .map(product -> Optional.of(productMapper.toProductDto(product)))
                .orElseThrow(()-> new EntityNotFoundException(""));
    }
}
