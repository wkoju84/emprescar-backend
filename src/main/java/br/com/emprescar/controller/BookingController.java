package br.com.emprescar.controller;

import br.com.emprescar.dto.BookingDto;
import br.com.emprescar.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<BookingDto>> searchAllBookings(@RequestParam(required = false) Integer productId, @RequestParam(required = false) Integer customerId) {

        if (productId != null) {
            List<BookingDto> list = bookingService.searchAllByProductId(productId);
            return ResponseEntity.ok().body(list);
        }
        if (customerId != null) {
            List<BookingDto> list = bookingService.searchAllByCustomerId(customerId);
            return ResponseEntity.ok().body(list);
        }
        List<BookingDto> list = bookingService.searchAll();
        return ResponseEntity.ok().body(list);

    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<BookingDto> insertBooking(@RequestBody BookingDto dto) {

        dto = bookingService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
