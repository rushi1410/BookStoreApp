package com.bridgelabz.bookstorebackend.controller;
import com.bridgelabz.bookstorebackend.dto.CartDTO;
import com.bridgelabz.bookstorebackend.dto.ResponseDTO;
import com.bridgelabz.bookstorebackend.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {

    //Autowired ICartService to inject its dependency here
    @Autowired
    private ICartService cartService;

    //Ability to call api to add all cart records
    //localhost:8080/cart/add
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addBook(@Valid @RequestBody CartDTO cartdto){
        ResponseDTO dto = new ResponseDTO("User add successfully",cartService.addCart(cartdto));
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //Ability to call api to get all card records
    //localhost:8080/cart/getAllCarts
    @GetMapping("/getAllCarts")
    public ResponseEntity<ResponseDTO> getAllCartRecords(){
        ResponseDTO dto = new ResponseDTO("All records get successfully",cartService.getAllCartRecords());
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    //Ability to call api to get cart record by cart id
    //localhost:8080/cart/getCart/{id}
    @GetMapping("/getCart/{id}")
    public ResponseEntity<ResponseDTO> getBookRecord(@PathVariable Integer id){
        ResponseDTO dto = new ResponseDTO("Record get successfully",cartService.getCartRecord(id));
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    //Ability to call api to update cart by cart id
    //localhost:8080/cart/updateCart/{id}
    @PutMapping("/updateCart/{id}")
    public ResponseEntity<ResponseDTO> updateCartRecord(@PathVariable Integer id,@Valid @RequestBody CartDTO cartdto){
        ResponseDTO dto = new ResponseDTO("Record updated successfully",cartService.updateCartRecord(id,cartdto));
        return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
    }

    //Ability to call api to update quantity of book in cart by id
    //localhost:8080/cart/updateQuantity/{id}/{quantity}
    @PutMapping("/updateQuantity/{id}/{quantity}")
    public ResponseEntity<ResponseDTO> updateQuantity(@PathVariable Integer id,@PathVariable Integer quantity){
        ResponseDTO dto = new ResponseDTO("Quantity for book record updated successfully",cartService.updateQuantity(id,quantity));
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    //Ability to call api to delete cart by id
    //localhost:8080/cart/deleteCart/{id}
    @DeleteMapping("/deleteCart/{id}")
    public ResponseEntity<ResponseDTO> deleteCartRecord(@PathVariable Integer id) {
        ResponseDTO dto = new ResponseDTO("Record deleted successfully", cartService.deleteCartRecord(id));
        return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
    }
}
