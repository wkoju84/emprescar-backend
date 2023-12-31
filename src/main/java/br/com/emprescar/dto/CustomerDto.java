package br.com.emprescar.dto;

import br.com.emprescar.model.Customer;

import java.io.Serializable;

public class CustomerDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String lastName;

//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
//    private Set<BookingDto> bookings = new HashSet<>();
    private UserDto user;

    public CustomerDto(Integer id, String name, String lastName/*, Set<BookingDto> bookings*/, UserDto user) {
        this.id = id;
        if(name != null) {
            this.name = name.trim();
        }
        if(lastName  != null) {
            this.lastName = lastName.trim();
        }
//        this.bookings = bookings;
        this.user = user;
    }

    public CustomerDto(Integer id) {
        this.id = id;
    }

    public CustomerDto(Customer entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.lastName = entity.getLastName();
//        if (entity.getBookings() != null) {
//            this.bookings = toBookingsDto(entity.getBookings());
//        }
        if (entity.getUser() != null) {
            this.user = new UserDto(entity.getUser());
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public Set<BookingDto> getBookings() {
//        return bookings;
//    }
//
//    public void setBookings(Set<BookingDto> bookings) {
//        this.bookings = bookings;
//    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    private Set<BookingDto> toBookingsDto(Set<Booking> bookings) {
//        Set<BookingDto> result = new HashSet<>();
//        for (Booking booking: bookings) {
//            result.add(new BookingDto(booking));
//        }
//        return result;
//    }





}
