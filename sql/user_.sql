CREATE TABLE public."user" (
	id bigserial NOT NULL,
	email varchar(255) NULL,
	last_name varchar(255) NULL,
	"name" varchar(255) NULL,
	ev_id int8 NULL,
	CONSTRAINT user_pkey PRIMARY KEY (id),
	CONSTRAINT fk6ds5reuwsofmxtcgf57waqnyf FOREIGN KEY (ev_id) REFERENCES ev(id)
);


INSERT INTO public."user" (id,email,last_name,"name",ev_id) VALUES 
(1,'j.doe@nuvve.com','Doe','John',1)
,(2,'t.stark@nuvve.com','Stark','Tony',1)
,(3,'b.simpson@nuvve.com','Simpson','Bart',2)
,(4,'b.wane@nuvve.com','Wane','Bruce',3)
;
