package group.isi.ecommerce.dto;

import group.isi.ecommerce.services.ProductService;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
public class ProductDto {

    @NotBlank(message="La reference est requise")
    private String ref;

    @NotBlank(message="Le nom est requis")
    private String name;

    @NotBlank(message="Le stock est requis")
    private double stock;

    @NotBlank(message="L utilisateur est requis")
    private long idUser;
}
