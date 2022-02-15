USE HotelDB;

INSERT INTO roomtype (typeid, rtype) VALUES
(1, 'Single'),
(2, 'Double'),
(3, 'Suite');

INSERT INTO amenities (amenid, rtype) VALUES
(1, 'Refridgerator'),
(2, 'Microwave, Refridgerator'),
(3, 'Microwave, Jacuzzi'),
(4, 'Microwave, Refrigerator, Jacuzzi'),
(5, 'Microwave, Refrigerator, Oven');

INSERT INTO Rooms (Room, `Type`, Amenities, ADA, SOccupancy, MOccupancy, BasePrice, ExtraPerson) VALUES
(201, 	1, 	3, 'No', 	2, 	4, 	'$199.99', 	'$10'),
(202, 	2, 	1, 'Yes', 	2, 	4, 	'$174.99', 	'$10'),
(203, 	2, 	3, 'No', 	2, 	4, 	'$199.99', 	'$10'),
(204, 	2, 	1, 'Yes', 	2, 	4, 	'$174.99', 	'$10'),
(205, 	1, 	4, 'No', 	2, 	2, 	'$174.99', NULL),
(206, 	1, 	2, 'Yes', 	2, 	2, 	'$149.99', NULL),
(207, 	1, 	4, 'No', 	2, 	2, 	'$174.99', NULL),
(208, 	1, 	2, 'Yes', 	2, 	2, 	'$149.99', NULL),
(301, 	2, 	3, 'No', 	2, 	4, 	'$199.99', 	'$10'),
(302, 	2, 	1, 'Yes', 	2, 	4, 	'$174.99', 	'$10'),
(303, 	2, 	3, 'No', 	2, 	4, 	'$199.99', 	'$10'),
(304, 	2, 	1, 'Yes', 	2, 	4, 	'$174.99', 	'$10'),
(305, 	1, 	4, 'No', 	2, 	2, 	'$174.99', NULL),
(306, 	1, 	2, 'Yes', 	2, 	2, 	'$149.99', NULL),
(307, 	1, 	4, 'No', 	2, 	2, 	'$174.99', NULL),
(308, 	1, 	2, 'Yes', 	2, 	2, 	'$149.99', NULL),
(401, 	3, 	5, 'Yes', 	3, 	8, 	'$399.99', 	'$20'),
(402, 	3, 	5, 'Yes', 	3, 	8, 	'$399.99', 	'$20');

INSERT INTO Guests (`Name`, Address, City, State, ZIP, Phone) VALUES
('Kenji Kaenbyou',	 	'2038 Chadbury Lane', 	'Charlotte',	 	'NC', 	28206, 	'(843) 997-0640'),
('Mack Simmer', 		'379 Old Shore Street', 'Council Bluffs', 	'IA', 	51501, 	'(291) 553-0508'),
('Bettyann Seery', 		'750 Wintergreen Dr.', 	'Wasilla', 			'AK', 	99654, 	'(478) 277-9632'),
('Duane Cullison',		'9662 Foxrun Lane', 	'Harlingen',	 	'TX', 	78552, 	'(308) 494-0198'),
('Karie Yang', 			'9378 W. Augusta Ave.', 'West Deptford', 	'NJ', 	08096, 	'(214) 730-0298'),
('Aurore Lipton', 		'762 Wild Rose Street', 'Saginaw',		 	'MI', 	48601, 	'(377) 507-0974'),
('Zachery Luechtefeld', '7 Poplar Dr.',		 	'Arvada', 			'CO', 	80003, 	'(814) 485-2615'),
('Jeremiah Pendergrass','70 Oakwood St.',		'Zion',		 		'IL', 	60099, 	'(279) 491-0960'),
('Walter Holaway', 		'7556 Arrowhead St.',	'Cumberland', 		'RI', 	02864, 	'(446) 396-6785'),
('Wilfred Vise', 		'77 West Surrey Street', 'Oswego', 			'NY', 	13126, 	'(834) 727-1001'),
('Maritza Tilton', 		'939 Linda Rd.', 		'Burke', 			'VA', 	22015, 	'(446) 351-6860'),
('Joleen Tison', 		'87 Queen St.',		 	'Drexel Hill', 		'PA', 	19026, 	'(231) 893-2755');

INSERT INTO Reservations (Room, `Name`, Adults, Kids, StartDate, EndDate, TotalCost) VALUES
(308, 	'Mack Simmer', 			1, 	0, 	'2/2/2023', 	'2/4/2023', 	'$299.98'),
(203, 	'Bettyann Seery', 		2, 	1, 	'2/5/2023', 	'2/10/2023', 	'$999.95'),
(305, 	'Duane Cullison', 		2, 	0, 	'2/22/2023', 	'2/24/2023', 	'$349.98'),
(201, 	'Karie Yang', 			2, 	2, 	'3/6/2023', 	'3/7/2023', 	'$199.99'),
(307, 	'Kenji Kaenbyou', 		1, 	1, 	'3/17/2023', 	'3/20/2023', 	'$524.97'),
(302, 	'Aurore Lipton', 		3, 	0, 	'3/18/2023', 	'3/23/2023', 	'$924.95'),
(202, 	'Zachery Luechtefeld', 	2, 	2, 	'3/29/2023', 	'3/31/2023', 	'$349.98'),
(304, 	'Jeremiah Pendergrass', 2, 	0, 	'3/31/2023', 	'4/5/2023', 	'$874.95'),
(301, 	'Walter Holaway', 		1, 	0, 	'4/9/2023', 	'4/13/2023', 	'$799.96'),
(207, 	'Wilfred Vise', 		1, 	1, 	'4/23/2023', 	'4/24/2023', 	'$174.99'),
(401, 	'Maritza Tilton', 		2, 	4, 	'5/30/2023', 	'6/2/2023', 	'$1,199.97'),
(206, 	'Joleen Tison', 		2, 	0, 	'6/10/2023', 	'6/14/2023', 	'$599.96'),
(208, 	'Joleen Tison', 		1, 	0, 	'6/10/2023', 	'6/14/2023', 	'$599.96'),
(304, 	'Aurore Lipton', 		3, 	0, 	'6/17/2023', 	'6/18/2023', 	'$184.99'),
(205, 	'Kenji Kaenbyou', 		2, 	0,	'6/28/2023', 	'7/2/2023', 	'$699.96'),
(204, 	'Walter Holaway', 		3, 	1, 	'7/13/2023', 	'7/14/2023', 	'$184.99'),
(401, 	'Wilfred Vise', 		4, 	2, 	'7/18/2023', 	'7/21/2023', 	'$1,259.97'),
(303, 	'Bettyann Seery', 		2, 	1, 	'7/28/2023', 	'7/29/2023', 	'$199.99'),
(305, 	'Bettyann Seery', 		1, 	0, 	'8/30/2023', 	'9/1/2023', 	'$349.98'),
(208, 	'Mack Simmer' ,			2, 	0, 	'9/16/2023', 	'9/17/2023', 	'$149.99'),
(203, 	'Karie Yang', 			2, 	2, 	'9/13/2023', 	'9/15/2023', 	'$399.98'),
(401, 	'Duane Cullison', 		2, 	2, 	'11/22/2023', 	'11/25/2023', 	'$1,199.97'),
(206, 	'Mack Simmer', 			2, 	0, 	'11/22/2023', 	'11/25/2023', 	'$449.97'),
(301, 	'Mack Simmer', 			2, 	2, 	'11/22/2023', 	'11/25/2023', 	'$599.97'),
(302, 	'Maritza Tilton', 		2, 	0, 	'12/24/2023', 	'12/28/2023',	'$699.96');

DELETE FROM Reservations
WHERE ResID = 8;
DELETE FROM Guests
-- WHERE GuestID = 8;
where `name` = 'Jeremiah Pendergrass';