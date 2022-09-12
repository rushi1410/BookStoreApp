package com.bridgelabz.bookstorebackend.service;
import com.bridgelabz.bookstorebackend.dto.CartDTO;
import com.bridgelabz.bookstorebackend.entity.Cart;

import java.util.List;
public interface ICartService {
    public Cart addCart(CartDTO cartdto);
    public List<Cart> getAllCartRecords();
    public Cart getCartRecord(Integer id);
    public Cart updateCartRecord(Integer id, CartDTO dto);
    public Cart deleteCartRecord(Integer id);
    public Cart updateQuantity(Integer id, Integer quantity);

}
