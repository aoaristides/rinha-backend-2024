package br.com.makersweb.makerspay.controllers;

import br.com.makersweb.makerspay.dto.request.TransactionRequest;
import br.com.makersweb.makerspay.dto.response.extract.ExtractResponse;
import br.com.makersweb.makerspay.services.CustomerService;
import br.com.makersweb.makerspay.services.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author anderson
 */
@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final TransactionService transactionService;

    @PostMapping("/{id}/transacoes")
    public ResponseEntity<?> transaction(@PathVariable final Long id, @RequestBody final TransactionRequest request) {
        return ResponseEntity.ok(transactionService.transaction(id, request));
    }

    @GetMapping("/{id}/extrato")
    public ResponseEntity<ExtractResponse> extract(@PathVariable final Long id) {
        return ResponseEntity.ok(customerService.extract(id));
    }

}
