package isi.shoppingCart.usecases.services;

import isi.shoppingCart.entities.Cart;
import isi.shoppingCart.entities.CartItem;
import isi.shoppingCart.entities.Product;
import isi.shoppingCart.infrastructure.repositories.InMemoryCartRepository;
import isi.shoppingCart.infrastructure.repositories.InMemoryProductRepository;
import isi.shoppingCart.usecases.ports.CartRepository;
import isi.shoppingCart.usecases.ports.ProductRepository;

public class ConfirmPurchaseUseCase {
    private ProductRepository productRepository;
    private CartRepository cartRepository;

    public ConfirmPurchaseUseCase(ProductRepository productRepository,
                                  CartRepository cartRepository){
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    public String execute(){
        Cart cart = cartRepository.getCart();

        if (cart.getItems().isEmpty()) {
            return "ELl carrito está vació, no se puede continuar la compra hasta que no se tenga al menos un producto.";
        }

        for (CartItem item : cart.getItems()){
            Product product = item.getProduct();
            for(int i=0; i < item.getQuantity(); i++){
                product.decreaseAvailableQuantity();
            }
        }
        double Total = cart.getTotal();
        cart.clear();
        return "Compra Confirmada, Total $" + Total;
    }
}
