SELECT * FROM hotel, room; -- could add booking and guest. Depends what you mean by full details

SELECT * FROM hotel,room WHERE city LIKE"%London%";

SELECT guestName, guestAddress FROM guest WHERE guestAddress LIKE "%London%"
ORDER BY guestName DESC;

SELECT * FROM room WHERE type IN ('d', 'f') AND price <= 40
ORDER BY price; -- of course there aren't going to be any :p

SELECT * FROM booking WHERE dateTo is null;

SELECT COUNT(hotelNo) FROM hotel;

SELECT AVG(price) FROM room;

SELECT SUM(price) FROM room Where type = 'd'; -- this is assuming the rooms are filled of course

SELECT DISTINCT COUNT(guestNo) FROM booking WHERE dateTo LIKE "%08%"; 
-- you probably want to be less lazy to make sure this isnt 2008 or something. I'm guessing the __ thing would do it

SELECT hotelNo, count(roomNo) FROM ROOM
GROUP BY hotelNo; -- I wonder if there is an easy way to list the hotel name and the number of rooms they have

-- don't know. Referencing different tables? How to do?

INSERT INTO hotel VALUES (6,'Ritzy Biscuit','Copenhagen');

UPDATE room SET price = price * 1.05 WHERE roomNo >=0;


DELETE FROM hotel WHERE hotelNO = 6;







