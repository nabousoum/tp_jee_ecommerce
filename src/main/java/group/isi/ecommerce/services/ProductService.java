package group.isi.ecommerce.services;

import group.isi.ecommerce.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<ProductDto> saveProduct(ProductDto product);
    Optional<ProductDto> updateProduct(ProductDto product);
    boolean deleteProduct(String ref);
    Optional <List<ProductDto>> getAllProducts();
    Optional <ProductDto> getProductById(String ref);
}
