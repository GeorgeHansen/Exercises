-- 16
SELECT price, type FROM room WHERE hotelNo = (SELECT hotelNo FROM hotel WHERE hotelName = 'Grosvenor Hotel');

-- 17
SELECT guestName FROM guest 
JOIN booking on guest.guestNo = booking.guestNo
JOIN hotel on booking.hotelNo = hotel.hotelNo
WHERE hotel.hotelName = 'Grosvenor Hotel' AND booking.dateFrom LIKE '2014-08___';

-- 18

SELECT room.roomNo ,room.type, room.price, guest.guestName FROM room 
JOIN booking on room.roomNo = booking.roomNo
JOIN guest on booking.guestNo = guest.guestNo
JOIN hotel on booking.hotelNo = hotel.hotelNo
WHERE hotel.hotelName = 'Grosvenor Hotel'  AND booking.dateFrom LIKE '2014-08___';
-- why is the type s when this hotel doesn't have a room of type s? This hotel is supposed to only have room 4 and 5 why is 2 listed? 
-- I figure its because certain bookings have been assigned with a room number that shouldn't exsist. 

-- 19 Total income from Bookings?
SELECT SUM(price) from room
Join booking on room.hotelNo = booking.hotelNo
JOIN hotel on booking.hotelNo = hotel.hotelNo
WHERE hotelName = 'Grosvenor Hotel' AND booking.dateFrom Like '2014-08___' AND booking.dateTo Like '2014-08___' ;
-- returning 4100 this is wrong. There is only one room booking for this period at this hotel. The price should equal the same amount as that room. 

-- 20 Rooms currently unoccupied at Grosvenor Hotel
SELECT room.roomNo FROM room 
JOIN booking on room.roomNo = booking.roomNo
WHERE booking.datefrom not like '2014-08___' AND booking.hotelNo = 2; -- can't be arsed to check by hotel name. This is the hotel
-- is the answer  5 ? I want the answer to be 5

-- 21 Lost income from unoccupied rooms at said hotel?
SELECT SUM(price) from room 
JOIN booking on room.roomNo = booking.roomNo
WHERE booking.datefrom not like '2014-08___' AND booking.hotelNo = 2; 
-- sum of 2300. this sounds reasonable. Is it? Let me check. This looks right. Go figure'

-- 40 List details about hotels and bookings at the hotels that have bookings

SELECT * FROM hotel
Right JOIN booking on booking.hotelNo = hotel.hotelNo;
-- so yea this is it right? I think so. Other hotels don't have bookings

-- 41 all details about all hotels and bookings
SELECT * FROM hotel
LEFT JOIN booking on booking.hotelNo = hotel.hotelNo;
-- this it?

-- 42 All guests registered and their bookings
SELECT * FROM guest
LEFT JOIN booking b ON b.guestNo = guest.guestNo
UNION
SELECT * FROM guest
LEFT JOIN booking b ON b.guestNo = guest.guestNo;
-- Is there a way to do this with simple join?

-- 43 
SELECT guest.guestName, hotel.hotelName, booking.roomNo, booking.dateFrom, booking.dateTo FROM guest
JOIN booking on booking.guestNo = guest.guestNo
JOIN hotel on hotel.hotelNo = booking.hotelNo
-- since an inner join is just a join, is this fine?








