package isi.shoppingCart.usecases.services;

import isi.shoppingCart.entities.Cart;
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
    Cart cart = cartRepository.getCart();

    public String execute(){
        Cart cart = cartRepository.getCart();

        if (cart.getItems().isEmpty()) {
            return "EL carrito está vació, no se puede continuar la compra hasta que no se tenga al menos un producto.";
        }

        //pendientes:


        //recorrer items y descontar stock de cada uno


        //limpiar el carrito


        double Total = cart.getTotal();
        return "Compra Confirmada, Total $" + Total;
    }
}
