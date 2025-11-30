package com.ecomm.product.service;

import com.ecomm.product.dto.ProductPurchaseRequest;
import com.ecomm.product.dto.ProductPurchaseResponse;
import com.ecomm.product.dto.ProductRequest;
import com.ecomm.product.dto.ProductResponse;
import com.ecomm.product.exception.ProductNotFound;
import com.ecomm.product.exception.ProductPurchaseException;
import com.ecomm.product.mapper.ProductMapper;
import com.ecomm.product.product.Product;
import com.ecomm.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Integer createProduct(ProductRequest request) {
        Product product = productMapper.toProduct(request);
        return productRepository.save(product).getId();
    }

    public List<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseRequest> requests) {

    List<Integer> productIds = requests.stream()
            .map(ProductPurchaseRequest::getProductId).toList();

    List<Product> storedProducts = productRepository.findAllByIdInOrderById(productIds);

    if(productIds.size() != storedProducts.size()){
        throw  new ProductPurchaseException("one or more product not exist");
    }

    List<ProductPurchaseRequest> storedReq = requests.stream()
            .sorted(Comparator.comparing(ProductPurchaseRequest::getProductId))
            .toList();

    List<ProductPurchaseResponse> purchasedProducts= new ArrayList<>();

    for(int i = 0; i<storedProducts.size(); i++){
        Product product = storedProducts.get(i);

        ProductPurchaseRequest productRequest = storedReq.get(i);

        if(productRequest.getQuantity() > product.getAvailableQuantity()){
            throw  new ProductPurchaseException("Insufficient stock quantity for product with ");
        }

        double newAvailableQuantity =  (product.getAvailableQuantity()-productRequest.getQuantity());

        product.setAvailableQuantity(newAvailableQuantity);

        productRepository.save(product);

        purchasedProducts.add(productMapper.toProductPurchaseResponse(product, productRequest.getQuantity()));


    }

    return purchasedProducts;


    }

    public ProductResponse findById(Integer productId) {
        return productRepository.findById(productId)
                .map(productMapper::toProductResponse).orElseThrow(()->new ProductNotFound("Product Not Found with given Id "+productId));
    }

    public List<ProductResponse> findAll() {

        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
