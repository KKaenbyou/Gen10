USE HotelDB;

-- 1. Write a query that returns a list of reservations that end in July 2023, including the name of the guest, the room number(s), and the reservation dates.
select room, `name`, startdate, enddate from reservations
where EndDate like '7/%/2023';
-- 4 results returned

-- 2. Write a query that returns a list of all reservations for rooms with a jacuzzi, displaying the guest's name, the room number, and the dates of the reservation.
select room, `name`, startdate, enddate from reservations r1
where r1.room in (select r2.room from rooms r2 where r2.amenities like '%Jacuzzi%');
-- 11 results returned

-- 3. Write a query that returns all the rooms reserved for a specific guest, including the guest's name, the room(s) reserved, the starting date of the reservation, and how many people were included in the reservation. (Choose a guest's name from the existing data.)
select room, `name`, startdate, adults, kids from reservations
where `name` = 'Kenji Kaenbyou';
-- 2 results returned

-- 4. Write a query that returns a list of rooms, reservation ID, and per-room cost for each reservation. The results should include all rooms, whether or not there is a reservation associated with the room.
select rooms.room, reservations.resid, reservations.totalcost, rooms.baseprice from rooms
left outer join reservations on rooms.room = reservations.room;
-- 26 results returned

-- 5. Write a query that returns all the rooms accommodating at least three guests and that are reserved on any date in April 2023.
select * from rooms r1
where r1.room in (select r2.room from reservations r2 where (r2.adults + r2.kids >= 3) and (r2.startdate like '4%2023' or r2.enddate like '4%2023'));
-- 0 results returned

-- 6. Write a query that returns a list of all guest names and the number of reservations per guest, sorted starting with the guest with the most reservations and then by the guest's last name.
select r.`name` Name, count(g.`name`) Reservations from guests g
left outer join reservations r on g.`name` = r.`name`
group by r.name
order by reservations desc;
-- 11 results returned

-- 7. Write a query that displays the name, address, and phone number of a guest based on their phone number. (Choose a phone number from the existing data.)
select `name`, address, phone from guests
where phone = '(843) 997-0640';
-- returns me