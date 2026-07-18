package br.com.vitorcarvalho.order_management_api.modules.exceptions;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(){
        super("Item not found. Please verify the ID.");
    }
}
