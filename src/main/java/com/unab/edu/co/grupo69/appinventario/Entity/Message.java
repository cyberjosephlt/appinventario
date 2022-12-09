package com.unab.edu.co.grupo69.appinventario.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    private int status;
    private String message;
}
