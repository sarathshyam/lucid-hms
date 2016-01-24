CREATE TABLE hms_room_category
(
   category_id numeric(50) NOT NULL, 
   category_name character varying(20), 
   CONSTRAINT hms_room_category_pk PRIMARY KEY (category_id)
);

CREATE TABLE hms_room
(
   hotel_id character varying(20), 
   room_number character varying(20), 
   room_category numeric(50),
   floor character varying(5),  
   remarks character varying(100), 
   CONSTRAINT hms_room_pk PRIMARY KEY (hotel_id, room_number)
); 

ALTER TABLE hms_room
  ADD CONSTRAINT hms_room_fk FOREIGN KEY (room_category) REFERENCES hms_room_category (category_id);


CREATE TABLE hms_room_reservation
(
   hotel_id character varying(20),
   reservation_id numeric(50),   
   room_number character varying(20), 
   status numeric(20),
   start_date timestamp with time zone,
   end_date timestamp with time zone,
   created_by_agent character varying(10),   
   remarks character varying(500),
   CONSTRAINT hms_room_reservation_pk PRIMARY KEY (hotel_id, reservation_id)
); 

ALTER TABLE hms_room_reservation
  ADD CONSTRAINT hms_room_reservation_fk FOREIGN KEY (hotel_id, room_number) REFERENCES hms_room (hotel_id, room_number);  

CREATE TABLE hms_customer
(
   customer_id numeric(50), 
   title character varying(5), 
   first_name character varying(25), 
   middle_name character varying(25), 
   last_name character varying(25),
   add_street character varying(100), 
   add_city character varying(100),
   add_state character varying(100),
   add_country character varying(100),
   add_zip character varying(10),
   phone_home character varying(20),
   phone_work character varying(20),
   phone_mobile character varying(20),
   email character varying(100),
   dob date,
   CONSTRAINT hms_customer_pk PRIMARY KEY (customer_id)
); 

CREATE TABLE hms_bookings_main
(
   booking_id character varying(20), 
   hotel_id character varying(20), 
   customer_id numeric(50), 
   booking_date timestamp with time zone,
   booking_start_date timestamp with time zone,
   booking_end_date timestamp with time zone,
   status character varying(20), 
   booked_by_agent character varying(10),
   remarks character varying(1000),   
   CONSTRAINT hms_bookings_main_pk PRIMARY KEY (booking_id)
); 

ALTER TABLE hms_bookings_main
  ADD CONSTRAINT hms_bookings_main_fk FOREIGN KEY (customer_id) REFERENCES hms_customer (customer_id);


CREATE TABLE hms_bookings_room
(
   id numeric(50),
   booking_id character varying(20), 
   hotel_id character varying(20), 
   reservation_id numeric(50), 
   extras character varying(1000),   
   CONSTRAINT hms_bookings_room_pk PRIMARY KEY (id)
); 

ALTER TABLE hms_bookings_room
  ADD CONSTRAINT hms_bookings_room_fk1 FOREIGN KEY (booking_id) REFERENCES hms_bookings_main (booking_id);
ALTER TABLE hms_bookings_room
  ADD CONSTRAINT hms_bookings_room_fk2 FOREIGN KEY (hotel_id, reservation_id) REFERENCES hms_room_reservation (hotel_id, reservation_id);

CREATE TABLE hms_bookings_room_guest
(
   id numeric(50),
   booking_id character varying(20), 
   hotel_id character varying(20), 
   booking_room_id numeric(50), 
   title character varying(5), 
   first_name character varying(25), 
   middle_name character varying(25), 
   last_name character varying(25),
   add_street character varying(100), 
   add_city character varying(100),
   add_state character varying(100),
   add_country character varying(100),
   add_zip character varying(10),
   phone_home character varying(20),
   phone_work character varying(20),
   phone_mobile character varying(20),
   email character varying(100),
   dob date,
   remarks character varying(1000),   
   CONSTRAINT hms_bookings_room_guest_pk PRIMARY KEY (id)
); 

ALTER TABLE hms_bookings_room_guest
  ADD CONSTRAINT hms_bookings_room_guest_fk FOREIGN KEY (booking_room_id) REFERENCES hms_bookings_room (id);


